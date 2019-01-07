package com.github.dadiyang.wechat.result;

import lombok.Data;

/**
 * 接受好友请求返回结果
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class AcceptFriendResult extends Result {
    private String id;
    private String displayname;
    private String ticket;
}
