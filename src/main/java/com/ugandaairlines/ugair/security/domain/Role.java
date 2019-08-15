package com.ugandaairlines.ugair.security.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Data
@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private EUserRole userRole;

    @ManyToMany(fetch = FetchType.EAGER,
            mappedBy = "roles")
    private List<User> users;

    @Override
    public String toString() {
        return new StringJoiner(", ", Role.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userRole=" + userRole)
                .add("users=" + users)
                .toString();
    }
}