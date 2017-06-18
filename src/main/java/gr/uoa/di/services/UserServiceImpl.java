package gr.uoa.di.services;

import gr.uoa.di.entities.User;
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

    @Override
    public void save(User user) {
        user.setPassword(mBCryptPasswordEncoder.encode(user.getPassword()));
        mUserRepository.save(user);
    }

    @Override
    public void update(User user) {
        mUserRepository.save(user);
    }
    @Override
    public User findByUsername(String email) {
        return mUserRepository.findByEmail(email);
    }
}