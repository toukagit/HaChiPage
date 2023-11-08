---
title: "Rewarded Ads"
sidebar_label: "Rewarded Ads"
description: ""
sidebar_position: 2
---

## 一、Loading a Rewarded Ad

After calling SDK initialization, incentive video ads are automatically loaded inside the SDK.

## 二、Showing a Rewarded Ad

```c
public void Button_ShowRV()
{
    /// <summary>
    /// Showing a Rewarded Ad
    /// </summary>
    /// <param name="_adPos">Rewarded pos</param>
    /// <param name="_rewardCallback">Rewarded close callback</param>
    /// <param name="_showFailedCallback">Rewarded show fail callback</param>
    HCSDKManager.Instance.ShowRewardedAd(HCRVPositionName.GetDoubleCoin,RewardCallback,RewardShowFailCallback);
}

private void RewardShowFailCallback()
{
    // The reward video did not load properly or failed to play
    HCDebugger.LogDebug("Failed to play the reward video");
}

private void RewardCallback(bool success)
{
    HCDebugger.LogDebug("RewardCallback result:"+success);
}
```

** HCRVPositionName **：Reward video point name, please define the reward video advertising point name in the [Product Requirements document] first in HCAdPositionName.cs-HCRVPositionName.<br/>
** RewardCallback **：Reward video close callback, (in this callback to handle the reward delivery, true: to the user to send a reward, false: incentive failure, can not send a reward)<br/>
** RewardShowFailCallback **：Reward video failed to play callback.
