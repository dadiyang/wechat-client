package com.github.dadiyang.wechat;

import com.github.dadiyang.httpinvoker.HttpApiProxyFactory;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.BeforeClass;
import org.junit.Rule;

public class ApiTestBase {
    protected static HttpApiProxyFactory factory;
    private static final int PORT = 19921;
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(PORT);

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("openwx.host", "http://localhost:" + PORT);
        factory = new HttpApiProxyFactory();
    }
}
