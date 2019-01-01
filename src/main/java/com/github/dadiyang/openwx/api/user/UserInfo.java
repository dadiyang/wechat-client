package com.github.dadiyang.openwx.api.user;

import lombok.Data;

/**
 * 用户数据
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
public class UserInfo {
    private String account;
    private String name;
    private String markname;
    private String sex;
    private String display;
    private String city;
    private String signature;
    private String province;
    private String id;
    private long uid;
    private String displayname;
}
