---
title: "Remote Config"
sidebar_label: "Remote Config"
description: ""
sidebar_position: 3
---

## Get remote config
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
The online parameters can be obtained only after the vpn is connected. If the online parameters cannot be obtained, the default values of the online parameters are returned.

e.g.：
<center>

<img src="../img/HCSDK/image61.png"/>

</center>

<br/>


```c
int intValue = HCSDKManager.Instance.GetRemoteConfigInt("Rating_Switch", 0);
```
