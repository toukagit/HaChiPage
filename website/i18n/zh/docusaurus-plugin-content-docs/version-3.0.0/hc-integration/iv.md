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

    HCSDKManager.Instance.ShowInterstitial(string _adPos, HCIVADType _IvType = HCIVADType.IV1, Action _closeCallback = null);
}

private void InterAdCloseCallback()
{
    HCDebugger.LogDebug("插屏广告关闭");
}
```

** _adPos **：插屏广告点位名称，【产品需求文档】中的插屏广告点位名称。建议根据需求文档自定义枚举。<br/>

** 需求文档：**<br/>

<center>

<img src="../../img/HCSDK/image59.png" width="80%" height="80%"/>

</center>

** 示例：**<br/>

```c
public enum HCIVPositionName
{
    IV_Success,
    IV_Fail
}

HCSDKManager.Instance.ShowInterstitial(HCIVPositionName.IV_Success.ToString(), HCIVADType.IV1,()=> { });
```

** _IvType **：插屏频次类型。默认使用 IV1。可结合【产品需求文档】如有不同插屏频次需求，可配合 IV2 使用。<br/>
** _closeCallback **：插屏关闭回调 
