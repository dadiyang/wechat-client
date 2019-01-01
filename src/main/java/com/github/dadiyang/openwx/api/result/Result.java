package com.github.dadiyang.openwx.api.result;

import lombok.Data;

/**
 * 写接口的返回值
 *
 * @author huangxuyang
 * @date 2019/1/1
 */
@Data
public class Result {
    private int code;
    private String status;
}
