package com.github.dadiyang.wechat.group;

import com.github.dadiyang.wechat.friend.FriendInfo;
import lombok.Data;

import java.util.List;

/**
 * 群组数据
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class GroupInfo {
    private String name;
    private String id;
    private long uid;
    private String displayname;
    private List<FriendInfo> member;
}
