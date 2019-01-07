package com.github.dadiyang.wechat.result;

import lombok.Data;

/**
 * 创建群主的结果
 *
 * @author huangxuyang
 * date 2019/1/1
 */
@Data
public class CreateGroupResult extends Result {
    private String groupId;
}
