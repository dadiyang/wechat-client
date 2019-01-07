package com.github.dadiyang.wechat.result;

import com.github.dadiyang.wechat.client.ClientInfo;
import lombok.Data;

import java.util.List;

@Data
public class CheckClientResult extends Result {
    private List<ClientInfo> client;
}
