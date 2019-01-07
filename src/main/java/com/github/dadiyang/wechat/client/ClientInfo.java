package com.github.dadiyang.wechat.client;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 获取进程运行信息
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class ClientInfo {
    private int code;
    private String account;
    private String state;
    private int port;

    private String tmpdir;
    private String cookiePath;
    private String pidPath;
    private String qrcodePath;
    private String statePath;
    private String downloadMedia;

    private String logEncoding;
    private String logLevel;
    private String logPath;
    private String os;
    private int pid;
    private int runtime;
    private int starttime;
    private String status;
    private String httpDebug;
    private String version;
    private List<Map<String, Object>> plugin;
}
