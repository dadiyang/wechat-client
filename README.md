# 微信Java客户端

[Mojo-Weixin](https://github.com/sjdy521/Mojo-Weixin) [HTTP 接口](https://github.com/sjdy521/Mojo-Weixin/blob/master/API.md) 的 Java 客户端

# 接口列表汇总

本项目使用 [http-api-invoker](https://github.com/dadiyang/http-api-invoker) 框架实现，提供以下方法: 

 | 接口类 | 方法  | 功能 |
 | ----- | ----- | ----- |
 | *ClientApi* | |对 Mojo-Weixin 进程的操作|
 |ClientApi|getClientInfo|获取进程运行信息|
 |ClientApi|stopClient|终止客户端运行|
 |ClientApi|startClient|启动一个客户端|
 |ClientApi|getQrcode|获取登录二维码文件|
 | *FriendApi* | | 微信好友相关的操作|
 |FriendApi| searchFriend | 搜索好友对象|
 |FriendApi| getFriendInfo | 获取好友信息|
 |FriendApi| getAvatar | 获取用户头像|
 |FriendApi| setMarkname | 修改好友或群成员备注名称|
 |FriendApi| stick | 设置或取消群组、好友置顶|
 |FriendApi| makeFriend | 向指定的群成员发送好友请求|
 |FriendApi| acceptFriendRequest | 接受好友验证申请| 
 | *GroupApi* | | 用于微信群相关的操作 |
 |GroupApi| searchGroup | 搜索群组对象 |
 |GroupApi| getGroupInfo | 获取群组数据 |
 |GroupApi| getGroupBasicInfo | 获取群组基本数据 |
 |GroupApi| getAvatar | 获取群组头像 |
 |GroupApi| createCroup | 创建群组 |
 |GroupApi| inviteFriend | 邀请好友入群 |
 |GroupApi| kickGroupMember| 移除群组成员 |
 |GroupApi| setGroupDisplayname| 设置群组的显示名称 |
 | *MediaApi* |  |媒体相关操作|
 |MediaApi| uploadMedia |上传媒体文件，获取media_id|
 | *MessageApi* |  |消息相关操作|
 |MessageApi| revokeMessage |撤回消息|
 |MessageApi| sendFriendMessage |发送好友消息|
 |MessageApi| sendGroupMessage |发送群消息|
 |MessageApi| consult |发送消息给好友并等待好友回答|
 
具体方法参数含义及使用说明，请查看具体类的代码注释或查看 [接口文档](https://github.com/sjdy521/Mojo-Weixin/blob/master/API.md)