---
title: "其他功能"
sidebar_label: "其他功能"
description: ""
sidebar_position: 3
---

## 一、游戏失去/获得焦点
```c
HCSDKManager.Instance.SetGameFocusListener((_isFocus) => {
    if (_isFocus)
    {
        Debug.Log("set game focus");
    }
    else
    {
        Debug.Log("lose game focus");
    }
});
```
设置游戏失去/获得焦点回调，SDK每次触发到对应情境会给回来回调。<br/>
例如当广告开始播放的时候，你的游戏将会失去焦点。广告播放结束，返回游戏，你的游戏会获得焦点。

## 二、评价

```c
HCSDKManager.Instance.Review();
```
调用可弹出谷歌/苹果系统评价弹框。

## 三、震动
```c
// 震动强弱：0:轻微 1:中度 2:重度
// 震动时间: 0 ~ 1
HCSDKManager.Instance.Shake(1,0.5f);
```

## 四、获取当前用户来源
```c
void Start()
{
    HCSDKManager.Instance.SetUserSourceListenerCallback(UserSourceListenerCallback);
    
}
    
private void UserSourceListenerCallback(bool isOrganic, string network)
{
    HCDebugger.LogDebug("SetUserSourceListenerCallback isOrganic:" + isOrganic + "network:" + network);
}
```
用户来源回调，bool: true 自然用户 false 非自然用户

## 五、Firebase 激活回调

需在SDK初始化前设置；在此回调中可以获取最新远端在线参数。

```c
HCSDKManager.Instance.SetFirebaseFetchDataAsyncSuccess = (result)=> {
    
    // result = true 激活成功，false 激活失败
    HCDebugger.LogDebug("Firebase fetch remote config result:"+result);
    
};
```

## 六、隐私协议接口
```c
HCSDKManager.Instance.OpenPrivacy();

```

## 七、删除所有SDK相关文件
![](/img/HCSDK/image34.jpg)

点击后会移除SDK所有文件，如果再次导入SDK报如下错误时，请重启unity<br/>

![](/img/HCSDK/image35.jpeg)


## 八、敏感词接口
```

public enum SensitiveType
{
    //1:昵称(短文本国内)
    //2:聊天(长文本国内) 
    //3:国际业务多语言
    NickName = 1,
    Chat = 2,
    Global = 3
}

public enum SensitiveAppType
{
    //0: 国内app(默认不填为0)
    //1: 微信小程序
    app = 0,
    wx_app = 1
}

HCSDKManager.Instance.CheckSensitiveWords("测试文本",HCSensitive.SensitiveType.Global, (result, content) =>
 {

     if (result)
     {
         // 不包含敏感词
     }
     else
     {
         // 包含敏感词，content为消除敏感词后的文本，敏感词会被替换为符号 * 
     }

 },HCSensitive.SensitiveAppType.app);

```
## 九、推送（v2.3.5新增）
- 请求获取通知权限
```c
HCSDKManager.Instance.ReqNotificationPermission();
```
调用此接口时，SDK将请求通知权限。

- 注册通知回调（可选）

```c

// 返回当前设备通知的注册令牌（token）
HCSDKManager.Instance.OnNotificationTokenReceived += OnReveiveNotificationToken;


// 返回firebase后台配置的Custom data,custom data以字典的形式返回
HCSDKManager.Instance.OnNotificationOnMessageReceived += OnMessageReceive;


private void OnReveiveNotificationToken(string token)
{
    // 当前设备接收通知令牌
    HCDebugger.LogDebug("token:"+token);
}


private void OnMessageReceive(Dictionary<string, string> data)
{
    // 返回firebase后台配置的自定义键值对
    foreach (var item in data)
    {
        HCDebugger.LogDebug("receive dataKey:"+item.Key+" dataValue:"+item.Value);
    }
}
```
当收到通知时，可通过 HCSDKManager.Instance.OnNotificationOnMessageReceived 回调接收到firebase后台配置的自定义键值对。


<!---->
<!--- 获取是否有通知权限-->
<!--```c-->
<!--var permission = HCSDKManager.Instance.IsGrantedNotificationPermission();-->
<!--```-->
<!--通过此接口来获取当前应用是否具有通知权限。-->
<!---->
<!--- 打开/关闭推送-->
<!--```c-->
<!--// 打开通知-->
<!--HCSDKManager.Instance.PushSwitch(true);-->
<!---->
<!--// 关闭通知-->
<!--HCSDKManager.Instance.PushSwitch(false);-->
<!--        -->
<!--```-->
<!--- 推送功能是否开启-->
<!--```c-->
<!--var pushOpen = HCSDKManager.Instance.IsPushOpen();-->
<!--```-->
<!--通过此接口来判断当前应用推送功能是否已开启。-->

