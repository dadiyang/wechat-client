package com.github.dadiyang.openwx.api.message;

import com.github.dadiyang.httpinvoker.annotation.HttpApi;
import com.github.dadiyang.httpinvoker.annotation.HttpReq;
import com.github.dadiyang.openwx.api.param.ConsultParam;
import com.github.dadiyang.openwx.api.param.SendFriendMsgParam;
import com.github.dadiyang.openwx.api.param.SendGroupMsgParam;
import com.github.dadiyang.openwx.api.result.ConsultResult;
import com.github.dadiyang.openwx.api.result.SendMsgResult;

/**
 * 消息相关的API
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@HttpApi(prefix = "${openwx.host}/openwx")
public interface MessageApi {

    /**
     * 撤回消息
     *
     * @param client 客户端id
     * @param id     消息的id
     */
    @HttpReq(value = "/revoke_message", method = "POST")
    void revokeMessage(String client, String id);

    /**
     * 发送好友消息
     *
     * @param sendFriendMsgParam 发消息所需参数
     * @return 发送结果
     */
    @HttpReq(value = "/send_friend_message", method = "POST")
    SendMsgResult sendFriendMessage(SendFriendMsgParam sendFriendMsgParam);

    /**
     * 发送群消息
     *
     * @param sendGroupMsgParam 发消息所需参数
     * @return 发送结果
     */
    @HttpReq(value = "/send_group_message", method = "POST")
    SendMsgResult sendGroupMessage(SendGroupMsgParam sendGroupMsgParam);

    /**
     * 发送消息给好友并等待好友回答
     *
     * @param consultParam 所需参数
     * @return 结果，注意超时失败时返回的code也是0，说明请求是成功了，但是没有在指定的时间内得到回复，此时reply为null,replyStatus说明为什么失败
     */
    @HttpReq(value = "/consult", method = "POST")
    ConsultResult consult(ConsultParam consultParam);

}
