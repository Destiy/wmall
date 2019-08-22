package com.matree.wmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.matree.wmall.bean.UmsMember;
import com.matree.wmall.bean.UmsMemberReceiveAddress;
import com.matree.wmall.service.UserService;
import com.matree.wmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.matree.wmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMemberList = userMapper.selectAll();/*userMapper.selectAllUser();*/
        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(Integer memberId) {
        UmsMemberReceiveAddress address = new UmsMemberReceiveAddress();
        address.setMemberId(String.valueOf(memberId));

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(address);
        return umsMemberReceiveAddresses;
    }

}
