---
title: "Banner"
sidebar_label: "Banner"
description: ""
sidebar_position: 3
---

:::tip
The SDK will handle the banner AD loading logic internally, and the game side can call the show/hide banner method as needed.
:::

## Showing a Banner
```c
public void Button_ShowBanner()
{
    /// <summary>
    /// show banner ad
    /// </summary>
    /// <param name="_bannerType">banner type，Admob collapses banner/max tradition banner</param>
    /// <param name="_googlePos">Admob collapses the banner position, with the default bottom centered</param>
    /// <param name="_maxPos">max traditional banner position, centered at the bottom by default</param>

    HCSDKManager.Instance.ShowBanner(HCAdsManager.HCBannerType.Admob, GoogleMobileAds.Api.AdPosition.Bottom, MaxSdkBase.BannerPosition.BottomCenter);
}
```

Note: When folding the banner with Admob, the max traditional banner will be displayed if it is not filled.

## Hiding a Banner

```c
public void Button_HideBanner()
{
    HCSDKManager.Instance.HideBanner();
}
```

