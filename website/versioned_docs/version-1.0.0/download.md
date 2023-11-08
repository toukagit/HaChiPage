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
<!--下载最新的Unity插件-->
[HCSDK_1.1.0_ece3fb8.unitypackage](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/1.1.0/HCSDK_1.1.0_ece3fb8.unitypackage)<br/>

将插件导入Unity<br/>
执行以下步骤导入下载的插件:<br/>
在Unity中，选择Assets > Import Package > Custom Package…<br/>
选择你下载的Unity Plugin文件。<br/>
在Import Unity Package对话框中，单击Import。<br/>

## 参数配置
1、将 Firebase的GoogleSerivce-info.plist(iOS)文件和GoogleService.json(Android)添加至项目Assets根目录下。（如sdk原来带有该测试文件请删掉，确保用对应游戏的参数文件）<br/>
2、在 ** HCStaticParams.cs ** 中填写好相应的参数<br/>

```c

// ApplovinKey
public static string ApplovinKey = "";

#if UNITY_ANDROID
        // 包名
        public static string BundleID = "";

        // Adjust token
        public static string AdjustToken = "";

        // TD ThinkingData
        public static string TDAppID = "";
        public static string TDServerURL = "";

        // Ads
        // 插屏广告位ID
        public static string InterAdUnitID = "";
        //激励视频广告位ID
        public static string RewardAdUnitID = "";

#else
        // 包名
        public static string BundleID = "";
        // Adjust token
        public static string AdjustToken = "";

        // TD ThinkingData
        public static string TDAppID = "";
        public static string TDServerURL = "";

        // Ads
        // 插屏广告位ID
        public static string InterAdUnitID = "";
        //激励视频广告位ID
        public static string RewardAdUnitID = "";
#endif

```

## 项目配置
在 MAX 面板中配置好admobID、ApplovinKey：<br/>

![](/img/HCSDK/image01.png)
![](/img/HCSDK/image02.png)  

## 初始化SDK
```c
HCSDKManager.Instance.InitializeSdk(InitSdkCallback);

private void InitSdkCallback()
{
    // SDK初始化完成回调
}
```
初始化方法会自动初始化以下部分：

* AppTrackingTransparency system (iOS ATT弹框)
* 统计
* 广告
