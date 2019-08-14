package com.ugandaairlines.ugair.security.service;

import com.ugandaairlines.ugair.security.domain.PrincipalDetails;
import com.ugandaairlines.ugair.security.domain.User;
import com.ugandaairlines.ugair.security.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type User details service implementation.
 * @author nduwayofabrice
 */
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImplementation.class);

    private IUserRepository userRepository;

    /**
     * Instantiates a new User details service implementation.
     *
     * @param userRepository the user repository
     */
    @Autowired
    public UserDetailsServiceImplementation(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetailsServiceImplementation() {
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email){
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        LOGGER.info("loadUserByUsername() : {}", email);
        return new PrincipalDetails(user);
    }
}
