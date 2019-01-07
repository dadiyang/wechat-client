package com.github.dadiyang.wechat.client;

import com.github.dadiyang.httpinvoker.annotation.HttpApi;
import com.github.dadiyang.httpinvoker.annotation.HttpReq;
import com.github.dadiyang.httpinvoker.annotation.Param;
import com.github.dadiyang.wechat.result.ClientResult;

import java.io.InputStream;

/**
 * 程序运行相关接口
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@HttpApi(prefix = "${wechat.host}/openwx")
public interface ClientApi {
    /**
     * 获取进程运行信息
     *
     * @param client 客户端id
     * @return 运行信息
     */
    @HttpReq("/get_client_info")
    ClientInfo getClientInfo(@Param("client") String client);

    /**
     * 终止客户端运行
     *
     * @param client 客户端id
     * @return 运行信息
     */
    @HttpReq("/stop_client")
    ClientResult stopClient(@Param("client") String client);

    /**
     * 启动一个客户端
     *
     * @param client 客户端id
     * @return 运行信息
     */
    @HttpReq("/start_client")
    ClientResult startClient(@Param("client") String client);

    /**
     * 获取登录二维码文件
     *
     * @param client 客户端id
     * @return 二维码文件输入流
     */
    @HttpReq("/get_qrcode")
    InputStream getQrcode(@Param("client") String client);


}
