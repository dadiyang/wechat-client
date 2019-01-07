package com.github.dadiyang.wechat.spring;

import com.github.dadiyang.wechat.client.ClientApi;
import com.github.dadiyang.wechat.friend.FriendApi;
import com.github.dadiyang.wechat.group.GroupApi;
import com.github.dadiyang.wechat.media.MediaApi;
import com.github.dadiyang.wechat.message.MessageApi;
import com.github.dadiyang.wechat.user.UserApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
public class ApiConfigurationTest {
    @Autowired
    private ClientApi clientApi;
    @Autowired
    private FriendApi friendApi;
    @Autowired
    private GroupApi groupApi;
    @Autowired
    private MediaApi mediaApi;
    @Autowired
    private MessageApi messageApi;
    @Autowired
    private UserApi userApi;

    @Test
    public void isOk() {
        assertNotNull(clientApi);
        assertNotNull(friendApi);
        assertNotNull(groupApi);
        assertNotNull(mediaApi);
        assertNotNull(messageApi);
        assertNotNull(userApi);
    }
}