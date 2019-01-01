package com.github.dadiyang.openwx.api.friend;

import com.alibaba.fastjson.JSON;
import com.github.dadiyang.openwx.api.ApiTestBase;
import com.github.dadiyang.openwx.api.param.AcceptFriendParam;
import com.github.dadiyang.openwx.api.param.MarkNameParam;
import com.github.dadiyang.openwx.api.param.SearchCriteria;
import com.github.dadiyang.openwx.api.result.Result;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class FriendApiTest extends ApiTestBase {
    private FriendApi friendApi;
    private String client;

    @Before
    public void setUp() throws Exception {
        friendApi = factory.getProxy(FriendApi.class);
        client = String.valueOf(ThreadLocalRandom.current().nextInt());
    }

    @Test
    public void searchFriend() {
        String resultExample = "[\n" +
                "    {\n" +
                "        \"account\": \"wxzhifu\",\n" +
                "        \"name\": \"微信支付\",\n" +
                "        \"markname\": \"\",\n" +
                "        \"sex\": \"none\",\n" +
                "        \"display\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"signature\": \"帮助解决微信支付中遇到的困难，收集关于微信支付的建议反馈。\",\n" +
                "        \"province\": \"广东\",\n" +
                "        \"id\": \"@efc5f86c30df4b9c80e98ac428e0e257\",\n" +
                "        \"displayname\": \"微信支付\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"account\": \"\",\n" +
                "        \"name\": \"财付通\",\n" +
                "        \"markname\": \"\",\n" +
                "        \"sex\": \"none\",\n" +
                "        \"display\": \"\",\n" +
                "        \"city\": \"深圳\",\n" +
                "        \"signature\": \"会支付 会生活\",\n" +
                "        \"province\": \"广东\",\n" +
                "        \"id\": \"@00227d73fa6b8326f69bca419db7a05c\",\n" +
                "        \"displayname\": \"财付通\"\n" +
                "    }\n" +
                "]";
        String uri = "/openwx/search_friend";
        Map<String, String> param = new HashMap<>();
        param.put("client", client);
        param.put("city", "广东");
        wireMockRule.stubFor(post(urlPathEqualTo(uri)).withRequestBody(equalToJson(JSON.toJSONString(param))).willReturn(okJson(resultExample)));
        SearchCriteria criteria = new SearchCriteria(client);
        criteria.setCity("广东");
        List<FriendInfo> info = friendApi.searchFriend(criteria);
        assertNotNull(info);
        assertFalse(info.isEmpty());
    }

    @Test
    public void getFriendInfo() {
        System.out.println("测试获取好友信息");
        String resultExample = "[\n" +
                "    {\n" +
                "        \"account\": \"wxzhifu\",\n" +
                "        \"name\": \"微信支付\",\n" +
                "        \"category\":\"公众号\",\n" +
                "        \"markname\": \"\",\n" +
                "        \"sex\": \"none\",\n" +
                "        \"display\": \"\",\n" +
                "        \"city\": \"\",\n" +
                "        \"signature\": \"帮助解决微信支付中遇到的困难，收集关于微信支付的建议反馈。\",\n" +
                "        \"province\": \"广东\",\n" +
                "        \"id\": \"@efc5f86c30df4b9c80e98ac428e0e257\",\n" +
                "        \"uid\": 123456,\n" +
                "        \"displayname\": \"微信支付\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"account\": \"\",\n" +
                "        \"name\": \"小灰\",\n" +
                "        \"category\":\"好友\",\n" +
                "        \"markname\": \"\",\n" +
                "        \"sex\": \"none\",\n" +
                "        \"display\": \"\",\n" +
                "        \"city\": \"深圳\",\n" +
                "        \"signature\": \"小灰灰的个性签名\",\n" +
                "        \"province\": \"广东\",\n" +
                "        \"id\": \"@00227d73fa6b8326f69bca419db7a05c\",\n" +
                "        \"uid\": 123456,\n" +
                "        \"displayname\": \"小灰\"\n" +
                "    }\n" +
                "]";
        String uri = "/openwx/get_friend_info";
        wireMockRule.stubFor(get(urlPathEqualTo(uri))
                .withQueryParam("client", equalTo(client))
                .willReturn(okJson(resultExample)));
        List<FriendInfo> info = friendApi.getFriendInfo(client);
        System.out.println("测试获取好友信息结果: " + info);
        assertNotNull(info);
        assertFalse(info.isEmpty());
    }

    @Test
    public void getAvatar() throws IOException {
        System.out.println("测试获取用户头像");
        String uri = "/openwx/get_avatar";
        wireMockRule.stubFor(get(urlPathEqualTo(uri))
                .withQueryParam("client", equalTo(client))
                .willReturn(okForContentType("image/png", "iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAI/UlEQVR4Xu2ceXCdVRmHnyRNm6")));
        InputStream in = friendApi.getAvatar(client, "123");
        System.out.println("测试获取用户头像结果: " + in);
        assertNotNull(in);
        assertTrue(in.available() > 0);
    }

    @Test
    public void setMarkname() {
        System.out.println("测试修改好友或群成员备注名称");
        String resultExample = "{\n" +
                "    \"status\":\"success\",\n" +
                "    \"code\":0\n" +
                "}\n";
        String uri = "/openwx/set_markname";
        MarkNameParam param = new MarkNameParam(client);
        param.setAccount("abc");
        param.setNewMarkname("a brand new markname");
        wireMockRule.stubFor(post(urlPathEqualTo(uri))
                .withRequestBody(equalToJson(JSON.toJSONString(param)))
                .willReturn(okJson(resultExample)));
        Result result = friendApi.setMarkname(param);
        System.out.println("测试获取好友信息结果: " + result);
        assertNotNull(result);
        assertEquals(result.getCode(), 0);
        assertEquals(result.getStatus(), "success");
    }

    @Test
    public void stick() {
        System.out.println("测试设置或取消群组、好友置顶");
        String resultExample = "{\n" +
                "    \"status\":\"success\",\n" +
                "    \"code\":0\n" +
                "}\n";
        String uri = "/openwx/stick";
        int op = 1;
        String id = "123";
        Map<String, Object> param = new HashMap<>();
        param.put("client", client);
        param.put("id", id);
        param.put("op", op);
        wireMockRule.stubFor(post(urlPathEqualTo(uri))
                .withRequestBody(equalToJson(JSON.toJSONString(param)))
                .willReturn(okJson(resultExample)));
        Result result = friendApi.stick(client, id, op);
        System.out.println("测试设置或取消群组、好友置顶结果: " + result);
        assertNotNull(result);
        assertEquals(result.getCode(), 0);
        assertEquals(result.getStatus(), "success");
    }

    @Test
    public void makeFriend() {
        System.out.println("测试向指定的群成员发送好友请求");
        String resultExample = "{\n" +
                "    \"status\":\"success\",\n" +
                "    \"code\":0\n" +
                "}\n";
        String uri = "/openwx/make_friend";
        String verify = "你好，我想加你好友";
        String id = "123";
        Map<String, Object> param = new HashMap<>();
        param.put("client", client);
        param.put("id", id);
        param.put("verify", verify);
        wireMockRule.stubFor(post(urlPathEqualTo(uri))
                .withRequestBody(equalToJson(JSON.toJSONString(param)))
                .willReturn(okJson(resultExample)));
        Result result = friendApi.makeFriend(client, id, verify);
        System.out.println("测试向指定的群成员发送好友请求结果: " + result);
        assertNotNull(result);
        assertEquals(result.getCode(), 0);
        assertEquals(result.getStatus(), "success");
    }

    @Test
    public void acceptFriendRequest() {
        System.out.println("测试接受好友验证申请");
        String resultExample = "{\n" +
                "    \"status\":\"success\",\n" +
                "    \"code\":0\n" +
                "}\n";
        String uri = "/openwx/accept_friend_request";
        String id = "123";
        String ticket = "t111";
        Map<String, Object> json = new HashMap<>();
        json.put("ticket", ticket);
        json.put("client", client);
        json.put("id", id);
        wireMockRule.stubFor(post(urlPathEqualTo(uri))
                .withRequestBody(equalToJson(JSON.toJSONString(json), true, true))
                .willReturn(okJson(resultExample)));
        AcceptFriendParam param = new AcceptFriendParam(client, ticket);
        param.setId(id);
        Result result = friendApi.acceptFriendRequest(param);
        System.out.println("测试接受好友验证申请结果: " + result);
        assertNotNull(result);
        assertEquals(result.getCode(), 0);
        assertEquals(result.getStatus(), "success");
    }
}