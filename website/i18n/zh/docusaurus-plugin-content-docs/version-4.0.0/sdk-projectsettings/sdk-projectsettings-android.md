---
sidebar_position: 7
---

# 构建Android平台

:::tip

 如果使用Mac电脑打包：请现在终端执行命令：sudo spctl --master-disable ，输入电脑密码后即允许安装身份不明开发者软件。 <br/>
 目前已验证可使用2021.3.14、2022.3.56版本构建target35 Android包。
:::


## Android target35 出包
### 1 下载JDK/Gradle
 [UnityAndroidSDKTool35.zip](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/UnityAndroidSDKTool35.zip)

### 2 打开Hachi SDK Android 打包界面

![](/img/HCSDK/image52.png)  

### 3 设置JDK和Gradle
将刚才下载的UnityAndroidSDKTool.zip中的JDK和Gradle设置在下图中1、2位置，并设置好签名文件，点击BuildAPK或其他选项。
![](/img/HCSDK/image53.png)  

### 4 打包结果

#### 4.1 成功
打包成功后会弹出如下弹框：

![](/img/HCSDK/image62.png)  

apk在Assets同级目录下的 **HachiBuildTemp** 文件夹中：

![](/img/HCSDK/image63.png)  

#### 4.2 失败
打包失败时，请提供失败log文件，供我们分析具体失败原因，log文件在Assets同级目录下的 **HachiBuildTemp** 文件夹中：

![](/img/HCSDK/image64.png) 

### 5 问题及解决方案

#### 5.1 确保Package Manager中没有Unity自带的广告Advertisement Legacy，如果有还请移除此插件
    
![](/img/HCSDK/image54.png)  

#### 5.2 无法打开"java",因为无法验证开发者
![](/img/HCSDK/image55.png)  
![](/img/HCSDK/image56.png)  

#### 5.3 无法打开"libnative-platform.dylib",因为无法验证开发者。
![](/img/HCSDK/image57.png)  
![](/img/HCSDK/image58.png)  
