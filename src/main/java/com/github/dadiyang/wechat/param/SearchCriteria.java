package com.github.dadiyang.wechat.param;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 搜索条件
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
@NoArgsConstructor
public class SearchCriteria {
    private String client;
    /**
     * 好友或群组的id
     */
    private String id;
    /**
     * 好友或群组的显示名称
     */
    private String displayname;
    /**
     * 好友的帐号
     */
    private String account;
    /**
     * 好友备注名称
     */
    private String markname;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;

    public SearchCriteria(String client) {
        this.client = client;
    }
}
