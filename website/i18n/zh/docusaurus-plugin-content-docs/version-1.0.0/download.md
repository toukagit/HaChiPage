---
title: "SDK集成"
sidebar_label: "SDK集成"
description: ""
sidebar_position: 2
---
本页向您展示如何下载、导入和配置HaChi  Unity Plugin。

:::tip

 - **接入HaChiSDK 需要 Xcode 14.2 或更高版本**       
 - **更新新版本SDK最好先将老版本SDK删除，配置文件除外。并且导出新的Xcode或者Android Studio工程，注意不要覆盖导出到老版本SDK导出的工程。**   

:::


## 下载最新的Unity插件 
[HCSDK_2.3.3_bf14994.unitypackage](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/2.3.3/HCSDK_2.3.3_bf14994.unitypackage)（[更新日志](/versions)）
<br/><a id='click'>    </a>


将插件导入Unity<br/>
执行以下步骤导入下载的插件:<br/>
在Unity中，选择Assets > Import Package > Custom Package…<br/>
选择你下载的Unity Plugin文件。<br/>
在Import Unity Package对话框中，单击Import。

## 参数配置
1、将需求文档中配置文件:<br/> ** GoogleService-Info.plist  **(iOS项目会有这个文件) <br/> **google-services.json **(Android项目会有这个文件) <br/>添加至项目 Assets 根目录下。（如sdk原来带有该测试文件请删掉，确保用对应游戏的参数文件）<br/>

2、将需求文档中配置文件:<br/>52593f719455c63e2c694b6a4329442b(示例，每个项目配置文件不同)<br/>e33da49e299189c9cf85cdc069cb8ee3(示例，每个项目配置文件不同)<br/>放在 **Assets/StreamingAssets** 目录下即可<br/>
![](/img/HCSDK/image14.png)

注：上述文件均可在需求文档中找到，如下图：<br/>
![](/img/HCSDK/image36.jpeg)



## 项目配置
FB SDK配置：填入 **Facebook AppName(当前游戏名称)**、 **App Id（需求文档中查找）** 以及 **Client Token（需求文档中查找）**：<br/>

![](/img/HCSDK/image15.png)
![](/img/HCSDK/image16.png)  

## Unity Android平台设置
#### 1、当弹出Enable Android Gradle templates？时，请勾选 "Disable"
![](/img/HCSDK/image39.png)  

#### 2、Player Setting设置
- Mininum API Level 设置为22
- Target API Level 请设置为33
- 设置IL2CPP
- 勾选ARMv7和ARM64

![](/img/HCSDK/image04.png)  

#### 3、勾选配置
![](/img/HCSDK/image38.jpg)

#### 4、Unity版本低于2022.3需要使用自定义gradle配置。
"工具栏>Settings>Preferences > External Tools", 取消 "Gradle Installed with Unity (recommended)" 同时设置自定义gradle路径。<br/>
自定义gradle版本要求大于6.7.1，推荐下载 https://downloads.gradle.org/distributions/gradle-6.7.1-all.zip 并解压。

![](/img/HCSDK/image05.png)  

#### 5、Assets/Plugins/Android/FirebaseApp.androidlib路径不存在或者目录为空的情况下需要检查：
1、 检查[【参数配置】](#click)中GoogleService.json(Android)是否已经拷贝进来。<br/>
2、重启unity编辑器。

## Unity iOS平台设置

![](/img/HCSDK/image06.png)  

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
