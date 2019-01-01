package com.github.dadiyang.openwx.api.result;

import com.github.dadiyang.openwx.api.client.ClientInfo;
import lombok.Data;

import java.util.List;

@Data
public class CheckClientResult extends Result {
    private List<ClientInfo> client;
}
