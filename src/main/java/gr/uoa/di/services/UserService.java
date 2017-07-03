package gr.uoa.di.services;

import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.ParentRegisterForm;
import gr.uoa.di.forms.auth.ProviderRegisterForm;

public interface UserService {
    User save(User user);

    User update(User user);

    User findByUsername(String username);

    User createProvider(ProviderRegisterForm registerForm);

    User createParent(ParentRegisterForm registerForm);
}