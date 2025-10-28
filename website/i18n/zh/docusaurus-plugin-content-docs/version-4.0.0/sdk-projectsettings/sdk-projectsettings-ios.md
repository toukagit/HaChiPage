---
sidebar_position: 7
---

# 构建iOS平台

### 1、Cocopods
由于广告及 Firebase 是由 Cocopods 管理，所以导出 xcode 工程后，需要通过 pod install 命令来安装第三方库。<br/>

#### 1.1 修改Podfile
** 每次导出工程时都需要移除以下代码段！**

```c
'target 'Unity-iPhone' do
end
```

#### 执行命令
打开终端，cd至导出的xcode项目目录，执行 

```c
pod install
```
执行成功后，打开白色的 Unity-iPhone.xcworkspace 进行项目调试。

![](/img/HCSDK/image07.png)

![](/img/HCSDK/image08.png)

### 2、添加动态库
#### 2.1 找到项目中Products，选择任一文件 Show in Finder
![](/img/HCSDK/image68.png)
#### 2.2 将下图中的 framework 拖至 TARGET 目录下 Unity-iPhone -> General ->Frameworks, Libraries, and Embedded Content 中，如下图：
![](/img/HCSDK/image70.png)
![](/img/HCSDK/image71.png)
![](/img/HCSDK/image72.png)


### 3、iOS Google登录

需要获取reversed client ID 和 clientID

![](/img/HCSDK/image09.png)

将reversed client ID 和 client 添加至 info.plist中

![](/img/HCSDK/image10.png)

![](/img/HCSDK/image11.png)


### 4、Apple登录

![](/img/HCSDK/image12.png)

![](/img/HCSDK/image13.png)

