package com.ugandaairlines.ugair.security.service.implementation;

import com.ugandaairlines.ugair.security.domain.User;
import com.ugandaairlines.ugair.security.repository.IUserRepository;
import com.ugandaairlines.ugair.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public void registerUsers(List<User> users) {
        this.userRepository.saveAll(users);
    }
}
