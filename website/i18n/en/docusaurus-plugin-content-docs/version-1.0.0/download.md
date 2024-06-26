---
title: "SDK Integration"
sidebar_label: "SDK Integration"
description: ""
sidebar_position: 2
---
This page shows you how to download, import, and configure the HaChi Unity Plugin.

:::tip

 - **Xcode 14.2 or later is required to access the HaChiSDK.**       
 - **If you want to update a new version of the SDK, delete the old version of the SDK first, except the configuration file. And export new Xcode or Android Studio projects, be careful not to overwrite projects exported to older versions of the SDK.**   

:::


## Download the latest Unity plugin<br/>
[HCSDK_2.3.5_6f1b955.unitypackage](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/2.3.5/HCSDK_2.3.5_6f1b955.unitypackage)（[Release note](/versions)）
<a id='click'>    </a>

Import the plugin into Unity<br/>
Perform the following steps to import the downloaded plug-in:<br/>
In Unity, select Assets > Import Package > Custom Package...<br/>
Select the Unity Plugin file you downloaded.<br/>
In the Import Unity Package dialog box, click Import.<br/>

## How do I determine the current SDK version
The SDK Version can be obtained in the ** HCNativeInterface.cs ** file, as shown below:<br/><br/>

<center>

<img src="../img/HCSDK/image41.png" width="80%" height="80%"/>

</center>


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
- Mininum API Level is set to 22
- Target API Level is set to 33
- Set IL2CPP
- Select ARMv7 and ARM64

<center>

<img src="../img/HCSDK/image04.png" width="80%" height="80%"/>

</center>

#### 4、Tick configuration

<center>

<img src="../img/HCSDK/image38.jpg" width="80%" height="60%"/>

</center>

#### 5、Unity versions later than 2022.3 require a custom gradle configuration.
"toolbar>Settings>Preferences > External Tools", Cancel "Gradle Installed with Unity (recommended)" Also set a custom gradle path.<br/>
Custom than 6.7.1 gradle version requirements, recommend download  https://downloads.gradle.org/distributions/gradle-6.7.1-all.zip  and decompression.

<center>

<img src="../img/HCSDK/image05.png" width="80%" height="80%"/>

</center>

#### 6、Assets/Plugins/Android/FirebaseApp.androidlib directory path does not exist or is empty cases need to check:
1、 Check whether GoogleService.json(Android) has been copied in [Parameter Configuration ](#click).<br/>
2、Restart the unity editor.

## Unity iOS platform setup

<center>

<img src="../img/HCSDK/image06.png" width="70%" height="70%"/>

</center>


## Parameter configuration
1, the requirements document configuration file :<br/> ** GoogleService-Info.plist **(iOS project will have this file) <br/> **google-services.json **(Android project will have this file) <br/> Added to the project **Assets/** root directory. (If the sdk originally had this test file, please delete it, make sure to use the parameter file corresponding to the game) <br/><br/>
![](/img/HCSDK/image42.png)

2. Put the configuration file in the requirements document in the ** Assets/StreamingAssets/ ** directory<br/><br/>
![](/img/HCSDK/image14.png)

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
