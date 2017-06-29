package gr.uoa.di.services;

import gr.uoa.di.entities.User;

public interface UserService {
    User save(User user);

    User update(User user);

    User findByUsername(String username);
}