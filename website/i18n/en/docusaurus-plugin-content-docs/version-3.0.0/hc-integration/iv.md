---
title: "Interstitials"
sidebar_label: "Interstitials"
description: ""
sidebar_position: 1
---



## Loading an Interstitial Ad

After calling the SDK initialization, the plug-in advertisement is automatically loaded inside the SDK.

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

** _adPos **：Insert advertising spot name, insert advertising spot name in [product requirements document]. You are advised to customize the enumeration according to the requirements document.<br/>

** Requirements document:**<br/>

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

HCSDKManager.Instance.ShowInterstitial(HCIVPositionName.IV_Success.ToString(), HCIVADType.IV1,()=> { });
```


** _IvType **：Type of frequency control Default set IV1. IV2 can be used if required.<br/>
** _closeCallback **：interstitial close callback
