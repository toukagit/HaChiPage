---
title: "Banner"
sidebar_label: "Banner"
description: ""
sidebar_position: 3
---

## Loading a Banner

After calling the SDK initialization, the Banner advertisement is automatically loaded inside the SDK.

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

