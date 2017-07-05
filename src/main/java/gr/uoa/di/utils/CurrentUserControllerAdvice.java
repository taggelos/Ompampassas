package gr.uoa.di.utils;

import gr.uoa.di.entities.User;
import gr.uoa.di.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CurrentUserControllerAdvice {
    @Autowired
    private UserRepository mUserRepository;

    @ModelAttribute("currentUser")
    public User getCurrentUser(Authentication authentication) {
        if (authentication == null)
            return null;

        UserDetails details = (UserDetails) authentication.getPrincipal();

        return mUserRepository.findByEmail(details.getUsername());
    }

    @ModelAttribute("contactus")
    public String getContactUs() {
        return getRealContactUs().replace("@", "[at]").replace(".", "[dot]");
    }

    @ModelAttribute("realcontactus")
    public String getRealContactUs() {
        return "ompampassas@ompampassas.com";
    }
}