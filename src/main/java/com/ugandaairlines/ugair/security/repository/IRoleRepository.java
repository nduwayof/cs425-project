package com.ugandaairlines.ugair.security.repository;

import com.ugandaairlines.ugair.security.domain.EUserRole;
import com.ugandaairlines.ugair.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByUserRole(EUserRole userRole);
}
