---
title: "Event Tracking"
sidebar_label: "Event Tracking"
description: ""
sidebar_position: 96
---
## Level Progression Events
Level progression events are used to track and analyze the user's level behavior in the game, Including level start, level end, etc.     

:::tip
<b><font color="ff0000">Attention: if you have ‘Levels’ / 'Quest' / 'Task' or 'Mission' in your game, you must integrate "Progression Events" !</font></b>         
<br />

Level Start Call: ** LevelStart **   
Level End Call: ** LevelEnd **
- Level has ended with succ : ** Level_Success **
- Level has ended with failed: ** Level_Fail **
- Before level end, restart level. eg. click Retry button in the current level: ** Level_Retry **
- Before level end, back to home page or level list. For example click back or quit buttons in current level: ** Level_Back **
:::

### LevelStart 
```c
HCSDKManager.Instance.LevelEnter("1");

HCSDKManager.Instance.LevelEnter(1);

HCSDKManager.Instance.LevelEnter("S_1");
```
Call `LevelEnter` method when starting each level.

API: <br />
void LevelEnter(int level);     
void LevelEnter(string level);

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
    level: current level id.         <br />
    You can get the specific values  「Level Progress Event Access」 on your game product requirement.  
  </td>
  </tr>
</table>


### LevelEnd

```c
HCSDKManager.Instance.LevelEnd("1", StageResult.Level_Success); 

HCSDKManager.Instance.LevelEnd(1, StageResult.Level_Success);

HCSDKManager.Instance.LevelEnd("S_1", StageResult.Level_Fail);

HCSDKManager.Instance.LevelEnd(3, StageResult.Level_Retry);

HCSDKManager.Instance.LevelEnd("S_2", StageResult.Level_Back);
```

Call `LevelEnd` method when finish each level.   

API:
void LevelEnd(int level, StageResult stageResult);<br/>
void LevelEnd(string level, StageResult stageResult);

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
    level: current level id.         <br />
    You can get the specific values  「Level Progress Event Access」 on your game product requirement.  
  </td>
  </tr>
  <tr>
    <td>stageResult</td>
    <td>Y</td>
    <td>StageResult</td>
    <td>
    <b>Level_Success:</b> Level has ended with succ   <br />
    <b>Level_Fail:</b> Level has ended with failed  <br />
    <b>Level_Retry:</b> Before level end, restart level. eg. click Retry button in the current level <br />
    <b>Level_Back:</b> Before level end, back to home page or level list. For example click back or quit buttons in current level
    </td>
  </tr>
</table>

## Set public event attributes (for TD only)

```c
Dictionary<string, object> superProperties = new Dictionary<string, object>();
superProperties["channel"] = "ta";//String
superProperties["age"] = 1;//int
superProperties["isSuccess"] = true;//bool
superProperties["birthday"] = DateTime.Now;//Time
superProperties["object"] = new Dictionary<string, object>() { { "key", "value" } };//Object
superProperties["object_arr"] = new List<object>() { new Dictionary<string, object>() { { "key", "value" } } };//Dictionary
superProperties["arr"] = new List<object>() { "value" };//Array

HCSDKManager.Instance.SetSuperProperties(superProperties);
```

## Set user properties (for TD only)
```c
Dictionary<string, object> userProperties = new Dictionary<string, object>();
userProperties["user_name"] = "TA";

HCSDKManager.Instance.SetUserProperties(userProperties);
```

## User-defined event reporting
```c
HCSDKManager.Instance.LogEvent("Event01");

HCSDKManager.Instance.LogEvent("Event02", "key01","value01",TrackEventPlatform.Firebase);

HCSDKManager.Instance.LogEvent("Event03", "key01", "value01", "key02", "value02",TrackEventPlatform.TD);

HCSDKManager.Instance.LogEvent("Event04", new Dictionary<string, object>() { { "key01", "value01" } });
```

Firebase/ TD is reported by default. If a statistical platform needs to be reported separately, use the **TrackEventPlatform** enumeration
