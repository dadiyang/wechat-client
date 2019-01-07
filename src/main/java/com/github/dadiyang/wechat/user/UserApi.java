package com.github.dadiyang.wechat.user;

import com.github.dadiyang.httpinvoker.annotation.HttpApi;
import com.github.dadiyang.httpinvoker.annotation.HttpReq;
import com.github.dadiyang.httpinvoker.annotation.Param;

/**
 * @author huangxuyang
 * date 2019/1/1
 */
@HttpApi(prefix = "${openwx.host}/openwx")
public interface UserApi {
    /**
     * 获取用户数据
     *
     * @param client 自定义微信帐号，用于唯一区分不同微信帐号客户端
     * @return 用户数据
     */
    @HttpReq("/get_user_info")
    UserInfo getUserInfo(@Param("client") String client);

}
