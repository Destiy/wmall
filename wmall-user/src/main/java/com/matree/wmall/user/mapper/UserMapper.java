package com.matree.wmall.user.mapper;

import com.matree.wmall.user.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();
}
