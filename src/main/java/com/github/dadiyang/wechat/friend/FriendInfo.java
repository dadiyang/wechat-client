package com.github.dadiyang.wechat.friend;

import com.github.dadiyang.wechat.user.UserInfo;
import lombok.Data;

/**
 * 好友数据
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class FriendInfo extends UserInfo {
    private String category;
}
