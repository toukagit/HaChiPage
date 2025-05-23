---
title: "Native"
sidebar_label: "Native"
description: ""
sidebar_position: 3
---

The SDK will handle the native AD loading logic internally, and the game side can call the display/hide native method as needed.

## Is Native ad available
```c
var isNativeReady = HCSDKManager.Instance.IsNativeAdReady();

if (isNativeReady)
{
    HCDebugger.LogDebug("Native ad is ready ");

}else
{
    HCDebugger.LogDebug("Native ad not ready");
}
```

## Showing a Native Ad
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

** RectTransform **：Need to display the RectTransform of the native AD Image.<br/>
** pCam **：If the UI uses camera mode, you must use an orthogonal camera.<br/>
** pAdPos **：Display native ads in the location of the dot.

Native location explanation<br/>
<font color="#ff0000">Set the transparency of nativeImage to 0.
This is set to white just to show the size of the native AD.<br/></font>
Need to show native location:

![](/img/HCSDK/image03.png)

## Removing a Native Ad
```c
public void Button_RemoveNative()
{
    HCSDKManager.Instance.RemoveNative();
}
```
<font color="#ff0000">When there is a call to display Native advertising interface, be sure to call to remove Native advertising interface, otherwise there will be a blocking game problem.<br/></font>
