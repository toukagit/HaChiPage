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

Level Start Call: ** LogLevelEnter **   
Level End Call: ** LogLevelEnd **
- Level has ended with succ : ** Success **
- Level has ended with failed: ** Fail **
- Before level end, restart level. eg. click Retry button in the current level: ** Retry **
- Before level end, back to home page or level list. For example click back or quit buttons in current level: ** Back **
:::

### LevelStart 
```c
HachiMgr.Instance.LogLevelEnter("1");

HachiMgr.Instance.LogLevelEnter(1);

HachiMgr.Instance.LogLevelEnter("S_1");

HachiMgr.Instance.LogLevelEnter("S_1",new Dictionary<string, object>() {{ "s_id", 9 },{ "s_type","10"} });

```
Call `LevelEnter` method when starting each level.

** API: **

void LogLevelEnter(int level,Dictionary<string, object> extraInfos = null);    
void LogLevelEnter(string level,Dictionary<string, object> extraInfos = null);     

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
    <td>extraInfos</td>
    <td>N</td>
    <td>Dictionary</td>
    <td>
    Extended field      <br />    
    You can get the specific values  「Level Progress Event Access」 on your game product requirement.  
    </td>
  </tr>
</table>


### LevelEnd

```c
HachiMgr.Instance.LogLevelEnd("1", StageResult.Success); 

HachiMgr.Instance.LogLevelEnd(1, StageResult.Success);

HachiMgr.Instance.LogLevelEnd("S_1", StageResult.Fail);

HachiMgr.Instance.LogLevelEnd(3, StageResult.Retry);

HachiMgr.Instance.LogLevelEnd("S_2", StageResult.Back);

HachiMgr.Instance.LogLevelEnd("S_2", StageResult.Success,new Dictionary<string, object>() {{ "s_id", 9 },{ "s_type","10"} });

```

Call `LevelEnd` method when finish each level.   

** API: **    
void LogLevelEnd(int _level, StageResult _stageResult,Dictionary<string, object> extraInfos = null);    
void LogLevelEnd(string _level, StageResult _stageResult,Dictionary<string, object> extraInfos = null);

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
    <b>Success:</b> Level has ended with succ   <br />
    <b>Fail:</b> Level has ended with failed  <br />
    <b>Retry:</b> Before level end, restart level. eg. click Retry button in the current level <br />
    <b>Back:</b> Before level end, back to home page or level list. For example click back or quit buttons in current level
    </td>
  </tr>
      <tr>
    <td>extraInfos</td>
    <td>N</td>
    <td>Dictionary</td>
    <td>
    Extended field          <br />
    You can get the specific values  「Level Progress Event Access」 on your game product requirement.  
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

HachiMgr.Instance.SetSuperProperties(superProperties);
```

## Set user properties (for TD only)
```c
Dictionary<string, object> userProperties = new Dictionary<string, object>();
userProperties["user_name"] = "TA";

HachiMgr.Instance.SetUserProperties(userProperties);
```

## User-defined event reporting
```c
HachiMgr.Instance.LogEvent("Event01");

HachiMgr.Instance.LogEvent("Event02", "key01","value01",TrackEventPlatform.Firebase);

HachiMgr.Instance.LogEvent("Event03", "key01", "value01", "key02", "value02",TrackEventPlatform.TD);

HachiMgr.Instance.LogEvent("Event04", new Dictionary<string, object>() { { "key01", "value01" } });
```

Firebase/ TD is reported by default. If a statistical platform needs to be reported separately, use the **TrackEventPlatform** enumeration
