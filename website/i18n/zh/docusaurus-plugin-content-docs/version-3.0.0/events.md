---
title: "事件埋点"
sidebar_label: "事件埋点"
description: ""
sidebar_position: 96
---
## 一、 关卡进度事件
关卡进度事件用于分析用户在游戏中的关卡行为，其中包括关卡开始，关卡结束等事件。       

:::tip
<b><font color="ff0000">关卡类游戏必须调用关卡进度事件。</font></b>      


1、游戏每局开始时调用「关卡开始事件」: ** LevelEnter **  
2、游戏每局结束时调用「关卡结束事件 」: ** LevelEnd **
- 当局游戏成功: ** Success **
- 当局游戏失败: ** Fail **
- 在未结算前，用户选择马上结束当局游戏并重新开始。如在当局游戏内点击重试: ** Retry **
- 在未结算前，用户选择马上退出游戏并返回游戏列表界面或主界面。如在当局游戏内点击返回或退出按钮: ** Back **

:::

### 关卡开始事件 

```c
HCSDKManager.Instance.LevelEnter("1"); 
   
HCSDKManager.Instance.LevelEnter(1);

HCSDKManager.Instance.LevelEnter("S_1");

HCSDKManager.Instance.LevelEnter("S_1",new Dictionary<string, object>() {{ "s_id", 9 },{ "s_type","10"} });
```

** 调用时机：** 游戏每局开始时调用。  

** API:  **    
void LevelEnter(int level,Dictionary<string, object> extraInfos = null);    
void LevelEnter(string level,Dictionary<string, object> extraInfos = null);     

<table>
  <tr>
    <td>Name</td>
    <td>isRequired</td>
    <td>Type</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>level</td>
    <td>Y</td>
    <td>int/string</td>
    <td>
    level为正在进行的关卡序号值。      <br />    
    具体值请参看产品需求文档中"关卡进度事件接入"  
    </td>
  </tr>
    <tr>
    <td>extraInfos</td>
    <td>N</td>
    <td>Dictionary</td>
    <td>
    拓展字段      <br />    
    具体值请参看产品需求文档中"关卡进度事件接入"  
    </td>
  </tr>
</table>



### 关卡结束事件 
```c
HCSDKManager.Instance.LevelEnd("1", StageResult.Success); 

HCSDKManager.Instance.LevelEnd(1, StageResult.Success);

HCSDKManager.Instance.LevelEnd("S_1", StageResult.Fail);

HCSDKManager.Instance.LevelEnd(3, StageResult.Retry);

HCSDKManager.Instance.LevelEnd("S_2", StageResult.Back);

HCSDKManager.Instance.LevelEnd("S_2", StageResult.Success,new Dictionary<string, object>() {{ "s_id", 9 },{ "s_type","10"} });
```
** 调用时机：** 游戏每局结束时调用。

** API: **    
void LevelEnd(int _level, StageResult _stageResult,Dictionary<string, object> extraInfos = null);    
void LevelEnd(string _level, StageResult _stageResult,Dictionary<string, object> extraInfos = null);

<table>
  <tr>
    <td>Name</td>
    <td>isRequired</td>
    <td>Type</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>level</td>
    <td>Y</td>
    <td>int/string</td>
    <td>
    level为正在进行的关卡序号值。          <br />
    具体值请参看产品需求文档中"关卡进度事件接入"  
    </td>
  </tr>
  <tr>
    <td>stageResult</td>
    <td>Y</td>
    <td>StageResult</td>
    <td>
        Success: 当局游戏成功  <br /><br />
        Fail: 当局游戏失败  <br /><br />
        Retry: 在未结算前，用户选择马上结束当局游戏并重新开始。如在当局游戏内点击重试。  <br /><br />
        Back: 在未结算前，用户选择马上退出游戏并返回游戏列表界面或主界面。如在当局游戏内点击返回或退出按钮。  <br />
    </td>
  </tr>
    <tr>
    <td>extraInfos</td>
    <td>N</td>
    <td>Dictionary</td>
    <td>
    拓展字段          <br />
    具体值请参看产品需求文档中"关卡进度事件接入"  
    </td>
  </tr>
</table>



## 二、设置公共事件属性（只用于报到数数）

```c
Dictionary<string, object> superProperties = new Dictionary<string, object>();
superProperties["channel"] = "ta";//字符串
superProperties["age"] = 1;//数字
superProperties["isSuccess"] = true;//布尔
superProperties["birthday"] = DateTime.Now;//时间
superProperties["object"] = new Dictionary<string, object>() { { "key", "value" } };//对象
superProperties["object_arr"] = new List<object>() { new Dictionary<string, object>() { { "key", "value" } } };//对象组
superProperties["arr"] = new List<object>() { "value" };//数组

HCSDKManager.Instance.SetSuperProperties(superProperties);
```

## 三、设置用户属性（只用于报到数数）
```c
Dictionary<string, object> userProperties = new Dictionary<string, object>();
userProperties["user_name"] = "TA";

HCSDKManager.Instance.SetUserProperties(userProperties);
```

## 四、自定义事件上报
```c
HCSDKManager.Instance.LogEvent("Event01");

HCSDKManager.Instance.LogEvent("Event02", "key01","value01",TrackEventPlatform.Firebase);

HCSDKManager.Instance.LogEvent("Event03", "key01", "value01", "key02", "value02",TrackEventPlatform.TD);

HCSDKManager.Instance.LogEvent("Event04", new Dictionary<string, object>() { { "key01", "value01" } });
```

默认上报Firebase/数数，如需单独上报某一个统计平台需通过 **TrackEventPlatform** 枚举控制
