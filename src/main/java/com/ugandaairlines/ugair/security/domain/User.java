package com.ugandaairlines.ugair.security.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAMES", nullable = false)
    private String names;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", nullable = false)
    private EUserType userType;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active = Boolean.TRUE;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;

    @Override
    public String toString() {
        return new StringJoiner(", ", "User" + "[", "]")
                .add("id=" + id)
                .add("names='" + names + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("userType=" + userType)
                .add("active=" + active)
                .add("roles=" + roles)
                .toString();
    }
}
