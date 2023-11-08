---
title: "Native广告"
sidebar_label: "Native广告"
description: ""
sidebar_position: 3
---

## 一、启动页
游戏每次启动时，应先展示MMOUILoading中内容，在MMOUILoading结束后进入游戏页面。<br/>
MMOModule prefab中MMOUILoading是包含默认的背景、icon、进度条图片，需确认是否替换与游戏契合的背景、icon以及进度条图片。

![](/img/robux/image.png)  

## 二、网赚内容展示
### 1. 非网赚用户
非网赚用户根据在线参数控制是否显示邀请按钮（InvitationBtn），默认不显示。<br/>
在测试阶段可通过将MMOModule类中IsInvitable属性设置为true，从而展示InvitationBtn进行调试。<br/>
点击InvitationBtn后，可见图二页面，输入正确的邀请码后，非网赚用户将成为网赚用户。<br/><br/>
![](/img/robux/image2.png)  ![](/img/robux/image3.png)  

### 2. 网赚用户
网赚用户将展示SkinBtn按钮、RobuxBtn按钮、LevelBar；点击Skin按钮或Robux按钮会分别跳转到图二图三界面。<br/><br/>
![](/img/robux/image4.png)  ![](/img/robux/image5.png)  ![](/img/robux/image6.png)  

### 3. LevelBar
每胜利通关后LevelBar的进度会增加；每胜利五关会有额外的Robux币奖励，通过观看激励视频后领取。<br/><br/>
![](/img/robux/image7.png)  

### 4. 气泡
每三关会出现气泡，点击观看激励视频后获取相应的Robux币。<br/><br/>
![](/img/robux/image8.png)  

## 三、UI遮挡
网赚内容的UI包括：InvitationBtn、SkinBtn、RobuxBtn、LevelBar；注意这四部分UI不要与其他UI遮挡。<br/>InvitationBtn和SkinBtn、RobuxBtn、LevelBar不会同时出现，在点击InvitationBtn完成邀请码填写且通过后，SkinBtn、RobuxBtn、LevelBar将展示出来，而InvitationBtn将不再展示。<br/>

![](/img/robux/image9.png)   ![](/img/robux/image10.png)  

## 四、网赚激励视频按钮

![](/img/robux/image11.png)  ![](/img/robux/image12.png) ![](/img/robux/image13.png) ![](/img/robux/image14.png) ![](/img/robux/image15.png) <br/>
所有网赚激励视频按钮点击后均可在Unity编辑器中获取相应奖励，如遇点击激励视频按钮后无法获得相应奖励时，请确认是否在TKGRVPositionName枚举中添加了对应的数值。

## 五、Robux货币数值

- 原则上不允许用户在过早关卡（40关前）获取超10W货币；因此前三关胜利展示结算界面时不能展示倍数滚动条以及Robux翻倍激励视频按钮，前三关失败时不予以奖励；后续在失败结算页面Robux的奖励数值为基础货币的30%。
- 每获取Robux货币后注意检查Robux数量是否有正确增加。

## 六、缺少LevelBar
如遇LevelBar缺失时，点击Robux按钮，填写Username并点击open后，LevelBar就能正常展示出来。<br/><br/>
![](/img/robux/image16.png) ![](/img/robux/image17.png) ![](/img/robux/image18.png)

## 七、iOS/Android真机自测方法
在真机运行时，可用如下方式模拟买量用户。<br/>
[SRDebugger 1.9.1.unitypackage](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Touka%20SDK/Unity%E6%B8%B8%E6%88%8F/Robux/SRDebugger%201.9.1.unitypackage)<br/>
[SROptions.Game.cs](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Touka%20SDK/Unity%E6%B8%B8%E6%88%8F/Robux/SROptions.Game.cs)

- 在Unity中导入SRDebugger1.9.1.unitypackage，添加SROptions.Game.cs文件，将SROptions.Game.cs文件中public bool 是否买量用户 修改为自己项目中买量用户的判断方法，如下图：<br/>

![](/img/robux/image19.png)

- Unity编辑器中设置SROptions

![](/img/robux/image20.png) ![](/img/robux/image21.png) ![](/img/robux/image22.png)<br/><br/>
- 连续点击debug按钮后出现以下界面，通过勾选来模拟网赚用户：<br/>

![](/img/robux/image23.png)<br/>

- 在真机调试完成后，一定要将SROptions关闭<br/>

![](/img/robux/image24.png)<br/>
