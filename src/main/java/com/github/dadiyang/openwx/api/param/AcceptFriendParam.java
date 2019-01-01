package com.github.dadiyang.openwx.api.param;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接受好友请求所需参数
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
@NoArgsConstructor
public class AcceptFriendParam {
    private String client;
    /**
     * 申请者id（frient_request事件中会提供）
     */
    private String id;
    /**
     * 申请者显示名称（frient_request事件中会提供）
     */
    private String displayname;
    /**
     * 接受申请需要的ticket（frient_request事件中会提供）
     */
    private String ticket;

    public AcceptFriendParam(String client, String ticket) {
        this.client = client;
        this.ticket = ticket;
    }
}
