package com.github.dadiyang.openwx.api.client;

import com.github.dadiyang.openwx.api.ApiTestBase;
import com.github.dadiyang.openwx.api.result.ClientResult;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ClientApiTest extends ApiTestBase {
    private ClientApi clientApi;
    private String client;

    @Before
    public void setup() {
        clientApi = factory.getProxy(ClientApi.class);
        client = String.valueOf(ThreadLocalRandom.current().nextInt());
    }

    @Test
    public void getClientInfo() {
        System.out.println("测试获取客户端信息");
        String resultExample = "{\n" +
                "    \"code\":0,\n" +
                "    \"account\":\"default\",\n" +
                "    \"log_encoding\":null,\n" +
                "    \"log_level\":\"debug\",\n" +
                "    \"log_path\":null,\n" +
                "    \"os\":\"linux\",\n" +
                "    \"pid\":15497,\n" +
                "    \"runtime\":3096,\n" +
                "    \"starttime\":1475135588,\n" +
                "    \"status\":\"success\",\n" +
                "    \"http_debug\":\"0\",\n" +
                "    \"version\":\"1.2.0\"\n" +
                " }";
        String uri = "/openwx/get_client_info";
        wireMockRule.stubFor(get(urlPathEqualTo(uri)).withQueryParam("client", equalTo(client)).willReturn(okJson(resultExample)));
        ClientInfo clientInfo = clientApi.getClientInfo(client);
        System.out.println("测试获取客户端信息结果: " + clientInfo);
        assertNotNull(clientInfo);
        assertEquals(0, clientInfo.getCode());
        assertEquals("default", clientInfo.getAccount());
        assertEquals("debug", clientInfo.getLogLevel());
        assertEquals(15497, clientInfo.getPid());

    }

    @Test
    public void stopClient() {
        System.out.println("测试停止客户端");
        String resultExample = "{\"client\":\"weixin_client_01\",\"code\":0,\"pid\":32294,\"port\":3000,\"status\":\"success\"}";
        String uri = "/openwx/stop_client";
        wireMockRule.stubFor(get(urlPathEqualTo(uri)).withQueryParam("client", equalTo(client)).willReturn(okJson(resultExample)));
        ClientResult result = clientApi.stopClient(client);
        System.out.println("测试停止客户端结果: " + result);
        assertNotNull(result);
        assertEquals(result.getCode(), 0);
        assertEquals(result.getPid(), 32294);
        assertEquals(result.getPort(), 3000);
    }

    @Test
    public void startClient() {
        System.out.println("测试启动客户端");
        String resultExample = "{\"client\":\"weixin_client_01\",\"code\":0,\"pid\":32294,\"port\":3000,\"status\":\"success\"}";
        String uri = "/openwx/start_client";
        wireMockRule.stubFor(get(urlPathEqualTo(uri)).withQueryParam("client", equalTo(client)).willReturn(okJson(resultExample)));
        ClientResult result = clientApi.startClient(client);
        System.out.println("测试启动客户端结果: " + result);
        assertNotNull(result);
        assertEquals(result.getCode(), 0);
        assertEquals(result.getPid(), 32294);
        assertEquals(result.getPort(), 3000);
    }

    @Test
    public void getQrcode() throws IOException {
        System.out.println("测试获取登录二维码文件");
        String uri = "/openwx/get_qrcode";
        wireMockRule.stubFor(get(urlPathEqualTo(uri)).withQueryParam("client", equalTo(client)).willReturn(ok("OK")));
        InputStream result = clientApi.getQrcode(client);
        System.out.println("测试获取登录二维码文件客户端结果: " + result);
        assertNotNull(result);
        assertTrue(result.available() > 0);
    }
}