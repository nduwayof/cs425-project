package com.ugandaairlines.ugair.security.repository;

import com.ugandaairlines.ugair.security.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository("userRepository")
public interface IUserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
