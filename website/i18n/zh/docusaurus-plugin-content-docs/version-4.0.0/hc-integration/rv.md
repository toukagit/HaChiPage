---
title: "激励视频广告"
sidebar_label: "激励视频广告"
description: ""
sidebar_position: 2
---

SDK内部会处理激励视频广告加载逻辑，游戏侧根据需要调用展示激励视频广告方法即可。

## 激励视频广告是否可用
```c
public void Button_IsRRewardAdReady()
{
    
    var isRewardReady = HachiMgr.Instance.IsRewardedAdReady();

    if (isRewardReady)
    {
        HMDebugger.LogDebug("激励视频广告准备好了");

    }else
    {
        HMDebugger.LogDebug("激励视频广告没有准备好");
    }
}


```

## 展示激励视频广告
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
    HachiMgr.Instance.ShowRewardedAd("GetDoubleCoin",RewardCallback,RewardShowFailCallback,_useSDKToast,_toastContent);
}

private void RewardShowFailCallback()
{
    // 激励视频没有加载好或者播放失败
    HMDebugger.LogDebug("激励视频播放失败");
}

private void RewardCallback(bool success)
{
    HMDebugger.LogDebug("RewardCallback result:"+success);
    if(success)
    {
        // 下发奖励
        
    }
}
```

** _adPos **：激励视频点位名称，【产品需求文档】中的激励视频广告点位名称。建议根据需求文档自定义枚举或者可直接下载此文件放到自定义目录进行使用。
[(SDKPositionName.cs)](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/SDKPositionName.cs)<br/>
** RewardCallback **：激励视频关闭回调，(在此回调中处理奖励下发，true: 给用户下发奖励，false: 激励失败，不能下发奖励)<br/>
** RewardShowFailCallback **：激励视频未成功播放回调。<br/>
** _useSDKToast **： SDK 自带弹窗提示，默认开启。游戏可使用游戏弹框更契合游戏。<br/>
** _toastContent **： SDK 弹框提示内容，可根据多语言展示。

<!--** _adPos枚举定义示例：**<br/>-->
<!---->
<!--例如：需求文档如下<br/>-->
<!---->
<!--<center>-->
<!---->
<!--<img src="../../img/HCSDK/image60.png" width="80%" height="80%"/>-->
<!---->
<!--</center>-->


<!--```c-->
<!--public enum RVPositionName-->
<!--{-->
<!--    RV_RaisePrize,-->
<!--    RV_Offline-->
<!--}-->
<!---->
<!--HachiMgr.Instance.ShowRewardedAd(RVPositionName.RV_RaisePrize.ToString(), (callback)=> { }, null, true,"广告未准备好");-->
<!--```-->

