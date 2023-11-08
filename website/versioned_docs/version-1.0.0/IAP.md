---
title: "在线参数&评价"
sidebar_label: "在线参数&评价"
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
Firebase激活失败后会返回默认参数。

## 二、评价

```c
HCSDKManager.Instance.Review();
```
调用可弹出谷歌/苹果系统评价弹框。
