---
title: "在线参数"
sidebar_label: "在线参数"
description: ""
sidebar_position: 3
---

## 一、获取在线参数
```c
/// <summary>
/// 
/// </summary>
/// <param name="_key">在线参数key</param>
/// <param name="_defaultValue">在线参数默认值</param>
/// <returns>string/int/bool</returns>

string Strvalue = HCSDKManager.Instance.GetRemoteConfigStr("TestKey01","defaultStringValue");

int intValue = HCSDKManager.Instance.GetRemoteConfigInt("TestKey01", 0);

bool boolValue = HCSDKManager.Instance.GetRemoteConfigBool("TestKey01", false);
```
需要挂vpn才能获取到在线参数，获取不到的情况下，返回传入的在线参数默认值。

