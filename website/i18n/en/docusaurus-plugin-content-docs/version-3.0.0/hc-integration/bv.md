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

## Banner Close Btn Pos
The currently expanded banners do not display a close button. Only small banners show it.  Just handle it according to the callback.

### Usage examples

![](/img/HCSDK/image65.png)

### Set the listener before SDK initialization

```c

// bool ： Show/hide the close button in the upper right corner of the banner，It needs to be hidden by default.
// Vector2 ： The pixel size of the advertisement. Note the conversion with the UI size. 
public void SetBannerCustomCloseBtnDisplayChanged(Action<bool, Vector2> _bannerCustomCloseBtnChanged)

e.g.
HCSDKManager.Instance.SetBannerCustomCloseBtnDisplayChanged(DealBannerCustomCloseBtnDisplay);
```
### Receive the callback to handle the display and hiding of the close button and set the position of the button

```c
private void DealBannerCustomCloseBtnDisplay(bool _isDisplay, Vector2 _adsSize)
{
    if (_isDisplay)
    {
        float scaleFactor = canvas.scaleFactor;

        bannerClosebtn.gameObject.SetActive(true);
        RectTransform buttonRectTransform = bannerClosebtn.GetComponent<RectTransform>(); 
        Debug.Log("Close Btn Pos, x : " + _adsSize.x / 2 + " , y : " + _adsSize.y + " , scaleFactor:" + scaleFactor);
        float x = _adsSize.x / 2 / scaleFactor;
        float y = _adsSize.y / scaleFactor;
        buttonRectTransform.anchoredPosition = new Vector2(x, y);
    }
    else
    {
        bannerClosebtn.gameObject.SetActive(false);
    }
}
```





