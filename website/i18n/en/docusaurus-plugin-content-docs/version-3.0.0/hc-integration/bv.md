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
    /// <param name="_bannerType">banner type Collapses banner/Normal banner</param>
    /// <param name="_googlePos">the banner position, with the default bottom centered</param>
    /// 

    HCSDKManager.Instance.ShowBanner(HCAdsManager.HCBannerType.Collapsible, GoogleMobileAds.Api.AdPosition.Bottom);
}
```

Note: When a collapsible type is passed, the SDK will request an ad based on the collapsible banner ad ID. However, the returned banner type is not necessarily a collapsible banner; it could also be a regular banner. Therefore, when displaying the banner, a regular banner might be shown.

## Hiding a Banner

```c
public void Button_HideBanner()
{
    HCSDKManager.Instance.HideBanner();
}
```

