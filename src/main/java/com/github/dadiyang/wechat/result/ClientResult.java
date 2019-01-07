package com.github.dadiyang.wechat.result;

import lombok.Data;

/**
 * 启动或停止一个客户端的结果
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class ClientResult extends Result {
    private String client;
    private int pid;
    private int port;
}
