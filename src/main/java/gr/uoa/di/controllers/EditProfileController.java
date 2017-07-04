package gr.uoa.di.controllers;

import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.entities.TaxOffice;
import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.EditParentProfileForm;
import gr.uoa.di.forms.auth.EditProviderProfileForm;
import gr.uoa.di.services.ParentMetadataService;
import gr.uoa.di.services.ProviderMetadataService;
import gr.uoa.di.services.UserService;
import gr.uoa.di.utils.DatabaseUtils;
import gr.uoa.di.utils.exceptions.ResourceNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class EditProfileController {
    @Autowired
    private UserService mUserService;
    @Autowired
    private ParentMetadataService parentMetadataService;
    @Autowired
    private ProviderMetadataService providerMetadataService;
    @Autowired
    private BCryptPasswordEncoder mBCryptPasswordEncoder;
    @Autowired
    private Validator mValidator;

    @GetMapping({"/editprofile", "/editprofile/{urlname:.+}"})
    public ModelAndView getEditprofile(@PathVariable(required = false) String urlname, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = mUserService.findByUsername(auth.getName());
        User user = null;

        // Only allow admins to change other users' profiles.
        if (urlname != null) {
            user = mUserService.findByUsername(urlname);
        }

        if (user == null) {
            throw new ResourceNotFoundException();
        }

        boolean sameUser = (currentUser.getId() == user.getId());
        if (!currentUser.getRole().equals("ROLE_ADMIN") && !sameUser) {
            throw new ResourceNotFoundException();
        }

        user = (sameUser ? currentUser : user);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editprofile");

        if (user.getRole().equals("ROLE_PARENT")) {
            ParentMetadata metadata = user.getParentMetadataById();
            EditParentProfileForm form;
            // If we have flashed data (ie. from a failed validation), pass them into the view.
            if (model.asMap().get("form") != null)
                form = (EditParentProfileForm) model.asMap().get("form");
            else {
                form = new EditParentProfileForm();
                form.setName(metadata.getFirstName());
                form.setSurname(metadata.getLastName());
                form.setPhone(metadata.getPhone());
            }
            mav.addObject("form", form);
            mav.addObject("user", user);
            return mav;
        }
        else if (user.getRole().equals("ROLE_PROVIDER")) {
            Session session = DatabaseUtils.getSession();
            Query query = session.createQuery("from TaxOffice order by name asc");
            List<TaxOffice> taxOffices = (List<TaxOffice>) query.list();

            ProviderMetadata metadata = user.getProviderMetadataById();
            EditProviderProfileForm form;
            // If we have flashed data (ie. from a failed validation), pass them into the view.
            if (model.asMap().get("form") != null)
                form = (EditProviderProfileForm) model.asMap().get("form");
            else {
                form = new EditProviderProfileForm();
                form.setTitle(metadata.getTitle());
                form.setPhone(metadata.getPhone());
                form.setFax(metadata.getFax());
                form.setAddress(metadata.getAddress());
                form.setZipCode(metadata.getZipCode());
                form.setRegion(metadata.getRegion());
                form.setCity(metadata.getCity());
            }

            mav.addObject("user", user);
            mav.addObject("metadata", metadata);
            mav.addObject("form", form);
            mav.addObject("taxOffices", taxOffices);
            return mav;
        }
        else {
            mav.addObject("user", user);
            return mav;
        }
    }

    @PostMapping({"/editprofile/parent", "/editprofile/{urlname:.+}/parent"})
    public String postParentEditProfile(@PathVariable(required = false) String urlname,
                                        @ModelAttribute("editProfileForm") EditParentProfileForm form,
                                        BindingResult bindingResult,
                                        HttpServletRequest request,
                                        final RedirectAttributes redirectAttributes) {

        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        User user = mUserService.findByUsername(urlname);

        if (user == null || !user.getRole().equals("ROLE_PARENT")) {
            throw new ResourceNotFoundException();
        }

        Set<ConstraintViolation<EditParentProfileForm>> errors = mValidator.validate(form);

        if (!errors.isEmpty()) {
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("form", form);
            return "redirect:/editprofile/" + urlname;
        }

        ParentMetadata metadata = user.getParentMetadataById();
        metadata.setFirstName(form.getName());
        metadata.setLastName(form.getSurname());
        metadata.setPhone(form.getPhone());
        parentMetadataService.update(metadata);

        redirectAttributes.addFlashAttribute("message", "Οι αλλαγές σας αποθηκεύτηκαν επιτυχώς!");

        return "redirect:/editprofile/" + urlname;
    }

    @PostMapping({"/editprofile/provider", "/editprofile/{urlname:.+}/provider"})
    public String postProviderEditProfile(@PathVariable(required = false) String urlname,
                                          @ModelAttribute("editProfileForm") EditProviderProfileForm form,
                                          BindingResult bindingResult,
                                          HttpServletRequest request,
                                          final RedirectAttributes redirectAttributes) {

        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        User user = mUserService.findByUsername(urlname);

        if (user == null || !user.getRole().equals("ROLE_PROVIDER")) {
            throw new ResourceNotFoundException();
        }

        Set<ConstraintViolation<EditProviderProfileForm>> errors = mValidator.validate(form);

        if (!errors.isEmpty()) {
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("form", form);
            return "redirect:/editprofile/" + urlname;
        }

        ProviderMetadata metadata = user.getProviderMetadataById();
        metadata.setTitle(form.getTitle());
        metadata.setPhone(form.getPhone());
        metadata.setFax(form.getFax());
        metadata.setAddress(form.getAddress());
        metadata.setZipCode(form.getZipCode());
        metadata.setRegion(form.getRegion());
        metadata.setCity(form.getCity());
        providerMetadataService.update(metadata);

        redirectAttributes.addFlashAttribute("message", "Οι αλλαγές σας αποθηκεύτηκαν επιτυχώς!");

        return "redirect:/editprofile/" + urlname;
    }

    @PostMapping({"/profile/change_password", "/profile/change_password/{urlname:.+}"})
    public String postChangePassword(@PathVariable(required = false) String urlname,
                                     @RequestParam(value = "oldPassword", required = false) String oldPassword,
                                     @RequestParam(value = "newPassword") String newPassword,
                                     @RequestParam(value = "newPasswordConfirmation") String newPasswordConfirmation,
                                     HttpServletRequest request,
                                     final RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = mUserService.findByUsername(auth.getName());
        User user = null;

        // Only allow admins to change other users' profiles.
        if (urlname != null) {
            user = mUserService.findByUsername(urlname);
        }

        if (user == null) {
            throw new ResourceNotFoundException();
        }

        boolean sameUser = (currentUser.getId() == user.getId());
        if (!currentUser.getRole().equals("ROLE_ADMIN") && !sameUser) {
            throw new ResourceNotFoundException();
        }

        user = (sameUser ? currentUser : user);

        ArrayList<String> errors = new ArrayList<>();

        if ((sameUser && (oldPassword == null || oldPassword.equals(""))) ||
                newPassword == null || newPassword.equals("") ||
                newPasswordConfirmation == null || newPasswordConfirmation.equals("")) {
            errors.add("Παρακαλούμε συμπληρώστε όλα τα πεδία.");
        }

        if (newPassword == null || !newPassword.equals(newPasswordConfirmation)) {
            errors.add("Η Επιβεβαίωση Νέου Κωδικού Πρόσβασης πρέπει να ταυτίζεται με το Νέο Κωδικό Πρόσβασης.");
        }

        if (sameUser && !mBCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            errors.add("Ο Παλαιός Κωδικός Πρόσβασης δεν είναι σωστός.");
        }

        if (!errors.isEmpty()) {
            redirectAttributes.addFlashAttribute("passwordErrors", errors);
            return "redirect:/editprofile/" + urlname;
        }

        user.setPassword(mBCryptPasswordEncoder.encode(newPassword));
        mUserService.update(user);

        redirectAttributes.addFlashAttribute("message", "Ο Κωδικός Πρόσβασης άλλαξε επιτυχώς!");

        return "redirect:/editprofile/" + urlname;
    }
}