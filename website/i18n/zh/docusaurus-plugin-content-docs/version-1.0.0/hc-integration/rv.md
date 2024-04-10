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
    HCSDKManager.Instance.ShowRewardedAd(HCRVPositionName.GetDoubleCoin,RewardCallback,RewardShowFailCallback,_useSDKToast,_toastContent);
}

public void Button_ShowRV2()
{
    /// <summary>
    /// 播放激励视频广告
    /// </summary>
    /// <param name="_adPos">激励视频广告点位(字符串类型)</param>
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
}
```

** HCRVPositionName **：激励视频点位名称，请将【产品需求文档】中的激励视频广告点位名称先在 HCAdPositionName.cs - HCRVPositionName 中进行定义。<br/>
** RewardCallback **：激励视频关闭回调，(在此回调中处理奖励下发，true: 给用户下发奖励，false: 激励失败，不能下发奖励)<br/>
** RewardShowFailCallback **：激励视频未成功播放回调。<br/>
** useSDKToast **： SDK 自带弹窗提示，默认开启。游戏可使用游戏弹框更契合游戏。
** toastContent **： SDK 弹框提示内容，可根据多语言展示。
