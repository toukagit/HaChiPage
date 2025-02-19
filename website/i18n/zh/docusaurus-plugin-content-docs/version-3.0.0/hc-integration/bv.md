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
    /// <param name="_bannerType">banner类型，Collapsible折叠banner/Normal传统banner</param>
    /// <param name="_googlePos">banner位置，默认底部居中</param>
    /// 
    
    HCSDKManager.Instance.ShowBanner(HCAdsManager.HCBannerType.Collapsible, GoogleMobileAds.Api.AdPosition.Bottom);
}
```
说明：传入可折叠类型时，SDK会根据可折叠banner广告ID去请求广告，在返回的banner类型中，不一定是折叠banner，也有可能返回的是普通banner；因此在调用展示banner时，可能会展示普通banner。

## 隐藏Banner广告
```c
public void Button_HideBanner()
{
    HCSDKManager.Instance.HideBanner();
}
```

