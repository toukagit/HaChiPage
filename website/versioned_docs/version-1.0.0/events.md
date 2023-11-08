---
title: "自定义事件"
sidebar_label: "自定义事件"
description: ""
sidebar_position: 96
---

## 一、设置公共事件属性（只用于报到数数）

```c
Dictionary<string, object> superProperties = new Dictionary<string, object>();
superProperties["channel"] = "ta";//字符串
superProperties["age"] = 1;//数字
superProperties["isSuccess"] = true;//布尔
superProperties["birthday"] = DateTime.Now;//时间
superProperties["object"] = new Dictionary<string, object>() { { "key", "value" } };//对象
superProperties["object_arr"] = new List<object>() { new Dictionary<string, object>() { { "key", "value" } } };//对象组
superProperties["arr"] = new List<object>() { "value" };//数组

HCSDKManager.Instance.SetSuperProperties(superProperties);
```

## 二、设置用户属性（只用于报到数数）
```c
Dictionary<string, object> userProperties = new Dictionary<string, object>();
userProperties["user_name"] = "TA";

HCSDKManager.Instance.SetUserProperties(userProperties);
```

## 三、自定义事件上报
```c
HCSDKManager.Instance.LogEvent("Event01");

HCSDKManager.Instance.LogEvent("Event02", "key01","value01",TrackEventPlatform.Firebase);

HCSDKManager.Instance.LogEvent("Event03", "key01", "value01", "key02", "value02",TrackEventPlatform.TD);

HCSDKManager.Instance.LogEvent("Event04", new Dictionary<string, object>() { { "key01", "value01" } });
```

默认上报Firebase/数数，如需单独上报某一个统计平台需通过 **TrackEventPlatform** 枚举控制
