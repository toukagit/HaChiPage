---
title: "Interstitial"
sidebar_label: "Interstitial"
description: ""
sidebar_position: 1
---

The SDK will handle the plug-in advertising loading logic, and the game side can call the display plug-in advertising method as needed.

##  Interstitial Ad isReady 

```c  
HCSDKManager.Instance.IsInterstitialReady("IV_Unlock", HCIVADType.IV1)
```


## Showing an Interstitial Ad
```c

    /// <summary>
    /// 
    /// </summary>
    /// <param name="_adPos">interstitial pos</param>
    /// <param name="_IvType">interstitial type</param>
    /// <param name="_closeCallback">interstitial close callback</param>
    HCSDKManager.Instance.ShowInterstitial("IV_Unlock", HCIVADType.IV1, Action _closeCallback);


    e.g.
    public enum HCIVPositionName
    {
        IV_Unlock,
        IV_Auto
    }

    private void Button_ShowIV1()
    {
        
        if(HCSDKManager.Instance.IsInterstitialReady(HCIVPositionName.IV_Unlock.ToString(), HCIVADType.IV1))
        {
            HCSDKManager.Instance.ShowInterstitial(HCIVPositionName.IV_Unlock.ToString(), HCIVADType.IV1, InterAdCloseCallback);
        }
    }


    private void InterAdCloseCallback(bool result)
    {
        if(result)
        {
           HCDebugger.LogDebug("close interstitial");
        }
        else
        {
            HCDebugger.LogDebug("The interstitial ad is not ready or failed to display due to certain conditions");
        }
    }
```

** _adPos **：Insert advertising spot name, insert advertising spot name in [product requirements document]. You are advised to customize the enumeration according to the required document or download the file to a customized directory.[(SDKPositionName.cs)](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/SDKPositionName.cs)<br/>
** _IvType **：Type of frequency control Default set IV1. IV2 can be used if required.<br/>
** _closeCallback **：Interstitial close callback; true: returned when the interstitial is closed, false: returned when the interstitial is not ready or fails to display due to certain conditions.


** _adPos enumeration definition example:**<br/>

For example, the requirements document is as follows:

<center>

<img src="../../img/HCSDK/image59.png" width="80%" height="80%"/>

</center>

** e.g：**<br/>

```c
public enum HCIVPositionName
{
    IV_Unlock,
    IV_Auto
}


HCSDKManager.Instance.ShowInterstitial(HCIVPositionName.IV_Unlock.ToString(), HCIVADType.IV1,(result)=> 
{
    if(result)
    {
       HCDebugger.LogDebug("close interstitial");
    }
    else
    {
        HCDebugger.LogDebug("The interstitial ad is not ready or failed to display due to certain conditions");
    }
});
```



