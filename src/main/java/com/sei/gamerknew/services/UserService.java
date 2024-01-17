package com.sei.gamerknew.services;

import com.sei.gamerknew.entities.Bio;
import com.sei.gamerknew.entities.User;

import java.util.List;

public interface UserService {
    User findByUserName(String username);

    void register(User user);

    User findByUserId(String userId);

    void updateUser(User user);

    void uploadAvatar(Bio bio);

    List<User> getUser();

    void delUser(User user);
}
