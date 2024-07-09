---
title: "Banner广告"
sidebar_label: "Banner广告"
description: ""
sidebar_position: 3
---

SDK内部会处理banner广告加载逻辑，游戏侧根据需要调用展示/隐藏banner方法即可。

## 展示Banner广告
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

## 隐藏Banner广告
```c
public void Button_HideBanner()
{
    HCSDKManager.Instance.HideBanner();
}
```

