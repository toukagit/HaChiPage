---
title: "说明文档"
sidebar_label: "说明文档"
description: ""
sidebar_position: 96
---
## 一、模块介绍
### 1. 场景
需要将 MMOInitScene / MMOScene 场景添至Build Settings中，且 MMOInitScene 必须在第一位， 如下图：<br/><br/>
![](/img/robux/4.0/image1.jpg)  

### 2. 文件
路径：MMOModule/CustomLogic/ <br/>
文件：MMOInitLogic.cs、MMOLogic.cs、MMOAgent.cs<br/>
**MMOInitLogic：**初始化代码即第一个场景（MMOInitScene）挂载的脚本，游戏中如需添加一些初始化代码，可根据情况添加在注释标明的地方，如下图所示：<br/>
![](/img/robux/4.0/image2.png)  

**MMOLogic：**网赚场景逻辑，一般无需修改，若有展示banner需求，请将代码添加加在注释标明的地方，如下图所示：<br/>

![](/img/robux/4.0/image3.png)  

**MMOAgent：**修改文件中报错的方法，改为游戏内实现方法。各接口详细说明可参照IMMOAgent.cs中代码注释，如下所示：<br/>

![](/img/robux/4.0/image4.png)  

### 3. 事件
**MMOModule.Instance.OnEnter ：**网赚界面打开时触发，按需使用，一般用于隐藏Native广告等。
**MMOModule.Instance.OnExit ：**   网赚界面关闭时触发，按需使用。


### 4. 属性
**MMOModule.Instance.IsAccessible ：** 获取网赚功能是否开启(是否是网赚用户)，可用于显示/隐藏游戏中的Robux资源条，以及是否展示Native广告等。
**MMOModule.Instance.Credit ：** 玩家网赚积分，一般用于QA测试。（只读）
**MMOModule.Instance.Grade ：** 玩家网赚等级，可根据返回等级（T0/T1/T2）配置插屏播放规则。（只读）

### 5. 接口
所有接口通过单例：**MMOModule.Instance** 调用

```
// 网赚功能开关 
// pEnable 总开关
// pKeepLoading 是否保持使用网赚 loading 页面，无需处理
public void EnableMMO(bool pEnable, bool pKeepLoading = false);

e.g.
// 在游戏第一个场景 SDK 回调中初始化
private void Start()
{   
    TKGSDKManager.Instance.InitSDK(SDKDone);
}

private void SDKDone()
{
    MMOModule.Instance.EnableMMO(true);
}
```

```

// 开始游戏方法，每次重新加载游戏场景时先调用该方法
public void StartGame(Action pDelStartOver = null);

e.g.
// 游戏开始场景
private void Start()
{
    MMOModule.Instance.StartGame();
}
```

```
// 结束游戏方法，游戏结算界面点击下一关或回主页时都会调用
// pDelEndOver 回调，可以在回调中做增加关卡数、刷新关卡数据等处理
public void EndGame(Action pDelEndOver, bool pIsPerfect = false);

e.g.
// 结算页面点击下一关
private void OnClickNextLevel()
{
    MMOModule.Instance.EndGame(() =>
    {
        // 需改成游戏内实际方法
        // 存储用户数据，
        saveUserData(currentLevel++);
        // 进入下一关
        goNextLevel();
    });
}

```

```

// 用于网赚内部统计，在激励视频广告成功回调里调用
public void WatchRVSuccessfully();

e.g.
// 在激励视频广告成功回调里调用
TKGSDKManager.Instance.ShowRewardAd(pAdPos, (pResult) =>
{
    if (pResult)
    {
        MMOModule.Instance.WatchRVSuccessfully();
        ...
        ...
    }
}, null, true);

```

### 6. debug设置
在项目中搜索 MMOConstConfig ，如下所示<br/>

![](/img/robux/4.0/image5.png)  <br/>

**Enalbe MMO User Debug** 勾选后，游戏会根据 **Is Debug MMO User** 选项直接设置网赚用户，此功能用于出包自测，在出正式包时，一定要取消勾选 **Enalbe MMO User Debug。**

## 二、自定义UI
需根据实际游戏内容去调整位置或UI素材，功能无需处理。

### 1.  MMOUILoading - 预制体
路径：MMOModule/Controls/LoadingPanel/MMOUILoading.prefab<br/>
MMOUILoading 中的加载页面UI需替换成符合当前游戏的UI素材，调整界面布局保存即可无需主动使用。

### 2. MMOScene - 场景
MMOScene 场景如有素材替换需求则按需替换。
![](/img/robux/4.0/image6.png)  <br/>

## 三、通用控件（非必要，按需使用）

MMOModule/Controls/ResBar 中做好的 Prefab，如游戏本身没有现金或其他资源条功能，可直接在游戏中使用此ResBar.。游戏界面中需要一个Robux资源条，如游戏自身UI使用的不是Overlay模式，需要给现金条单独放到一个Overlay模式的Canvas里，因网赚内有的UI需要通过IMMOAgent里的CashBarTrans，将现金条放到最上层显示，飞现金效果结束后再放回原位置。


  <table>
    <tr>
        <td>API </td>
       
        <td> 参数 </td>
        <td> 说明 </td>
    </tr>
    
    <tr>
        <td>InitBar</td>
        <td>int pRes<br/>
            bool pShowRobux = false<br/>
            Camera pMainCam = null<br/>
            Camera pUICam = null<br/>
        </td>
        <td>初始化方法。<br/>
            pRes：当前钻石数<br/>
            pShowRobux：无需处理，使用默认值<br/>
            pMainCam：世界相机，一般自动默认Camera.Main<br/>
            pUICam：UI相机，如Canvas使用相机模式则需要传，Overlay模式则无需处理<br/></td>
    </tr>
    <tr>
        <td>FlyRes</td>
        <td>Vector3 pPos<br/>
            int pAdd<br/>
            int pFinal<br/>
        </td>
        <td>飞货币接口。<br/>
            pPos：飞行位置的起始UI位置<br/>
            pAdd：增加的钻石数量<br/>
            pFinal：最终的钻石数<br/></td>
    </tr>
    <tr>
        <td>PopRes</td>
        <td>int pDelta<br/>
            int pFinalDiamond<br/>
        </td>
        <td>钻石数量变化提示接口。增减钻石均可，只会在钻石条下方弹个数量变化提示。<br/>
            pDelta：变化的钻石数量<br/>
            pFinalDiamond：最终钻石数<br/></td>
    </tr>
    <tr>
        <td>RefreshRes</td>
        <td>int pDiamond<br/>
        </td>
        <td>钻石刷新接口。<br/>
            pDiamond：钻石数量<br/></td>
    </tr>
    <tr>
        <td>DelResRefresh</td>
        <td>-</td>
        <td>钻石刷新时的回调，可用于播放钻石获取的声音和轻微震动。<br/></td>
    </tr>
   
  </table>


## 四、常见问题

### 1. 货币系统
游戏内必须要有货币系统，网赚用户需展示Rubox货币，非网赚用户可不展示，如下所示：<br/><br/>
网赚用户：<br/>
![](/img/robux/output5.png)  
非网赚用户：<br/>
![](/img/robux/output6.png)  

### 2. 飞金币特效
若实现起来较困难或费时，可使用网赚模块自带的 ResBar.prefab，详细使用方法参见本文 第四章-通用控件

### 3. 网赚模块显示问题
如果网赚用户正确的显示了网赚内容后，当前进程中或再次重启后又不显示网赚内容时，游戏端应在 **SetFunctionSwitchListener** 方法中存储数值，从而保证网赚用户能一直展示网赚内容。

### 4. 网赚模块里气泡奖励间隔不正确
网赚模块中气泡奖励间隔是每三关一次，如显示不正确时，检查是否在每关开始时调用了 **MMOModule.Instance.StartGame();**

### 5. 看不到网赚入口
```
// 在初始化SDK后设置监听回调
TKGSDKManager.Instance.SetFunctionSwitchListener(new List<Touka.FunctionType>(){ FunctionType.Function_wangz}, OnFunsSwitchCallback);

// 存储网赚数据
private void OnFunsSwitchCallback(FunctionType _type, bool result)
{

    if (_type == FunctionType.Function_wangz)
    {
        if (result)
        {
            // 是网赚用户 
            // 存储数据
        }
    }
}
```

### 6. 广告遮挡问题
如图：<br/>
![](/img/robux/output7.png)  

```
// 设置监听
MMOModule.Instance.OnEnter += removeNative;

// 移除 native 广告
public void removeNative()
{
    TKGSDKManager.Instance.RemoveNative();
}
```

### 7. 弹出网赚的关卡结算奖励后，点击下一关，无法成功跳转到下一关
```
// 结算页面点击下一关
private void OnClickNextLevel()
{
    MMOModule.Instance.EndGame(() =>
    {
        // 需改成游戏内实际方法
        // 存储用户数据，
        saveUserData(currentLevel++);
        // 进入下一关
        goNextLevel();
    });
}
```

### 8. 卡在loading页面无法继续
请确认每次加载游戏场景中有调用： **MMOModule.Instance.StartGame();**

### 9. UI 适配问题
首先确保在 Unity Editor 中适配正常，出包后安卓刘海屏可能会存在适配问题。
![](/img/robux/output8.jpg)  
安卓刘海屏适配问题解决方案：将此脚本挂在UI根节点[XAdaptor.cs](https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Touka%20SDK/Unity%E6%B8%B8%E6%88%8F/Robux/XAdaptor.cs)。
