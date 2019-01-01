package com.github.dadiyang.openwx.api.friend;

import com.github.dadiyang.openwx.api.user.UserInfo;
import lombok.Data;

/**
 * 好友数据
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
public class FriendInfo extends UserInfo {
    private String category;
}
