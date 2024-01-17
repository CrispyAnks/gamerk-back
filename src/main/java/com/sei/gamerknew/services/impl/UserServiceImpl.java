package com.sei.gamerknew.services.impl;

import com.sei.gamerknew.entities.Bio;
import com.sei.gamerknew.entities.User;
import com.sei.gamerknew.mapper.BioMapper;
import com.sei.gamerknew.mapper.UserMapper;
import com.sei.gamerknew.services.UserService;
import com.sei.gamerknew.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BioMapper bioMapper;
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(User user) {
        String md5Psw = MD5Util.generateMD5(user.getPassword());
        bioMapper.add(user.getBioid(), user.getGender(), user.getIntro(), user.getImgsrc());
        userMapper.add(user.getUserid(), user.getUsername(), md5Psw, user.getBioid(), user.getNickname());
    }

    @Override
    public User findByUserId(String userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user.getUserid(), user.getNickname());
    }

    @Override
    public void uploadAvatar(Bio bio) {
        bioMapper.updateAva(bio.getImgsrc());
    }

    @Override
    public List<User> getUser() {
        return userMapper.getUsers();
    }

    @Override
    public void delUser(User user) {
        userMapper.delUser(user.getUserid());
        bioMapper.delBio(user.getBioid());
    }
}
