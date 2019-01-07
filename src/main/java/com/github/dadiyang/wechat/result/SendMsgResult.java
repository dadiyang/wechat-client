package com.github.dadiyang.wechat.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 接受好友请求返回结果
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class SendMsgResult extends Result {
    @JSONField(name = "msg_id")
    private String msgId;
    @JSONField(name = "media_id")
    private String mediaId;
}
