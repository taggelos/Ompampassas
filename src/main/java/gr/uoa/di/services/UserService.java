package gr.uoa.di.services;

import gr.uoa.di.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}