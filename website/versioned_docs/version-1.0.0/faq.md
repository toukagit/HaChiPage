---
title: "FAQ"
sidebar_label: "FAQ"
description: ""
sidebar_position: 96
---

## iOS
### Legacy Build System Error on Xcode

When exporting the project to Xcode, if you see a building error saying, "The Legacy Build System will be removed in a future release. You can configure the selected build system and this deprecation message in File > Project Settings" please do the following to resolve this issue.   


Step1. Navigate to File, then select Project Settings  

![iOS Symbols](/img/tkg/faq/legal01.png) 
  
Step2. Under Shared Project Settings, change the Build System settings to New Build System  

![iOS Symbols](/img/tkg/faq/legal02.png)

### Library not loaded:  ....KSAdSDK....  Error on Xcode   
If you see a building error about KSAdSDK similar to the screenshot below. Please do the [[Add dynamic library for ads sdk](./tkg-integration/sdk-projectsettings/sdk-projectsettings-ios.md) steps to resolve this issue.
![ks_01_error](/img/tkg/sdk-config/projectsettings/ks_01_error.png)


### Required parameter is empty

InitSDK will check the necessary parameters. If the following error is reported, please [check the parameter configuration](./tkg-integration/sdk-basic/sdk-config.md).  

![check_config](/img/tkg/basicintegration/checkConfig.jpeg)

## Android

### Target API Level Error
Please Build Package -> For Android ->[Minimun API Level : API Level 22](./tkg-integration/sdk-projectsettings/sdk-projectsettings-android.md)

![Target API Level Error](/img/tkg/faq/androidtargetapi.jpg)