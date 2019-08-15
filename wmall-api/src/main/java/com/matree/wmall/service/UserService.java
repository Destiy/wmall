package com.matree.wmall.service;

import com.matree.wmall.bean.UmsMember;
import com.matree.wmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(Integer memberId);
}
