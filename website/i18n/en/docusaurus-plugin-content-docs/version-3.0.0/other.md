---
title: "Other functions"
sidebar_label: "Other functions"
description: ""
sidebar_position: 3
---

## The game loses/gains focus
```c
HCSDKManager.Instance.SetGameFocusListener((_isFocus) => {
    if (_isFocus)
    {
        Debug.Log("set game focus");
    }
    else
    {
        Debug.Log("lose game focus");
    }
});
```
Set the game to lose/gain focus callback, the SDK will give a callback every time triggered to the corresponding situation.<br/>
For example, when a commercial starts playing, your game will lose focus. When the AD is over, return to the game and your game will gain focus.
## Review

```c
HCSDKManager.Instance.Review();
```
Call to pop-up Google/Apple system review box.

## Vibration
```c
// Vibration strength: 0: slight 1: moderate 2: severe
// Vibration time: 0 ~ 1
HCSDKManager.Instance.Shake(1,0.5f);
```

## Gets the current user source
```c
void Start()
{
    HCSDKManager.Instance.SetUserSourceListenerCallback(UserSourceListenerCallback);
    
}
    
private void UserSourceListenerCallback(bool isOrganic, string network)
{
    HCDebugger.LogDebug("SetUserSourceListenerCallback isOrganic:" + isOrganic + "network:" + network);
}
```
User source callback, bool: true natural user false unnatural user

## Firebase activates the callback

Must be set before SDK initialization; In this callback, you can obtain the latest remote online parameters.

```c
HCSDKManager.Instance.SetFirebaseFetchDataAsyncSuccess = (result)=> {
    
    // result = true The activation succeeds, false the activation fails
    HCDebugger.LogDebug("Firebase fetch remote config result:"+result);
    
};
```

## Privacy protocol interface
 ```c
HCSDKManager.Instance.OpenPrivacy();

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

HCSDKManager.Instance.CheckSensitiveWords("test title",HCSensitive.SensitiveType.Global, (result, content) =>
 {

     if (result)
     {
         // Does not contain sensitive words
     }
     else
     {
         // Contains sensitive words, content is the text after removing sensitive words, sensitive words will be replaced by the symbol *
     }

 },HCSensitive.SensitiveAppType.app);

```

## Push notification（v2.3.5 new）
- Register notification callback

```c

// Return the registration token of the current device notification
HCSDKManager.Instance.OnNotificationTokenReceived += OnReveiveNotificationToken;


// Return the Custom data configured in the firebase background. The custom data is returned as a dictionary.
HCSDKManager.Instance.OnNotificationOnMessageReceived += OnMessageReceive;


private void OnReveiveNotificationToken(string token)
{
    // The current device receives the notification token
    HCDebugger.LogDebug("token:"+token);
}


private void OnMessageReceive(Dictionary<string, string> data)
{
    // Return the custom key pair configured in the firebase background
    foreach (var item in data)
    {
        HCDebugger.LogDebug("receive dataKey:"+item.Key+" dataValue:"+item.Value);
    }
}
```
When notified by HCSDKManager. Instance. OnNotificationOnMessageReceived callback receives firebase backend configuration custom key-value pairs.

- Request notification rights
```c
HCSDKManager.Instance.ReqNotificationPermission();
```
When this interface is invoked, the SDK requests notification rights.

<!--- Gets whether you have notification permission-->
<!--```c-->
<!--var permission = HCSDKManager.Instance.IsGrantedNotificationPermission();-->
<!--```-->
<!--This interface is used to obtain whether the current application has the notification permission.-->
<!---->
<!--- Turn Push on/off-->
<!--```c-->
<!--// Open notification-->
<!--HCSDKManager.Instance.PushSwitch(true);-->
<!---->
<!--// Close notification-->
<!--HCSDKManager.Instance.PushSwitch(false);-->
<!--        -->
<!--```-->
<!--- Whether the push function is enabled-->
<!--```c-->
<!--var pushOpen = HCSDKManager.Instance.IsPushOpen();-->
<!--```-->
<!--This interface is used to determine whether the application push function is enabled.-->
