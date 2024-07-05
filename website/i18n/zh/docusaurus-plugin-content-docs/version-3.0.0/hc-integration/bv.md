---
title: "Banner广告"
sidebar_label: "Banner广告"
description: ""
sidebar_position: 3
---

## 一、加载Banner广告

调用SDK初始化后，SDK内部自动加载Banner广告。

## 二、展示Banner广告
```c

public void Button_ShowBanner()
{
    /// <summary>
    /// 展示banner广告
    /// </summary>
    /// <param name="_pos">banner显示位置</param>
    HCSDKManager.Instance.ShowBanner(MaxSdkBase.BannerPosition _pos);
}
```

## 三、隐藏Banner广告
```c
public void Button_HideBanner()
{
    HCSDKManager.Instance.HideBanner();
}
```

