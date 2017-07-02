package gr.uoa.di.application;

import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.UserRegisterForm;
import gr.uoa.di.services.UserService;

public class Auth {

    public static User createUser(UserService userService, UserRegisterForm registerForm, String role) {
        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setPassword(registerForm.getPassword());
        user.setEnabled(true);
        user.setRole(role);
        user = userService.save(user);

        return user;
    }
}
