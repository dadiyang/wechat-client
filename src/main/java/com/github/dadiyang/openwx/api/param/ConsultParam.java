package com.github.dadiyang.openwx.api.param;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 发送消息给好友并等待好友回答参数
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
public class ConsultParam {
    /**
     * 好友的id
     */
    private String id;
    /**
     * 好友显示名称
     */
    private String displayname;
    /**
     * 好友备注名称
     */
    private String markname;
    /**
     * 等待回复的时间，默认30秒
     */
    private String timeout;
    /**
     * 媒体路径(可以是文件路径或url)
     */
    @JSONField(name = "media_path")
    private String mediaPath;

}
