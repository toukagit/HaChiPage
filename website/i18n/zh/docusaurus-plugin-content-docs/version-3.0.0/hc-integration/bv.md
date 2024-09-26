---
title: "Banner广告"
sidebar_label: "Banner广告"
description: ""
sidebar_position: 3
---

:::tip
SDK内部会处理banner广告加载逻辑，游戏侧根据需要调用展示/隐藏banner方法即可。
:::



## 展示Banner广告
```c
public void Button_ShowBanner()
{
    /// <summary>
    /// 展示banner广告
    /// </summary>
    /// <param name="_bannerType">banner类型，Admob折叠banner/max传统banner</param>
    /// <param name="_googlePos">Admob折叠banner位置，默认底部居中</param>
    /// <param name="_maxPos">max传统banner位置，默认底部居中</param>

    HCSDKManager.Instance.ShowBanner(HCAdsManager.HCBannerType.Admob, GoogleMobileAds.Api.AdPosition.Bottom, MaxSdkBase.BannerPosition.BottomCenter);
}
```
说明：使用Admob折叠banner时，如果没填充则会展示max传统banner。

## 隐藏Banner广告
```c
public void Button_HideBanner()
{
    HCSDKManager.Instance.HideBanner();
}
```

