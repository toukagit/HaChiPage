---
title: "Rewarded Ads"
sidebar_label: "Rewarded Ads"
description: ""
sidebar_position: 2
---

The SDK will handle the incentive video AD loading logic, and the game side can call the display intercalation AD method as needed.

## Showing a Rewarded Ad

```c
public void Button_ShowRV()
{
    /// <summary>
    /// Showing a Rewarded Ad
    /// </summary>
    /// <param name="_adPos">Rewarded pos</param>
    /// <param name="_rewardCallback">Rewarded close callback</param>
    /// <param name="_showFailedCallback">Rewarded show fail callback</param>
    /// <param name="_useSDKToast">Whether to use SDK pop-up. Enabled by default</param>
    /// <param name="_toastContent">SDK pop-up prompt content</param>

    bool _useSDKToast = false;
    HCSDKManager.Instance.ShowRewardedAd("GetDoubleCoin",RewardCallback,RewardShowFailCallback,_useSDKToast,_toastContent);
}

private void RewardShowFailCallback()
{
    // The reward video did not load properly or failed to play
    HCDebugger.LogDebug("Failed to play the reward video");
}

private void RewardCallback(bool success)
{
    HCDebugger.LogDebug("RewardCallback result:"+success);
    if(success)
    {
        // Issue rewards
    }
}
```

** _adPos **：Incentive video point name, incentive video advertising point name in [Product Requirements document].You are advised to customize the enumeration according to the required document or download the file to a customized directory.[(SDKPositionName.cs)](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/SDKPositionName.cs)<br/>
** RewardCallback **：Reward video close callback, (in this callback to handle the reward delivery, true: to the user to send a reward, false: incentive failure, can not send a reward)<br/>
** RewardShowFailCallback **：Reward video failed to play callback.<br/>
** _useSDKToast **： SDK Comes with pop-up prompt, enabled by default. The game can be more compatible with the game by using the game cartridge.<br/>
** _toastContent **： SDK pop-up prompts can be displayed in multiple languages.


** _adPos enumeration definition example：**<br/>

For example, the requirements document is as follows<br/>

<center>

<img src="../../img/HCSDK/image60.png" width="80%" height="80%"/>

</center>


```c
public enum HCRVPositionName
{
    RV_RaisePrize,
    RV_Offline
}

HCSDKManager.Instance.ShowRewardedAd(HCRVPositionName.RV_RaisePrize.ToString(), (callback)=> { }, null, true,"ads not ready.");
```

