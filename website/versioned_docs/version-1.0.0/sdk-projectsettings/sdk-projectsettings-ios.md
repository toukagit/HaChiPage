---
sidebar_position: 7
---

# 构建iOS平台

## 方式一：使用指定账号构建游戏

### 证书设置
请根据苹果开发者账号类型，进行如下证书设置。
### 1. 公司类型苹果开发者账号
<b>首先，我们会给您提供的 Apple ID 授权苹果开发者账号权限。</b>    <br/>    
请确认您的 Apple ID 已被授权苹果开发者账号权限并且您已经确认接受了该权限。然后在Xcode中登录您的Apple ID。   <br/>   
<b>然后，请安装我们提供的 iOS 证书。</b>    <br/>   
请确认您已经安装了我们提供的iOS证书。 (<font color="#ff0000">公司类型账号不需要额外提供描述文件「mobileprovision」。</font>安装iOS证书后，可尝试重启Xcode使其进行生效。)  <br/>   
<b>最后，请在Xcode中进行自动签名的设置。</b>    <br/>  

 ![ios_autocert](/img/tkg/sdk-config/projectsettings/config_ios_autocert.jpg)
### 2. 个人类型苹果开发者账号
<b>首先，我们会给您提供的 Apple ID 授权苹果开发者账号权限。</b>    <br/>    
请确认您的 Apple ID 已被授权苹果开发者账号权限并且您已经确认接受了该权限。然后在Xcode中登录您的Apple ID。   <br/>     
<b>然后，请安装我们提供的 iOS 证书和描述文件。</b>    <br/>   
请确认您已经安装了我们提供的iOS证书和描述文件。 (安装后，可尝试重启Xcode使其进行生效。)  <br/>   
<b>最后，请在Xcode中进行如下设置。</b>    <br/>  

 ![ios_autocert](/img/tkg/sdk-config/projectsettings/config_ios_noautocert.jpg)
 设置完成后即可自行上传App Store。

## 方式二：使用自有账号构建游戏
使用自有账号发布游戏时，需提供以下物料：<br/>   
1、集成完毕的Xcode工程，Xcode工程能正常运行无报错、崩溃。<br/>  
2、自有账号证书、p12文件以及添加了我们测试设备UDID（UDID请与商务联系获取）的描述文件。

### 账号相关物料准备
** 1、登录苹果开发者后台: https://developer.apple.com<br/>   
2、选择证书选项：
![](/img/3.0.1/cer/pic1.jpg)<br/>   
3、选择类型为 Distribution 的证书
![](/img/3.0.1/cer/pic2.jpg)<br/>  
4、下载:
![](/img/3.0.1/cer/pic3.jpg)<br/>  
5、双击安装下载证书：
![](/img/3.0.1/cer/pic4.jpg)<br/>  
6、打开Mac电脑钥匙串应用程序：
![](/img/3.0.1/cer/pic5.jpg)<br/>  
7、找到第5步安装的证书,右键导出证书：
![](/img/3.0.1/cer/pic6.jpg)<br/>  
8、导出个人信息交换(.p12)类型证书：
![](/img/3.0.1/cer/pic7.jpg)<br/>  
9、添加测试设备UDID（联系商务获取测试设备UDID）：<br/>
9.1
![](/img/3.0.1/cer/pic15.jpg)<br/>
9.2
![](/img/3.0.1/cer/pic16.jpg)<br/>
9.3
![](/img/3.0.1/cer/pic17.jpg)<br/>
10、创建 Ad Hoc 类型描述文件<br/>
10.1
![](/img/3.0.1/cer/pic8.jpg)<br/>
10.2
![](/img/3.0.1/cer/pic9.jpg)<br/> 
10.3 
![](/img/3.0.1/cer/pic10.jpg)<br/>  
10.4
![](/img/3.0.1/cer/pic11.jpg)<br/>  
10.5
![](/img/3.0.1/cer/pic12.jpg)<br/>  
10.6
![](/img/3.0.1/cer/pic13.jpg)<br/>  
10.7
![](/img/3.0.1/cer/pic14.jpg)<br/> 
11、创建 App Store 类型描述文件  
11.1
![](/img/3.0.1/cer/pic8.jpg)<br/>
11.2
![](/img/3.0.1/cer/pic18.jpg)<br/>
·<br/>
·<br/>
·（同Ad Hoc）<br/>
·<br/>
·<br/>
11.3
![](/img/3.0.1/cer/pic19.jpg)<br/>
请将4、8、10.7、11.3的文件以及Xcode工程打包发送给我们，待我们测试完成后会将App Store类型的IPA包发送给您，使用Transporter上传IPA。
**  


