package com.ugandaairlines.ugair.security.service;

import com.ugandaairlines.ugair.security.domain.User;

import java.util.List;

public interface IUserService {
    User registerUser(User user);
    void registerUsers(List<User> users);
}
