package gr.uoa.di.services;

import gr.uoa.di.entities.UsersEntity;
import gr.uoa.di.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository mUsersRepository;
    @Autowired
    private BCryptPasswordEncoder mBCryptPasswordEncoder;

    @Override
    public void save(UsersEntity user) {
        user.setPassword(mBCryptPasswordEncoder.encode(user.getPassword()));
        mUsersRepository.save(user);
    }

    @Override
    public UsersEntity findByUsername(String email) {
        return mUsersRepository.findByEmail(email);
    }
}