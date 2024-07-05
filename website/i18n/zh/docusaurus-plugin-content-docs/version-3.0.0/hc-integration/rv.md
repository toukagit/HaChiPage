---
title: "激励视频广告"
sidebar_label: "激励视频广告"
description: ""
sidebar_position: 2
---

## 一、加载激励视频广告

调用SDK初始化后，SDK内部自动加载激励视频广告。

## 二、展示激励视频广告
```c
public void Button_ShowRV()
{
    /// <summary>
    /// 播放激励视频广告
    /// </summary>
    /// <param name="_adPos">激励视频广告点位</param>
    /// <param name="_rewardCallback">激励视频关闭回调</param>
    /// <param name="_showFailedCallback">激励视频展示失败回调</param>
    /// <param name="_useSDKToast">是否使用SDK弹框,默认开启</param>
    /// <param name="_toastContent">SDK弹框提示内容</param>
     
    bool _useSDKToast = false;
    HCSDKManager.Instance.ShowRewardedAd("GetDoubleCoin",RewardCallback,RewardShowFailCallback,_useSDKToast,_toastContent);
}

private void RewardShowFailCallback()
{
    // 激励视频没有加载好或者播放失败
    HCDebugger.LogDebug("激励视频播放失败");
}

private void RewardCallback(bool success)
{
    HCDebugger.LogDebug("RewardCallback result:"+success);
    if(success)
    {
        // 下发奖励
        
    }
}
```

** _adPos **：激励视频点位名称，【产品需求文档】中的激励视频广告点位名称。建议根据需求文档自定义枚举。<br/>

** 需求文档：**<br/>

<center>

<img src="../../img/HCSDK/image60.png" width="80%" height="80%"/>

</center>

** 示例：**<br/>

```c
public enum HCRVPositionName
{
    RV_Rocket,
    RV_Bomb,
    RV_Magic,
    RV_Revive
}

HCSDKManager.Instance.ShowRewardedAd(HCRVPositionName.RV_Rocket.ToString(), (callback)=> { }, null, true,"广告未准备好");
```

** RewardCallback **：激励视频关闭回调，(在此回调中处理奖励下发，true: 给用户下发奖励，false: 激励失败，不能下发奖励)<br/>
** RewardShowFailCallback **：激励视频未成功播放回调。<br/>
** _useSDKToast **： SDK 自带弹窗提示，默认开启。游戏可使用游戏弹框更契合游戏。<br/>
** _toastContent **： SDK 弹框提示内容，可根据多语言展示。
