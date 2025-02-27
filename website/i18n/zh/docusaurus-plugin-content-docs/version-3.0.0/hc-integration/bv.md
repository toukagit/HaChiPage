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


## 横幅广告关闭按钮
折叠横幅广告不显示关闭按钮。只有普通横幅广告显示。通过回调来处理横幅广告关闭按钮的位置。

### 示例

![](/img/HCSDK/image65.png)

### 在SDK初始化之前设置回调

```c

// bool：显示/隐藏横幅右上角的关闭按钮，默认情况下需要隐藏。
// Vector2：广告的像素大小。注意UI大小的转换。
public void SetBannerCustomCloseBtnDisplayChanged(Action<bool, Vector2> _bannerCustomCloseBtnChanged)

例：
HCSDKManager.Instance.SetBannerCustomCloseBtnDisplayChanged(DealBannerCustomCloseBtnDisplay);
```
### 接收回调，处理关闭按钮的显示和隐藏，并设置按钮的位置

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
