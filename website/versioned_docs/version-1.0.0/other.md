---
title: "Other functions"
sidebar_label: "Other functions"
description: ""
sidebar_position: 3
---

## 一、The game loses/gains focus
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
## 二、Review

```c
HCSDKManager.Instance.Review();
```
Call to pop-up Google/Apple system review box.

## 三、Vibration
```c
// Vibration strength: 0: slight 1: moderate 2: severe
// Vibration time: 0 ~ 1
HCSDKManager.Instance.Shake(1,0.5f);
```

## 四、Gets the current user source
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
