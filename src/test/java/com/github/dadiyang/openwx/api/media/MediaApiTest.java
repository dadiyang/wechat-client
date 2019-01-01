package com.github.dadiyang.openwx.api.media;

import com.alibaba.fastjson.JSON;
import com.github.dadiyang.openwx.api.ApiTestBase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MediaApiTest extends ApiTestBase {
    private MediaApi mediaApi;
    private String client;

    @Before
    public void setUp() throws Exception {
        mediaApi = factory.getProxy(MediaApi.class);
        client = String.valueOf(ThreadLocalRandom.current().nextInt());
    }

    @Test
    public void uploadMedia() {
        String resultExample = "{\n" +
                "    \"media_ext\":\"png\",\n" +
                "    \"media_id\":\"@crypt_5e8967c8_e637847b7d0b00xxxxxxcb82:43\",\n" +
                "    \"media_mime\":\"image\\/png\",\n" +
                "    \"media_mtime\":1470650887,\n" +
                "    \"media_name\":\"\\/tmp\\/ok.png\",\n" +
                "    \"media_path\":\"\\/tmp\\/ok.png\",\n" +
                "    \"media_size\":66947\n" +
                "}";
        String uri = "/openwx/upload_media";
        String mediaPath = "/tmp/ok.png";
        Map<String, String> param = new HashMap<>();
        param.put("client", client);
        param.put("media_path", mediaPath);
        System.out.println(param);
        wireMockRule.stubFor(post(urlPathEqualTo(uri))
                .withRequestBody(equalTo(JSON.toJSONString(param)))
                .willReturn(okJson(resultExample)));
        MediaInfo info = mediaApi.uploadMedia(client, mediaPath);
        System.out.println("上传媒体文件结果: " + info);
        assertNotNull(info);
        assertEquals(info.getMediaExt(), "png");
        assertEquals(info.getMediaId(), "@crypt_5e8967c8_e637847b7d0b00xxxxxxcb82:43");
        assertNotNull(info.getMediaMime());
        assertNotNull(info.getMediaName());
    }
}