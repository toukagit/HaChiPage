---
sidebar_position: 7
---

# Android

### 1、如遇下边问题，请确认VPN或更换节点
#### a. 打包报错
![](/img/HCSDK/image21.jpg)

#### b. AppLovin面板无法正常显示广告源 

![](/img/HCSDK/image22.png)

正常面板（会显示各广告源信息）

![](/img/HCSDK/image23.png)

解决方案：<br/>

```c
可尝试配置我们自己代理仓库

maven { url 'http://8.222.231.179:8081/repository/maven-public/' }
maven { url 'https://repo.dgtverse.cn/repository/maven-public/' }
```

![](/img/HCSDK/image24.jpg)

![](/img/HCSDK/image25.jpg)

### 2、如果卡在如下界面比较久，可以执行如下命令（请注意换为自己对应的目录，如果对应位置temp as工程已经生成可操作），看是否可正常编译出包。

![](/img/HCSDK/image26.jpg)

Temp as工程路径：<br/>
/Project/Temp/gradleOut<br/>
/Project/Library/Bee/Android/Prj/IL2CPP/Gradle<br/>
命令：<br/>

```c
C:\opt\gradle-6.7.1-all\gradle-6.7.1\bin\gradle -p "C:\Users\Administrator\Downloads\gradleOut\gradleOut" assembleRelease -Dorg.gradle.java.home=C:\opt\Unity\Hub\Editor\2020.3.48f1c1\Editor\Data\PlaybackEngines\AndroidPlayer\OpenJDK
```

### 3、请确保这个目录下没有其他非必要aar文件，正常没有aar文件才对。如果有请清空后，重新勾选如图配置。

![](/img/HCSDK/image27.png)

![](/img/HCSDK/image28.png)


### 4、本地仓库文件夹有可能会被自动删除掉，请确保本地仓库路径在，没有请重新导入sdk或者还原目录

### 5、下边这个测试广告存在适配问题，忽略即可。正式广告正常不会有问题。

![](/img/HCSDK/image30.jpg)

### 6、Google Play测试账号充值弹银行卡绑定，请确认以下流程是否正确。

正常后台添加好测试账号后，设备登录好测试账号，尽量确保设备只登录了这一个谷歌账号。然后用设备浏览器打开测试链接加入。就应该可以正常使用测试模式测试支付。

### 7、初始化有商品信息没获取到，请确认代码里id及商品类型和后台配置是否一致。

### 8、若使用YooAsset后editor里会丢失材质，可确认这个开关关闭。

![](/img/HCSDK/image31.jpg)
