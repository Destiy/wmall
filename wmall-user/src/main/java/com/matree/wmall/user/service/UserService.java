package com.matree.wmall.user.service;

import com.matree.wmall.user.bean.UmsMember;
import com.matree.wmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(Integer memberId);
}
