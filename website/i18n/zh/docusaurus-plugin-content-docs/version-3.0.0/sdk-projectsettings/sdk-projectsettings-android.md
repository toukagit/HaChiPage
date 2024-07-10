---
sidebar_position: 7
---

# 构建Android平台

## 1、Unity版本高于2022.3
当所使用的Unity版本高于2022.3时，参照[【Unity Android平台设置】](integration.md)即可。

## 2、Unity版本低于2022.3

:::tip

 如果使用Mac电脑打包：请现在终端执行命令：sudo spctl --master-disable ，输入电脑密码后即允许安装身份不明开发者软件。 
:::

### 2.1 打包步骤

#### 2.1.1 下载JDK/Gradle: [UnityAndroidSDKTool.zip](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/UnityAndroidSDKTool.zip)

#### 2.1.2 打开Hachi SDK Android 打包界面

![](/img/HCSDK/image52.png)  

#### 2.1.3 将刚才下载的UnityAndroidSDKTool.zip中的JDK和Gradle设置在下图中1、2位置，并设置好签名文件，点击BuildAPK或其他选项。
![](/img/HCSDK/image53.png)  



### 2.2 问题及解决方案

##### 2.2.1 确保Package Manager中没有Unity自带的广告Advertisement Legacy，如果有还请移除此插件
    
![](/img/HCSDK/image54.png)  

##### 2.2.2 无法打开"java",因为无法验证开发者
![](/img/HCSDK/image55.png)  
![](/img/HCSDK/image56.png)  

##### 2.2.3 无法打开"libnative-platform.dylib",因为无法验证开发者。
![](/img/HCSDK/image57.png)  
![](/img/HCSDK/image58.png)  
