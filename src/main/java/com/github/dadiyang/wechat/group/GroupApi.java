package com.github.dadiyang.wechat.group;

import com.github.dadiyang.httpinvoker.annotation.HttpApi;
import com.github.dadiyang.httpinvoker.annotation.HttpReq;
import com.github.dadiyang.httpinvoker.annotation.Param;
import com.github.dadiyang.wechat.param.SearchCriteria;
import com.github.dadiyang.wechat.param.DisplayNameParam;
import com.github.dadiyang.wechat.result.CreateGroupResult;
import com.github.dadiyang.wechat.result.Result;

import java.io.InputStream;
import java.util.List;

/**
 * 群组相关api
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@HttpApi(prefix = "${openwx.host}/openwx")
public interface GroupApi {
    /**
     * 搜索群组对象
     *
     * @param criteria 搜索接口需要的参数
     * @return 群组对象列表
     */
    @HttpReq("/search_group")
    List<GroupInfo> searchGroup(SearchCriteria criteria);

    /**
     * 获取群组数据
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @return 群组数据
     */
    @HttpReq("/get_group_info")
    List<GroupInfo> getGroupInfo(@Param("client") String client);

    /**
     * 获取群组基本数据
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @return 群组基本数据（不包含群成员）
     */
    @HttpReq("/get_group_basic_info")
    List<GroupInfo> getGroupBasicInfo(@Param("client") String client);

    /**
     * 获取群组头像
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @param id     群组的id
     * @return 头像文件的输入流
     */
    @HttpReq("/get_avatar")
    InputStream getAvatar(@Param("client") String client, @Param("id") String id);

    /**
     * 创建群组
     *
     * @param client      自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @param friends     好友的id（多个好友id用逗号分割）
     * @param displayname 好友的id（多个好友id用逗号分割）
     * @return group_id
     */
    @HttpReq(value = "/create_group", method = "POST")
    CreateGroupResult createCroup(@Param("client") String client, @Param("friends") String friends, @Param("displayname") String displayname);

    /**
     * 邀请好友入群
     *
     * @param client      自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @param friends     好友的id（多个好友id用逗号分割）
     * @param id          群组对象的id
     * @param displayname 好友的id（多个好友id用逗号分割）
     * @return 结果
     */
    @HttpReq(value = "/invite_friend", method = "POST")
    Result inviteFriend(@Param("client") String client, @Param("friends") String friends, @Param("id") String id, @Param("displayname") String displayname);

    /**
     * 移除群组成员
     *
     * @param client  自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @param members 好友的id（多个好友id用逗号分割）
     * @param id      群组对象的id
     * @return 结果
     */
    @HttpReq(value = "/kick_group_member", method = "POST")
    Result kickGroupMember(@Param("client") String client, @Param("members") String members, @Param("id") String id);

    /**
     * 设置群组的显示名称
     *
     * @param displayNameParam 设置群组的显示名称所需要参数
     * @return 结果
     */
    @HttpReq(value = "/set_group_displayname", method = "POST")
    Result setGroupDisplayname(DisplayNameParam displayNameParam);
}
