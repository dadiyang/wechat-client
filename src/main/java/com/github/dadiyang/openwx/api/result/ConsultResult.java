package com.github.dadiyang.openwx.api.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 发送消息给好友并等待好友回答结果
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
public class ConsultResult extends Result {
    /**
     * 得到的回复
     */
    private String reply;
    @JSONField(name = "msg_id")
    private String msgId;
    @JSONField(name = "reply_status")
    private String replyStatus;
}
