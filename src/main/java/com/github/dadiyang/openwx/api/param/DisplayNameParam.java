package com.github.dadiyang.openwx.api.param;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 显示名称修改所需参数
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
public class DisplayNameParam {
    private String client;
    /**
     * 群组的id
     */
    private String id;
    /**
     * 群组当前显示名称
     */
    private String displayname;
    /**
     * 设置的新显示名称
     */
    @JSONField(name = "new_displayname")
    private String newDisplayname;
}
