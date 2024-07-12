---
title: "Interstitials"
sidebar_label: "Interstitials"
description: ""
sidebar_position: 1
---

The SDK will handle the plug-in advertising loading logic, and the game side can call the display plug-in advertising method as needed.

## Showing an Interstitial Ad
```c
private void Button_ShowIV1()
{
    /// <summary>
    /// 
    /// </summary>
    /// <param name="_adPos">interstitial pos</param>
    /// <param name="_IvType">interstitial type</param>
    /// <param name="_closeCallback">interstitial close callback</param>
    HCSDKManager.Instance.ShowInterstitial(string _adPos, HCIVADType _IvType = HCIVADType.IV1, Action _closeCallback = null);
}


private void InterAdCloseCallback()
{
    HCDebugger.LogDebug("close interstitial ad");
}
```

** _adPos **：Insert advertising spot name, insert advertising spot name in [product requirements document]. You are advised to customize the enumeration according to the required document or download the file to a customized directory.[(SDKPositionName.cs)](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/SDKPositionName.cs)<br/>
** _IvType **：Type of frequency control Default set IV1. IV2 can be used if required.<br/>
** _closeCallback **：interstitial close callback.


** _adPos enumeration definition example:**<br/>

For example, the requirements document is as follows:

<center>

<img src="../../img/HCSDK/image59.png" width="80%" height="80%"/>

</center>

** e.g：**<br/>

```c
public enum HCIVPositionName
{
    IV_Success,
    IV_Fail
}

HCSDKManager.Instance.ShowInterstitial(HCIVPositionName.IV_Unlock.ToString(), HCIVADType.IV1,()=> { });
```



