---
sidebar_position: 7
---

# 构建iOS平台

### 1、Cocopods
由于广告及 Firebase 是由 Cocopods 管理，所以导出 xcode 工程后，需要通过 pod install 命令来安装第三方库。<br/>
打开终端，cd至导出的xcode项目目录，执行 pod install，执行成功后，打开白色的 Unity-iPhone.xcworkspace 进行项目调试。

![](/img/HCSDK/image07.png)

![](/img/HCSDK/image08.png)

### 2、iOS Google登录

需要获取reversed client ID 和 clientID

![](/img/HCSDK/image09.png)

将reversed client ID 和 client 添加至 info.plist中

![](/img/HCSDK/image10.png)

![](/img/HCSDK/image11.png)


### 3、Apple登录

![](/img/HCSDK/image12.png)

![](/img/HCSDK/image13.png)

