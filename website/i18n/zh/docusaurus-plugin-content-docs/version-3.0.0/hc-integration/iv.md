---
title: "插屏广告"
sidebar_label: "插屏广告"
description: ""
sidebar_position: 1
---

SDK内部会处理插屏广告加载逻辑，游戏侧根据需要调用展示插屏广告方法即可。

## 展示插屏广告
```c
private void Button_ShowIV1()
{
    /// <summary>
    /// 展示插屏广告
    /// </summary>
    /// <param name="_adPos">插屏点位</param>
    /// <param name="_IvType">插屏type</param>
    /// <param name="_closeCallback">插屏关闭回调</param>

    HCSDKManager.Instance.ShowInterstitial("IV_Unlock", HCIVADType.IV1, _closeCallback);
}

private void InterAdCloseCallback(bool result)
{
    if(result)
    {
       HCDebugger.LogDebug("插屏广告关闭");
    }
    else
    {
        HCDebugger.LogDebug("插屏未准备好或因条件导致未展示插屏");
    }
}
```

** _adPos **：插屏广告点位名称，【产品需求文档】中的插屏广告点位名称。建议根据需求文档自定义枚举或者可直接下载此文件放到自定义目录进行使用。[(SDKPositionName.cs)](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/SDKPositionName.cs)<br/>
** _IvType **：插屏频次类型。默认使用 IV1。可结合【产品需求文档】如有不同插屏频次需求，可配合 IV2 使用。<br/>
** _closeCallback **：插屏关闭回调；true：关闭插屏时返回，false:因插屏未准备好或因条件导致未展示插屏时返回
** _adPos枚举定义示例：**<br/>

例如：需求文档如下<br/>

<center>

<img src="../../img/HCSDK/image59.png" width="80%" height="80%"/>

</center>

```c
public enum HCIVPositionName
{
    IV_Unlock,
    IV_Auto
}

HCSDKManager.Instance.ShowInterstitial(HCIVPositionName.IV_Unlock.ToString(), HCIVADType.IV1,(result)=> 
{
    if(result)
    {
       HCDebugger.LogDebug("插屏广告关闭");
    }
    else
    {
        HCDebugger.LogDebug("插屏未准备好或因条件导致未展示插屏");
    }
});
```



