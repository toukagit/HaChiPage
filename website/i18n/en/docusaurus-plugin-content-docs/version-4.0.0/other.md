---
title: "Other functions"
sidebar_label: "Other functions"
description: ""
sidebar_position: 3
---

## Review

Call to pop-up Google/Apple system review box.
```c
HachiMgr.Instance.OpenStoreReview();
```

** Google reviews need to be sent to the Google background to pop up. <br/>
Apple needs to review before it can pop up reviews, and reviews cannot pop up on TestFlight. <br/>**


## Vibration
```c
// Vibration strength: 0: slight 1: moderate 2: severe
// Vibration time: 0 ~ 1
HachiMgr.Instance.TriggerHapticFeedback(1,0.5f);
```

## Gets the current user source
```c
void Start()
{
        HachiMgr.Instance.RegisterUserAttributionHandler(UserSourceListenerCallback);
}
    
private void UserSourceListenerCallback(bool isOrganic, string network)
{
    HMDebugger.LogDebug("SetUserSourceListenerCallback isOrganic:" + isOrganic + "network:" + network);
}
```
User source callback, bool: true natural user false unnatural user

## Firebase activates the callback

Must be set before SDK initialization; In this callback, you can obtain the latest remote online parameters.

```c
HachiMgr.Instance.SetFirebaseFetchDataAsyncSuccess = (result)=> {
    
    // result = true The activation succeeds, false the activation fails
    HMDebugger.LogDebug("Firebase fetch remote config result:"+result);
    
};
```

## Privacy protocol interface
 ```c
HachiMgr.Instance.OpenPrivacyPolicy();

```

## Delete all SDK-related files
![](/img/HCSDK/image34.jpg)

After clicking, all SDK files will be removed. If the following error occurs when you reimport SDK again, please restart unity<br/>

![](/img/HCSDK/image35.jpeg)

## Sensitive word interface
```

public enum SensitiveType
{
    //1: Nickname (Short text)
    //2: Chat (long text)
    //3: International business multilingual
    NickName = 1,
    Chat = 2,
    Global = 3
    
}

public enum SensitiveAppType
{
    //0: Domestic app
    //1: Wechat mini program
    app = 0,
    wx_app = 1
}

HachiMgr.Instance.CheckSensitiveWords("test title",HMSensitive.SensitiveType.Global, (result, content) =>
 {

     if (result)
     {
         // Does not contain sensitive words
     }
     else
     {
         // Contains sensitive words, content is the text after removing sensitive words, sensitive words will be replaced by the symbol *
     }

 },HMSensitive.SensitiveAppType.app);

```

## Push notification（v2.3.5 new）

- Request notification rights
```c
HachiMgr.Instance.RequestNotificationPermission();
```
When this interface is invoked, the SDK requests notification rights.

- Register notification callback(optional)

```c

// Return the registration token of the current device notification
HachiMgr.Instance.RegisterNotificationTokenReceived += OnReveiveNotificationToken;


// Return the Custom data configured in the firebase background. The custom data is returned as a dictionary.
HachiMgr.Instance.RegisterNotificationOnMessageReceived += OnMessageReceive;


private void OnReveiveNotificationToken(string token)
{
    // The current device receives the notification token
    HMDebugger.LogDebug("token:"+token);
}


private void OnMessageReceive(Dictionary<string, string> data)
{
    // Return the custom key pair configured in the firebase background
    foreach (var item in data)
    {
        HMDebugger.LogDebug("receive dataKey:"+item.Key+" dataValue:"+item.Value);
    }
}
```
When notified by HachiMgr. Instance. OnNotificationOnMessageReceived callback receives firebase backend configuration custom key-value pairs.

## Multilingual translation interface (v3.5.6 new)

```c 
public enum TranslateType
{
    //1:Chat (cached for 1 hour)
    //2:Other (Cache for 1 month)
    Chat = 1,
    Other = 2
}


/// <summary>
/// Multilingual translation interface
/// </summary>
/// <param name="text">The text content to be translated</param>
/// <param name="type">Type 1: Chat, 2: Others (Announcements, emails, etc.)</param>
/// <param name="targetLang">The target language to be translated, e.g. zh-cn; ja-jp;  ko-kr;  vi-vi, etc</param>
/// <param name="_action">Whether the translation was successful or not, true: The translation was successful, false: The translation failed; The text returns an empty string</param>
public void TranslateWords(string text, TranslateType type, string targetLang, Action<bool, string> _action)
{
    HachiMgr.Instance.TranslateText(text, type, targetLang, _action);
}

```

## Get the URL interface for cloud storage save (v4.0.1 new)
```c
/// <summary>
/// Get the cloud storage save URL
/// </summary>
/// <returns></returns>

var storeUrl = HachiMgr.Instance.GetCloudStorageUrl();
```

## Get the URL interface for cloud storage details (v4.0.1 new)
```c
/// <summary>
/// Get the URL for cloud storage details
/// </summary>
/// <returns></returns>

var storeDetailUrl = HachiMgr.Instance.GetCloudStorageDetailUrl();
```

<!--- Gets whether you have notification permission-->
<!--```c-->
<!--var permission = HachiMgr.Instance.IsGrantedNotificationPermission();-->
<!--```-->
<!--This interface is used to obtain whether the current application has the notification permission.-->
<!---->
<!--- Turn Push on/off-->
<!--```c-->
<!--// Open notification-->
<!--HachiMgr.Instance.PushSwitch(true);-->
<!---->
<!--// Close notification-->
<!--HachiMgr.Instance.PushSwitch(false);-->
<!--        -->
<!--```-->
<!--- Whether the push function is enabled-->
<!--```c-->
<!--var pushOpen = HachiMgr.Instance.IsPushOpen();-->
<!--```-->
<!--This interface is used to determine whether the application push function is enabled.-->
