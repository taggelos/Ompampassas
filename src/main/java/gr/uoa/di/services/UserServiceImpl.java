package gr.uoa.di.services;

import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.entities.TaxOffice;
import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.ParentRegisterForm;
import gr.uoa.di.forms.auth.ProviderRegisterForm;
import gr.uoa.di.forms.auth.UserRegisterForm;
import gr.uoa.di.repositories.TaxOfficeRepository;
import gr.uoa.di.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository mUserRepository;
    @Autowired
    private BCryptPasswordEncoder mBCryptPasswordEncoder;
    @Autowired
    private ProviderMetadataService providerMetadataService;
    @Autowired
    private TaxOfficeRepository taxOfficeRepository;
    @Autowired
    private ParentMetadataService mParentMetadataService;

    @Override
    public User save(User user) {
        user.setPassword(mBCryptPasswordEncoder.encode(user.getPassword()));
        return mUserRepository.save(user);
    }

    @Override
    public User update(User user) {
        return mUserRepository.save(user);
    }

    @Override
    public User findByUsername(String email) {
        return mUserRepository.findByEmail(email);
    }


    public User createProvider(ProviderRegisterForm registerForm) {
        User user = createUser(registerForm, "ROLE_PROVIDER");
        createMetadata(registerForm, user);

        return user;
    }

    public User createParent(ParentRegisterForm registerForm) {
        User user = createUser(registerForm, "ROLE_PARENT");
        createMetadata(registerForm, user);

        return user;
    }

    private User createUser(UserRegisterForm registerForm, String role) {
        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setPassword(registerForm.getPassword());
        user.setEnabled(true);
        user.setRole(role);
        user = this.save(user);

        return user;
    }

    private ParentMetadata createMetadata(ParentRegisterForm registerForm, User user) {
        ParentMetadata metadata = new ParentMetadata();
        metadata.setUserId(user.getId());
        metadata.setFirstName(registerForm.getName());
        metadata.setLastName(registerForm.getSurname());
        metadata.setPhone(registerForm.getPhone());
        metadata = mParentMetadataService.save(metadata);

        return metadata;
    }

    private ProviderMetadata createMetadata(ProviderRegisterForm registerForm, User user) {
        TaxOffice taxOffice = taxOfficeRepository.findOne(registerForm.getTaxOfficeId());

        ProviderMetadata metadata = new ProviderMetadata();
        metadata.setUserId(user.getId());
        metadata.setTitle(registerForm.getTitle());
        metadata.setCompanyName(registerForm.getCompanyName());
        metadata.setVatNumber(registerForm.getVatNumber());
        metadata.setTaxOfficeByTaxOfficeId(taxOffice);
        metadata.setPhone(registerForm.getPhone());
        metadata.setFax(registerForm.getFax());
        metadata.setAddress(registerForm.getAddress());
        metadata.setZipCode(registerForm.getZipCode());
        metadata.setRegion(registerForm.getRegion());
        metadata.setCity(registerForm.getCity());
        providerMetadataService.save(metadata);

        return metadata;
    }
}