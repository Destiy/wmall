package com.matree.wmall.user.service.impl;

import com.matree.wmall.user.bean.UmsMember;
import com.matree.wmall.user.mapper.UserMapper;
import com.matree.wmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMemberList = userMapper.selectAll();/*userMapper.selectAllUser();*/
        return umsMemberList;
    }
}
