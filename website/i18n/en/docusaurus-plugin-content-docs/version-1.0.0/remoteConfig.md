---
title: "Remote Config"
sidebar_label: "Remote Config"
description: ""
sidebar_position: 3
---

## 一、Get remote config
```c
/// <summary>
/// 
/// </summary>
/// <param name="_key">remote config key</param>
/// <param name="_defaultValue">remote config default value</param>
/// <returns>string/int/bool</returns>

string Strvalue = HCSDKManager.Instance.GetRemoteConfigStr("TestKey01","defaultStringValue");

int intValue = HCSDKManager.Instance.GetRemoteConfigInt("TestKey01", 0);

bool boolValue = HCSDKManager.Instance.GetRemoteConfigBool("TestKey01", false);
```
Default value are returned after Firebase activation fails.

