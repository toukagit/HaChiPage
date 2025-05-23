---
title: "其他功能"
sidebar_label: "其他功能"
description: ""
sidebar_position: 3
---

## 游戏失去/获得焦点
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

## 评价

调用可弹出谷歌/苹果系统评价弹框。

```c
HCSDKManager.Instance.Review();
```

**谷歌评价需将包体传到谷歌后台方能弹出。<br/>
苹果需过审后才能弹出评价，TestFlight上无法弹出评价。<br/>**

## 震动
```c
// 震动强弱：0:轻微 1:中度 2:重度
// 震动时间: 0 ~ 1
HCSDKManager.Instance.Shake(1,0.5f);
```

## 获取当前用户来源
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

## Firebase 激活回调

需在SDK初始化前设置；在此回调中可以获取最新远端在线参数。

```c
HCSDKManager.Instance.SetFirebaseFetchDataAsyncSuccess = (result)=> {
    
    // result = true 激活成功，false 激活失败
    HCDebugger.LogDebug("Firebase fetch remote config result:"+result);
    
};
```

## 隐私协议接口
```c
HCSDKManager.Instance.OpenPrivacy();

```

## 删除所有SDK相关文件
![](/img/HCSDK/image34.jpg)

点击后会移除SDK所有文件，如果再次导入SDK报如下错误时，请重启unity<br/>

![](/img/HCSDK/image35.jpeg)


## 敏感词接口
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
## 推送（v2.3.5新增）
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

## 多语言翻译接口（v3.5.6新增）

```c 
public enum TranslateType
{
    //1:聊天（缓存1个小时）
    //2:Other（缓存1个月）
    Chat = 1,
    Other = 2
}


/// <summary>
/// 多语言翻译接口
/// </summary>
/// <param name="text">要翻译的文本内容</param>
/// <param name="type">类型1：聊天，2：其他（公告、邮件等）</param>
/// <param name="targetLang">要翻译的目标语言，eg. zh-cn; ja-jp; ko-kr; vi-vi 等</param>
/// <param name="_action">是否翻译成功，true：翻译成功，false 翻译失败; 文本返回空字符串</param>
public void TranslateWords(string text, TranslateType type, string targetLang, Action<bool, string> _action)
{
    HCTranslate.Instance.TranslateWords(text, type, targetLang, _action);
}

```

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

