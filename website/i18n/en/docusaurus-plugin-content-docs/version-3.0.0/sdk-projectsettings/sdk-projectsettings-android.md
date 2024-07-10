---
sidebar_position: 7
---

# For Android

## 1、Unity version 2022.3 or later
If the version of Unity used is later than 2022.3, see [ 【Unity Android Platform Settings】 ](integration.md)

## 2、Unity version 2022.3 or earlier

:::tip

 If you are using a Mac, run the command sudo spctl --master-disable on the terminal and enter the password to allow the installation of the unidentified developer's software.
:::

### 2.1 Packing procedure

#### 2.1.1 Download JDK/Gradle:  [UnityAndroidSDKTool.zip](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/UnityAndroidSDKTool.zip)
#### 2.1.2 Open the Hachi SDK Android packaging screen

![](/img/HCSDK/image52.png)
  
#### 2.1.3 Set JDK and Gradle in the UnityAndroidSDKTool.zip you just downloaded at positions 1 and 2 in the image below, and set up the signature file, click BuildAPK or other options.
![](/img/HCSDK/image53.png)  


### 2.2 Problems and solutions

##### 2.2.1 Make sure there is no Advertisement Legacy that comes with Unity in the Package Manager. If there is, remove it
    
![](/img/HCSDK/image54.png)  

##### 2.2.2 Cannot open "java" because the developer cannot be verified
![](/img/HCSDK/image55.png)  
![](/img/HCSDK/image56.png)  

##### 2.2.3 "libnative-platform.dylib" cannot be opened because the developer cannot be verified
![](/img/HCSDK/image57.png)  
![](/img/HCSDK/image58.png)  
