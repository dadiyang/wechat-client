package com.github.dadiyang.wechat.friend;

import com.github.dadiyang.httpinvoker.annotation.HttpApi;
import com.github.dadiyang.httpinvoker.annotation.HttpReq;
import com.github.dadiyang.httpinvoker.annotation.Param;
import com.github.dadiyang.wechat.param.AcceptFriendParam;
import com.github.dadiyang.wechat.param.SearchCriteria;
import com.github.dadiyang.wechat.param.MarkNameParam;
import com.github.dadiyang.wechat.result.AcceptFriendResult;
import com.github.dadiyang.wechat.result.Result;

import java.io.InputStream;
import java.util.List;

/**
 * 好友相关接口
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@HttpApi(prefix = "${wechat.host}/openwx")
public interface FriendApi {
    /**
     * 搜索好友对象
     *
     * @param criteria 搜索接口需要的参数
     * @return 好友信息列表
     */
    @HttpReq(value = "/search_friend", method = "POST")
    List<FriendInfo> searchFriend(SearchCriteria criteria);

    /**
     * 获取好友数据
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @return 好友数据
     */
    @HttpReq("/get_friend_info")
    List<FriendInfo> getFriendInfo(@Param("client") String client);

    /**
     * 获取用户头像
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @param id     用户的id
     * @return 头像文件的输入流
     */
    @HttpReq("/get_avatar")
    InputStream getAvatar(@Param("client") String client, @Param("id") String id);

    /**
     * 修改好友或群成员备注名称
     *
     * @param markNameParam 所需要参数
     * @return 结果
     */
    @HttpReq(value = "/set_markname", method = "POST")
    Result setMarkname(MarkNameParam markNameParam);

    /**
     * 设置或取消群组、好友置顶
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @param id     群组或好友的id
     * @param op     1表示置顶,0表示取消置顶
     * @return 结果
     */
    @HttpReq(value = "/stick", method = "POST")
    Result stick(@Param("client") String client, @Param("id") String id, @Param("op") int op);

    /**
     * 向指定的群成员发送好友请求
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @param id     群成员的id
     * @param verify 好友请求的附加信息
     * @return 结果
     */
    @HttpReq(value = "/make_friend", method = "POST")
    Result makeFriend(@Param("client") String client, @Param("id") String id, @Param("verify") String verify);

    /**
     * 接受好友验证申请
     *
     * @param acceptFriendParam 所需参数
     * @return 结果
     */
    @HttpReq(value = "/accept_friend_request", method = "POST")
    AcceptFriendResult acceptFriendRequest(AcceptFriendParam acceptFriendParam);

}
