---
title: "Policy compliance"
sidebar_label: "Policy compliance"
description: ""
sidebar_position: 3
---

# Policy compliance

## User Agreement
```c
/// <summary>
/// Display the user agreement and ask if you agree
/// </summary>
/// <param name="hasPurchase">Whether it includes in-app purchase items, true: Includes in-app purchase items; false: No in-app purchase items included</param>
/// <param name="_closeCallbackallback">The callback for closing the user agreement page.</param>

HachiMgr.Instance.ShowUserAgreementWithPurchase(true, () =>
{
    HMDebugger.LogDebug("The user agreement window is closed");
});
```


The SDK has a built-in pop-up box. After calling the interface, it is displayed as shown in the following figure：
<center>

<img src="../img/HCSDK/image74.jpg" width="30%" height="30%"/> 
</center>


## Information pop-up

```c
HachiMgr.Instance.PopPrivacyPolicy();
```

The SDK has a built-in pop-up box. After calling the interface, it is displayed as shown in the following figure:
<center>

<img src="../img/HCSDK/image75.jpg" width="30%" height="30%"/> 
</center>

## Age-appropriate indication

```c
/// <summary>
/// After clicking the age button, the SDK displays the age-appropriate prompt on the subsequent page
/// </summary>
HachiMgr.Instance.ShowAgeView();

/// <summary>
/// Hide the subsequent pages of the age-appropriate prompt displayed in the SDK
/// </summary>
HachiMgr.Instance.HideAgeView();
```

After the developer sets the age position, the SDK page will be displayed when the user clicks the age button, as shown in the following figure:
<center>

<img src="../img/HCSDK/image76.jpg" width="30%" height="30%"/> 
</center>
The age button is hidden when the game loading page is closed.

## Real-name authentication
You need to log in first. Then, based on the certificationType in the login callback, determine whether the real-name authentication pop-up box needs to be displayed. If the account has already been authenticated, there is no need to display the real-name authentication pop-up box.

```c
/// <summary>
/// Real-name authentication interface
/// </summary>
/// <param name="_closeCallback">Turn off the callback</param>

HachiMgr.Instance.ShowUserVerification(() =>
{
    // The real-name authentication pop-up box is closed
});
```
The real-name authentication pop-up window is as shown in the following picture:
<center>

<img src="../img/HCSDK/image77.jpg" width="30%" height="30%"/> 
</center>

## Anti-addiction
```c
/// <summary>
/// Anti-addiction interface
/// </summary>
/// <param name="_callback">is_allowed whether to enter the game,0: not allowed, 1: allowed; left_time The remaining valid time in seconds; msg error message</param>
/// <param name="_callback">is_allowed=1,left_time=0 Represent adults</param>

HachiMgr.Instance.CheckAntiAddictionPlayable((allow, time, msg) =>
{
    HMDebugger.LogDebug("CheckAntiAddictionPlayable allow:"+allow+" time:"+time+" msg:"+msg);
});
```

** e.g.：** 
``` c
/// <summary>
/// Real-name authentication type
/// </summary>
public enum CertificationType
{
    /// <summary>
    /// Default value: Authentication is not enabled
    /// </summary>
    None = 0,

    /// <summary>
    /// Not real-name verified. Real-name authentication is required through a pop-up window on the client
    /// </summary>
    NotCertified_Client = 1,

    /// <summary>
    /// Real-name verification has been completed. You can directly enter the game
    /// </summary>
    Certified = 2,

    /// <summary>
    /// Not real-name verified. Use the Alibaba client for authentication
    /// </summary>
    NotCertified_Ali = 3
}

HachiMgr.Instance.Login(new HMLoginRequest(HMLoginType.LOGIN_BY_GUESTER), (LoginInfo) =>
{
    // Login successful
    if (LoginInfo.loginStatus == HMLoginStatus.LOGIN_STATUS_SUCC)
    {
        if(LoginInfo.userInfo.certificationType != CertificationType.Certified)
        {
            // Those who have not been authenticated will be shown with real-name authentication
            HachiMgr.Instance.ShowUserVerification(() =>
            {
                // Real-name authentication is disabled. Request anti-addiction. A countdown pop-up box will be displayed
                HachiMgr.Instance.CheckAntiAddictionPlayable((allow, time, msg) =>
                {
                    // allow: Whether entry is permitted, time: The remaining valid time in seconds, msg error message
                    // is_allowed=1,left_time=0 represents adults
                    HMDebugger.LogDebug("CheckAntiAddictionPlayable allow:"+allow+" time:"+time+" msg:"+msg);
                });
            });
        }
        else
        {
            HachiMgr.Instance.CheckAntiAddictionPlayable((allow, time, msg) =>
            {
                HMDebugger.LogDebug("CheckAntiAddictionPlayable allow:"+allow+" time:"+time+" msg:"+msg);
            });
        }
    }
    else
    {
        // Login failed
        
    }
});

```
