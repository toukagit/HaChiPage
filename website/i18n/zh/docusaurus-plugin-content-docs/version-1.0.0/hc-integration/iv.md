---
title: "插屏广告"
sidebar_label: "插屏广告"
description: ""
sidebar_position: 1
---



## 一、加载插屏广告

调用SDK初始化后，SDK内部自动加载插屏广告。

## 二、展示插屏广告
```c
private void Button_ShowIV1()
{
    /// <summary>
    /// 展示插屏广告
    /// </summary>
    /// <param name="_adPos">插屏点位</param>
    /// <param name="_IvType">插屏type</param>
    /// <param name="_closeCallback">插屏关闭回调</param>

    HCSDKManager.Instance.ShowInterstitial(HCIVPositionName _adPos, HCIVADType _IvType = HCIVADType.IV1, Action _closeCallback = null);
}

private void Button_ShowIV2()
{
    /// <summary>
    /// 展示插屏广告
    /// </summary>
    /// <param name="_adPos">插屏点位(字符串类型)</param>
    /// <param name="_IvType">插屏type</param>
    /// <param name="_closeCallback">插屏关闭回调</param>

    HCSDKManager.Instance.ShowInterstitial(string _adPos, HCIVADType _IvType = HCIVADType.IV1, Action _closeCallback = null);
}

private void InterAdCloseCallback()
{
    HCDebugger.LogDebug("插屏广告关闭");
}
```

** HCIVPositionName **：插屏广告点位名称，请将【产品需求文档】中的插屏广告点位名称先在 HCAdPositionName.cs - HCIVAdPositionName 中进行定义。<br/>
** HCIVADType **：插屏频次类型。默认使用 IV1。可结合【产品需求文档】如有不同插屏频次需求，可配合 IV2 使用。<br/>
** InterAdCloseCallback **：插屏关闭回调 
