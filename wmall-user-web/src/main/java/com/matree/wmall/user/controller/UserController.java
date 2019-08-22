package com.matree.wmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.matree.wmall.bean.UmsMember;
import com.matree.wmall.bean.UmsMemberReceiveAddress;
import com.matree.wmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @create 2019-08-23 0:14
 */
@Controller
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    @RequestMapping("/getReceive")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(Integer memberId){
        List<UmsMemberReceiveAddress> receiveAddress = userService.getReceiveAddressByMemberId(memberId);
        return receiveAddress;
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }
}
