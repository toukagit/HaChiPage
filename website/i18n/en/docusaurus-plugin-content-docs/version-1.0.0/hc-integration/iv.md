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
    HCSDKManager.Instance.ShowInterstitial(HCIVPositionName _adPos, HCIVADType _IvType = HCIVADType.IV1, Action _closeCallback = null);
}

private void Button_ShowIV2()
{
    /// <summary>
    /// 
    /// </summary>
    /// <param name="_adPos">interstitial pos(string type)</param>
    /// <param name="_IvType">interstitial type</param>
    /// <param name="_closeCallback">interstitial close callback</param>
    HCSDKManager.Instance.ShowInterstitial(string _adPos, HCIVADType _IvType = HCIVADType.IV1, Action _closeCallback = null);
}


private void InterAdCloseCallback()
{
    HCDebugger.LogDebug("close interstitial ad");
}
```

** HCIVPositionName **：Insert advertisement point name, please first define the insert advertisement point name in the [Product Requirements document] in HCAdPositionName.cs-HCIVAdPositionName.<br/>
** HCIVADType **：Type of frequency control Default set IV1. IV2 can be used if required.<br/>
** InterAdCloseCallback **：interstitial close callback
