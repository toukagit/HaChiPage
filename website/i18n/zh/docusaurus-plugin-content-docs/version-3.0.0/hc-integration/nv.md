---
title: "Native广告"
sidebar_label: "Native广告"
description: ""
sidebar_position: 3
---

SDK内部会处理native广告加载逻辑，游戏侧根据需要调用展示/隐藏native方法即可。

## Native广告是否可用
```c
var isNativeReady = HCSDKManager.Instance.IsNativeAdReady();

if (isNativeReady)
{
    HCDebugger.LogDebug("Native广告准备好了");

}else
{
    HCDebugger.LogDebug("Native广告没有准备好");
}
```

## 展示Native广告
```c
public void Button_ShowNative()
{
    HCSDKManager.Instance.ShowNative(nativeImage.rectTransform);
}
```

```c
API:
void ShowNative(RectTransform pRect, Camera pCam = null, string pAdPos = "");
```

** RectTransform **：需要展示原生广告Image的RectTransform。<br/>
** pCam **：如果UI使用相机模式，必须使用正交相机。<br/>
** pAdPos **：展示原生广告的位置打点。

Native位置讲解<br/>
<font color="#ff0000">请将nativeImage的透明度设置为0。
这里设置为白色只是为了展示native广告的大小。<br/></font>
需要展示native的位置：

![](/img/HCSDK/image03.png)

## 移除Native广告
```c
public void Button_RemoveNative()
{
    HCSDKManager.Instance.RemoveNative();
}
```
<font color="#ff0000">有调用展示Native广告接口时，一定要调用移除Native广告接口，否则会出现遮挡游戏问题。<br/></font>
