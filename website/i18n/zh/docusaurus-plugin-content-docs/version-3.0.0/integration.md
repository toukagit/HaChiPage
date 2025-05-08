---
title: "SDK集成"
sidebar_label: "SDK集成"
description: ""
sidebar_position: 2
---
本页向您展示如何配置Android/iOS平台。

:::danger

 - ** Android平台需按照如下设置，出包时请参照 [ 【构建 Android 平台】 ](sdk-projectsettings/sdk-projectsettings-android.md) **       

:::


## Unity Android平台设置
#### 1、当弹出Enable Android Auto-resolution?时，请勾选 "Disable"

<center>

<img src="../img/HCSDK/image40.png"/>

</center>

#### 2、当弹出Enable Android Gradle templates？时，请勾选 "Disable"

<center>

<img src="../img/HCSDK/image39.png" width="50%" height="80%"/>

</center>

#### 3、Player Setting设置
- Mininum API Level 设置为24
- Target API Level 请设置为34
- 设置IL2CPP
- 勾选ARMv7和ARM64

<center>

<img src="../img/HCSDK/image04.png" width="80%" height="80%"/>

</center>


#### 4、勾选配置

<center>

<img src="../img/HCSDK/image38.jpeg" width="80%" height="60%"/>

</center>

#### 5、Assets/Plugins/Android/FirebaseApp.androidlib路径不存在或者目录为空的情况下需要检查：
1、 检查[【参数配置】](#参数配置)中GoogleService.json(Android)是否已经拷贝进来。<br/>
2、重启unity编辑器。

## Unity iOS平台设置

<center>

<img src="../img/HCSDK/image06.png" width="70%" height="70%"/>

</center>


## 参数配置
1、将需求文档中配置文件:<br/> ** GoogleService-Info.plist  **(iOS项目会有这个文件) <br/> **google-services.json **(Android项目会有这个文件) <br/>放在 ** Assets/** 根目录下。（如sdk原来带有该测试文件请删掉，确保用对应游戏的参数文件）<br/><br/>

<center>

![](/img/HCSDK/image42.png)

</center>


2、将需求文档中配置文件:<br/>52593f719455c63e2c694b6a4329442b(示例，每个项目配置文件不同)<br/>e33da49e299189c9cf85cdc069cb8ee3(示例，每个项目配置文件不同)<br/>放在 **Assets/StreamingAssets/** 目录下即可<br/><br/>

<center>

![](/img/HCSDK/image14.png)

</center>



注：上述文件均可在需求文档中找到，如下图：<br/>
![](/img/HCSDK/image36.jpeg)



## 项目配置
FB SDK配置：填入 **Facebook AppName(当前游戏名称)**、 **App Id（需求文档中查找）** 以及 **Client Token（需求文档中查找）**：<br/>

![](/img/HCSDK/image15.png)
![](/img/HCSDK/image16.png)  

## 初始化SDK
```c
void Start()
{
    HCSDKManager.Instance.InitializeSdk(InitSdkCallback);
}

private void InitSdkCallback()
{
    // SDK初始化完成回调
}
```
初始化方法会自动初始化以下部分：

* AppTrackingTransparency system (iOS ATT弹框)
* 统计
* 广告


## 如何确定当前SDK版本
SDK Version 可以在 ** HCNativeInterface.cs ** 文件中获取，如下图:<br/><br/>

<center>

<img src="../img/HCSDK/image41.png" width="80%" height="80%"/>

</center>
