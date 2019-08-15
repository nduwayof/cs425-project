package com.ugandaairlines.ugair.security.service;

import com.ugandaairlines.ugair.security.domain.PrincipalDetails;
import com.ugandaairlines.ugair.security.domain.User;
import com.ugandaairlines.ugair.security.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * The type User details service implementation.
 * @author nduwayofabrice
 */
@Service
@Transactional
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with the following email : " + username + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String [] userRoles = user.getRoles().stream().map(role -> role.getUserRole().name()).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }
}
