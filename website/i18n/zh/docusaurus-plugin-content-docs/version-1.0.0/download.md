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
[HCSDK_2.0.0_32a0ea8.unitypackage](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/2.0.0/HCSDK_2.0.0_32a0ea8.unitypackage)（[更新日志](/versions)）
<br/><a id='click'>    </a>


将插件导入Unity<br/>
执行以下步骤导入下载的插件:<br/>
在Unity中，选择Assets > Import Package > Custom Package…<br/>
选择你下载的Unity Plugin文件。<br/>
在Import Unity Package对话框中，单击Import。

## 参数配置
1、将 Firebase的GoogleSerivce-info.plist(iOS)文件和GoogleService.json(Android)添加至项目Assets根目录下。（如sdk原来带有该测试文件请删掉，确保用对应游戏的参数文件）<br/>
2、在 ** HCStaticParams.cs ** 中填写好相应的参数<font color="ff0000">（v2.0.0以上版本无需设置）</font><br/>

```c
    public static string ApplovinKey = "";

#if UNITY_ANDROID
    // Bundle id
    public static string BundleID = "";


    // Adjust
    public static string AdjustToken = "";


    // TD ThinkingData
    public static string TDAppID = "";
    public static string TDServerURL = "https://ss.zolnm.com";

    // Ads
    public static string BannerAdUnitID = "";
    public static string InterAdUnitID = "";

    // 提审模式下激励视频广告位ID
    public static string ReviewRewardUnitId = "";

    // 线上激励视频广告位ID
    public static string RewardAdUnitID = "";
    public static string NativeAdUnitID = "";
    public static string AppOpenAdUnitID = "";

#else
    // Bundle id
    public static string BundleID = "";
    // Adjust
    public static string AdjustToken = "";

    // TD ThinkingData
    public static string TDAppID = "";
    public static string TDServerURL = "https://ss.zolnm.com";

    // Ads
    public static string BannerAdUnitID = "";
    public static string InterAdUnitID = "";
    // 提审模式下激励视频广告位ID
    public static string ReviewRewardUnitId = "";

    // 线上激励视频广告位ID
    public static string RewardAdUnitID = "";
    public static string NativeAdUnitID = "";
    public static string AppOpenAdUnitID = "";

#endif
```

3、将需求文档中的配置文件放在 Assets/StreamingAssets 目录下即可 <font color="ff0000">（v2.0.0版本新增）</font>
## 项目配置<font color="ff0000">（v2.0.0以上版本无需设置）</font>
在 MAX 面板中配置好admobID、ApplovinKey：<br/>

![](/img/HCSDK/image01.png)
![](/img/HCSDK/image02.png)  

## Unity Android平台设置
#### 1、Player Setting设置
- Mininum API Level 设置为22
- Target API Level 请设置为33
- 设置IL2CPP
- 勾选ARMv7和ARM64

![](/img/HCSDK/image04.png)  

#### 2、Unity版本低于2022.3需要使用自定义gradle配置。
"工具栏>Settings>Preferences > External Tools", 取消 "Gradle Installed with Unity (recommended)" 同时设置自定义gradle路径。<br/>
自定义gradle版本要求大于6.7.1，推荐下载 https://downloads.gradle.org/distributions/gradle-6.7.1-all.zip 并解压。

![](/img/HCSDK/image05.png)  

#### 3、Assets/Plugins/Android/GooglePlayGamesManifest.androidlib路径不存在或者目录为空的情况下需要检查：
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
