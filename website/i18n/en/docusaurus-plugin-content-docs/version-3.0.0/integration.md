---
title: "SDK Integration"
sidebar_label: "SDK Integration"
description: ""
sidebar_position: 2
---
This page shows you how to configure the Android/iOS platform.

:::danger

 - **For the android platform, the following Settings are required. For details, see [【Build Android Platform 】](sdk-projectsettings/sdk-projectsettings-android.md)**       

:::

## Unity Android platform setup
#### 1、Enable Android Auto-resolution? Please check "Disable".

<center>

<img src="../img/HCSDK/image40.png"/>

</center>

#### 2、Enable Android Gradle templates? Please check "Disable".

<center>

<img src="../img/HCSDK/image39.png" width="50%" height="80%"/>

</center>

#### 3、Player Setting
- Mininum API Level is set to 23
- Target API Level is set to 34
- Set IL2CPP
- Select ARMv7 and ARM64

<center>

<img src="../img/HCSDK/image04.png" width="80%" height="80%"/>

</center>

#### 4、Tick configuration

<center>

<img src="../img/HCSDK/image38.jpeg" width="80%" height="60%"/>

</center>


#### 5、Assets/Plugins/Android/FirebaseApp.androidlib directory path does not exist or is empty cases need to check:
1、 Check whether GoogleService.json(Android) has been copied in [ Parameter Configuration ](#parameter-configuration)<br/>
2、Restart the unity editor.

<!--跳转语法-->
<!--大写字母改成小写-->
<!--特殊字符全删除-->
<!--空格改成横线（-）-->

## Unity iOS platform setup

<center>

<img src="../img/HCSDK/image06.png" width="70%" height="70%"/>

</center>


## Parameter Configuration
1. the requirements document configuration file :<br/> ** GoogleService-Info.plist **(iOS project will have this file) <br/> **google-services.json **(Android project will have this file) <br/> Added to the project **Assets/** root directory. (If the sdk originally had this test file, please delete it, make sure to use the parameter file corresponding to the game) <br/><br/>

<center>

![](/img/HCSDK/image42.png)

</center>


2. Put the configuration file in the requirements document in the ** Assets/StreamingAssets/ ** directory<br/><br/>

<center>

![](/img/HCSDK/image14.png)

</center>

Note: The above documents can be found in the requirements document, as shown below：<br/>
![](/img/HCSDK/image36.jpeg)

## Project configuration 

FB SDK configuration: Fill in the Facebook AppName(Current App Name) App Id and Client Token: <br/>

![](/img/HCSDK/image15.png)
![](/img/HCSDK/image16.png)  





## Initialize SDK
```c
void Start()
{
    HCSDKManager.Instance.InitializeSdk(InitSdkCallback);
}

private void InitSdkCallback()
{
    // SDK initialization completes the callback
}
```
The initialization method automatically initializes the following parts:

* AppTrackingTransparency system (iOS ATT box)
* Statistics
* Advertising

## How do I determine the current SDK version
The SDK Version can be obtained in the ** HCNativeInterface.cs ** file, as shown below:<br/><br/>

<center>

<img src="../img/HCSDK/image41.png" width="80%" height="80%"/>

</center>
