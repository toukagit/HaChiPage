---
title: "Banner"
sidebar_label: "Banner"
description: ""
sidebar_position: 3
---

The SDK will handle the banner AD loading logic internally, and the game side can call the display/hide banner method as needed.

## Showing a Banner
```c
public void Button_ShowBanner()
{
    /// <summary>
    /// Display banner ads
    /// </summary>
    /// <param name="_pos">banner display location </param>
    HCSDKManager.Instance.ShowBanner(MaxSdkBase.BannerPosition _pos);
}
```

## Hiding a Banner

```c
public void Button_HideBanner()
{
    HCSDKManager.Instance.HideBanner();
}
```

