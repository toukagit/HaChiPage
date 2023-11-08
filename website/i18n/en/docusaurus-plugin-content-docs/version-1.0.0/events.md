---
title: "Custom event"
sidebar_label: "Custom event"
description: ""
sidebar_position: 96
---

## 一、Set public event attributes (for TD only)

```c
Dictionary<string, object> superProperties = new Dictionary<string, object>();
superProperties["channel"] = "ta";//String
superProperties["age"] = 1;//int
superProperties["isSuccess"] = true;//bool
superProperties["birthday"] = DateTime.Now;//Time
superProperties["object"] = new Dictionary<string, object>() { { "key", "value" } };//Object
superProperties["object_arr"] = new List<object>() { new Dictionary<string, object>() { { "key", "value" } } };//Dictionary
superProperties["arr"] = new List<object>() { "value" };//Array

HCSDKManager.Instance.SetSuperProperties(superProperties);
```

## 二、Set user properties (for TD only)
```c
Dictionary<string, object> userProperties = new Dictionary<string, object>();
userProperties["user_name"] = "TA";

HCSDKManager.Instance.SetUserProperties(userProperties);
```

## 三、User-defined event reporting
```c
HCSDKManager.Instance.LogEvent("Event01");

HCSDKManager.Instance.LogEvent("Event02", "key01","value01",TrackEventPlatform.Firebase);

HCSDKManager.Instance.LogEvent("Event03", "key01", "value01", "key02", "value02",TrackEventPlatform.TD);

HCSDKManager.Instance.LogEvent("Event04", new Dictionary<string, object>() { { "key01", "value01" } });
```

Firebase/ TD is reported by default. If a statistical platform needs to be reported separately, use the **TrackEventPlatform** enumeration
