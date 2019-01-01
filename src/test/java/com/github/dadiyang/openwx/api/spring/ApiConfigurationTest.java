package com.github.dadiyang.openwx.api.spring;

import com.github.dadiyang.openwx.api.client.ClientApi;
import com.github.dadiyang.openwx.api.friend.FriendApi;
import com.github.dadiyang.openwx.api.group.GroupApi;
import com.github.dadiyang.openwx.api.media.MediaApi;
import com.github.dadiyang.openwx.api.message.MessageApi;
import com.github.dadiyang.openwx.api.user.UserApi;
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