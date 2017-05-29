package gr.uoa.di.services;

import gr.uoa.di.entities.UsersEntity;

public interface UserService {
    void save(UsersEntity user);

    UsersEntity findByUsername(String username);
}