package com.github.dadiyang.wechat.user;

import com.github.dadiyang.wechat.ApiTestBase;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class UserApiTest extends ApiTestBase {

    @Test
    public void getUserInfo() {
        UserApi userApi = factory.getProxy(UserApi.class);
        String uri = "/openwx/get_user_info";
        String client = "" + ThreadLocalRandom.current().nextInt();
        String testResult = "{\"account\": \"abc\",\n" +
                "        \"name\": \"未知数\",\n" +
                "        \"markname\": \"扬\",\n" +
                "        \"sex\": \"none\",\n" +
                "        \"display\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"signature\": \"帮助解决微信支付中遇到的困难，收集关于微信支付的建议反馈。\",\n" +
                "        \"province\": \"广东\",\n" +
                "        \"id\": \"@aaadddbbb\",\n" +
                "        \"uid\": 123,\n" +
                "        \"displayname\": \"xxx\"\n" +
                "    }";
        wireMockRule.stubFor(get(urlPathEqualTo(uri)).withQueryParam("client", equalTo(client)).willReturn(okJson(testResult)));
        UserInfo userInfo = userApi.getUserInfo(client);
        assertEquals("abc", userInfo.getAccount());
        assertEquals("未知数", userInfo.getName());
        assertEquals("扬", userInfo.getMarkname());
        assertEquals(123L, userInfo.getUid());
        assertEquals("@aaadddbbb", userInfo.getId());
    }
}