package com.ugandaairlines.ugair.security.repository;

import com.ugandaairlines.ugair.security.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface IUserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
