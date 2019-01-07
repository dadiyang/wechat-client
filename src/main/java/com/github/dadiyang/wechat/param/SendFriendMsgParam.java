package com.github.dadiyang.wechat.param;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 发送好友消息所需参数
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class SendFriendMsgParam {
    private String client;
    /**
     * 好友的id
     */
    private String id;
    /**
     * 好友的帐号
     */
    private String account;
    /**
     * 好友显示名称
     */
    private String displayname;
    /**
     * 好友备注名称
     */
    private String markname;
    /**
     * 发送的文本内容
     */
    private String content;
    /**
     * 媒体id(发送媒体消息返回的媒体id)
     */
    @JSONField(name = "media_id")
    private String mediaId;
    /**
     * 媒体路径(可以是文件路径或url)
     */
    @JSONField(name = "media_path")
    private String mediaPath;
    /**
     * 0或1,可选,是否异步发送消息
     */
    private String async;
}
