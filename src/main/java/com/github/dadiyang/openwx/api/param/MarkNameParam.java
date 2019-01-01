package com.github.dadiyang.openwx.api.param;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改好友或群成员备注名称
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
@NoArgsConstructor
public class MarkNameParam {
    private String client;
    /**
     * 好友或群成员的id
     */
    private String id;
    /**
     * 好友的帐号
     */
    private String account;
    /**
     * 好友当前显示名称
     */
    private String displayname;
    /**
     * 好友当前备注名称
     */
    private String markname;
    /**
     * 设置的新备注名称
     */
    @JSONField(name = "new_markname")
    private String newMarkname;

    public MarkNameParam(String client) {
        this.client = client;
    }
}
