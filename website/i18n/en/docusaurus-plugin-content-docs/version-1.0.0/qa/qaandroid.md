---
sidebar_position: 7
---

# Android

### 1、If the following problems occur, confirm the VPN or replace the node
#### a. Packing error
![](/img/HCSDK/image21.jpg)

#### b. The AppLovin panel cannot display the AD feed properly

![](/img/HCSDK/image22.png)

Normal panel (displays information about each AD source)

![](/img/HCSDK/image23.png)

Solution:<br/>

```c
Try configuring our own proxy warehouse

maven { url 'http://8.222.231.179:8081/repository/maven-public/' }
maven { url 'https://repo.dgtverse.cn/repository/maven-public/' }
```

![](/img/HCSDK/image24.jpg)

![](/img/HCSDK/image25.jpg)

### 2、If the interface is stuck for a long time, you can run the following command to check whether the package can be compiled properly. (Change the directory to your own directory. If the temp as project has been generated in the corresponding location, you can operate it.)

![](/img/HCSDK/image26.jpg)

Temp as Project path：<br/>
/Project/Temp/gradleOut<br/>
/Project/Library/Bee/Android/Prj/IL2CPP/Gradle<br/>
command：<br/>

```c
C:\opt\gradle-6.7.1-all\gradle-6.7.1\bin\gradle -p "C:\Users\Administrator\Downloads\gradleOut\gradleOut" assembleRelease -Dorg.gradle.java.home=C:\opt\Unity\Hub\Editor\2020.3.48f1c1\Editor\Data\PlaybackEngines\AndroidPlayer\OpenJDK
```

### 3、Please make sure that there are no other non-essential aar files in this directory. If yes, clear it and select it again as shown in the figure.

![](/img/HCSDK/image27.png)

![](/img/HCSDK/image28.png)


### 4、The local repository folder may be automatically deleted. Please ensure that the local repository path is there. If no, please re-import the sdk or restore the directory.

### 5、The following test AD has adaptation problems, you can ignore it. Formal advertising works fine.

![](/img/HCSDK/image30.jpg)

### 6、Google Play test account recharge with bank card binding, please confirm the following process is correct.

After the test account is added in the normal background, the device logs in to the test account and tries to ensure that the device only logs in to this Google account. Then open the test link in your device's browser to join. You should be able to test payments using test mode normally.

### 7、Initial product information is not obtained, please confirm that the id and product type in the code are consistent with the background configuration.

### 8、If you lose materials in the editor after using YooAsset, make sure this switch is turned off.

![](/img/HCSDK/image31.jpg)
