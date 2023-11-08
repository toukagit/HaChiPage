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
