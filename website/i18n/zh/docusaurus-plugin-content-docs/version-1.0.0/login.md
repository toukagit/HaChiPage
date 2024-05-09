---
title: "账号系统"
sidebar_label: "账号系统"
description: ""
sidebar_position: 3
---

# 账号系统
:::tip 

在开始账号系统集成之前，请确认账号系统出现时机，并且选择所要支持的登录方式，我们提供游客登录、邮箱登录及第三方登录方式。        
除了账号登录以外，我们还支持账号删除（必选）、登录方式查询（必选）、账号登出、账号绑定、强制绑定、自动登录、返回当前账号类型、返回当前是否可以自动登录。        
HaChi SDK只提供登录接口，登录界面开发者可根据游戏UI风格和样式自行设计制作。

:::

### 1、账号系统出现时机
进入游戏后直接展示登录界面，玩家必须填写/勾选信息完成登录则可进入游戏。（仅首次进入展示游戏登录界面，后续使用已选方式直接登录即可。）

![](/img/HCSDK/login01.png)

玩家可游客静默登录立即进入游戏体验，在合适游戏位置进行账号绑定。  （非游客账号进入游戏，不显示绑定按钮。）

![](/img/HCSDK/login02.png)

### 2、说明
1. 单独调用游客登录、Google登录、Facebook登录、Apple登录会分别返回不同的UserID。（涉及账号绑定时的情况特殊。）
2. 注意登录是调用登录接口，登录成功后游客账号绑定到三方账号是调用绑定账号的接口，只有调用账号绑定接口时才会把游客账号和三方账号在SDK内部做一个绑定操作； 
3. 非游客账号类型登录成功后，不提供绑定功能（即不显示绑定按钮）。 游客绑定成功后返回的登录类型是对应绑定的三方账号类型，返回的UserID和游客登录时返回的UserID一致。

### 3、账号登录
登录类型
```c
public enum HCLoginType
{
    // 游客登录
    LOGIN_BY_GUESTER = 0,

    // 邮箱账号登录（暂不支持）
    LOGIN_BY_EMAIL = 1,

    // Google登录
    LOGIN_BY_GOOGLE = 2,

    // Facebook登录
    LOGIN_BY_FACEBOOK = 3,

    // Apple登录
    LOGIN_BY_Apple = 4,
    
    // Google Play Games Services 登陆
    LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES = 9,

    LOGIN_BY_GAMECENTER = 10,

    LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES_AUTO = 101,

    LOGIN_BY_GAMECENTER_AUTO = 102,
}
```

登录状态
```c
 public enum HCLoginStatus
{
    // 登录成功
    LOGIN_STATUS_SUCC = 0,

    // 登录被用户取消
    LOGIN_STATUS_CANCEL = 1,

    // 自动登陆没有缓存数据
    LOGIN_STATUS_NO_CACHE = 2,

    // 登录失败
    LOGIN_STATUS_FAILED = -1
}
```

登录
```c
public void ButtonEvent_GuestLogin()
{
    HCSDKManager.Instance.Login(HCLoginType.LOGIN_BY_GUESTER, _loginAction);
}

void Start()
{
    _loginAction = (LoginInfo) =>
    {
        Debug.Log($"登陆回调 {LoginInfo.loginStatus} type:{LoginInfo.userInfo.loginType} msg:{LoginInfo.loginMsg} userId:{LoginInfo.userInfo.userID} token:{LoginInfo.userInfo.token}");
        if (LoginInfo.loginStatus == HCLoginStatus.LOGIN_STATUS_SUCC)
        {
            // 登陆成功
            _userId = LoginInfo.userInfo.userID;
            _userType = LoginInfo.userInfo.loginType;
            _token = LoginInfo.userInfo.token;
        }
        else
        {
            // 登陆失败
            _userId = "";
            _userType = HCLoginType.LOGIN_BY_GUESTER;
            _token = "";
        }
};
```

登陆类型为`LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES_AUTO` , `LOGIN_BY_GAMECENTER_AUTO` 和其他社交登陆类型一样，有登陆和绑定功能， 只是首次登陆失败SDK内部会返回游客登陆类型。（其他社交登陆登陆失败就返回失败）走游客账号逻辑。 下次调用这个类型，sdk会优先走游客登陆，会尝试绑定社交类型。 <font color="#ff0000">开发者无需关心内部处理逻辑，根据登陆返回的登陆类型进行相关处理即可。（例如：游客类型显示绑定按钮）</font>



### 4、账号登出
账号登出接口可在游戏切换账号时进行调用，做登出操作。SDK完成账号退出会给游戏回调。 无需求场景可不进行调用。
```c
HCSDKManager.Instance.Logout();
```

### 5、登录方式查询接口
```c
List<HCLoginType> list = HCSDKManager.Instance.AvailableLoginChannelList();
```

### 6、账号删除
谷歌为了增强安卓生态的透明度，扩大用户对其数据的控制权。要求支持账号登录的游戏，必须要提供入口可使用户进行账号删除操作。必须结合界面在合适位置调用。 
```c
HCSDKManager.Instance.DeleteAccount();
```

### 7、账号绑定
:::info 说明
1. 账号绑定功能是为游戏内为游客登录时，把游客账号绑定到三方账号服务的。 
2. 只能是游客账号绑定到三方账号，且该游客账号绑定一次后不能再次绑定，如再调用绑定接口，会返回已绑定账号状态码； 
3. 游戏内可处理为绑定后不再显示绑定按钮。根据回调中的loginType为游客登录类型时才显示绑定按钮。 
4. 游客账号绑定到三方账号后返回的UserID仍为游客账号的UserID，只是在SDK内部将二者做了绑定操作。 
5. 只要游客账号没绑定过社交账号，就有绑定到社交账号的权利；如果社交账号已经被其他游客账号绑定过了，就有强制绑定的权利。这里会涉及到强制绑定的接口。 
6. 当用户使用已绑定过的社交账号进行绑定操作时，游戏可自行弹出界面列出2个账号及对应游戏进度，供玩家选择该社交账号与哪个账号进行绑定。玩家选择后，调用强制绑定接口即可。
7. <font color="#ff0000">绑定成功后游戏需要判断绑定成后后返回的UserID和当前登录的UserID是否一致，如果不一致，需要切换进度到绑定成功返回UserID的对应游戏进度（切换账号）。</font>

:::

```c
绑定类型
public enum HCBindAccountStatus
    {
        // 绑定失败
        BIND_CODE_FAILED = -1,
        // 绑定成功
        BIND_CODE_SUCC = 0,
        // 取消绑定
        BIND_CODE_CANCEL = 1,
        // 已经绑定账户，需要选择
        BIND_CODE_SELECT = 2,
    }
```

```c
void Start()
{   
    _bindAccountCallback = (BindInfo) =>
    {
        var bindStatus = BindInfo.bindStatus;
        var bindMsg = BindInfo.bindMsg;
        var userIdList = BindInfo.userIDs;
        var loginType = BindInfo.userInfo.loginType;
        var userID = BindInfo.userInfo.userID;
        var token = BindInfo.userInfo.token;
        var nickName = BindInfo.userInfo.nickName;
        var photoUrl = BindInfo.userInfo.photoUrl;
        
        Debug.Log($"绑定回调 {BindInfo.bindStatus} type:{BindInfo.userInfo.loginType} msg:{BindInfo.bindMsg} userId:{BindInfo.userInfo.userID} token:{BindInfo.userInfo.token} userIdList:{BindInfo.userIDs}");
        if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SELECT)
        {
            HCDebugger.LogDebug("绑定回调 - 选择界面");
            return;
        }

        if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SUCC)
        {
            HCDebugger.LogDebug("绑定回调 - 绑定成功");
            if (!BindInfo.userInfo.userID.Equals(_userId))
            {
                HCDebugger.LogDebug($"绑定回调 - 绑定成功 - 重新登陆 userId:{BindInfo.userInfo.userID} _userId:{_userId}");
                        
                return;
            }

                HCToast.ShowToast("绑定成功");
                return;
        }

        HCToast.ShowToast($"绑定失败 {BindInfo.bindMsg}");
        };
}

public void ButtonEvent_BindAccount()
{

    HCSDKManager.Instance.BindAccount(HCLoginType.LOGIN_BY_GOOGLE, _bindAccountCallback);
}
```

### 8、强制绑定
当用户使用已绑定过的社交账号进行绑定操作时，游戏可自行弹出界面列出2个账号及对应游戏进度，供玩家选择该社交账号与哪个账号进行绑定。玩家选择后，调用强制绑定接口即可。
```c
void Start()
{   
    _bindAccountCallback = (BindInfo) =>
    {
    Debug.Log($"绑定回调 {BindInfo.bindStatus} type:{BindInfo.userInfo.loginType} msg:{BindInfo.bindMsg} userId:{BindInfo.userInfo.userID} token:{BindInfo.userInfo.token} userIdList:{BindInfo.userIDs}");
    if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SELECT)
    {
        HCDebugger.LogDebug("绑定回调 - 选择界面");
        return;
    }

    if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SUCC)
    {
        HCDebugger.LogDebug("绑定回调 - 绑定成功");
        if (!BindInfo.userInfo.userID.Equals(_userId))
        {
            HCDebugger.LogDebug($"绑定回调 - 绑定成功 - 重新登陆 userId:{BindInfo.userInfo.userID} _userId:{_userId}");
                    
            return;
        }

            HCToast.ShowToast("绑定成功");
            return;
    }

    HCToast.ShowToast($"绑定失败 {BindInfo.bindMsg}");
    };
}

public void ButtonEvent_ForceBindAccount()
{
    HCSDKManager.Instance.ForceBindAccount("", _bindAccountCallback);
}
```

### 9、自动登录
SDK根据上次登录的类型进行自动登录。 可以通过IsCanAutoLogin接口来判断自动登录接口是否可用。如果在不可使用自动登录接口的情况下调用自动登录接口，会返回登录失败
```c
HCSDKManager.Instance.AutoLogin();
```

### 10、返回当前账号类型
登录成功后获取当前账号的类型，游戏侧可以根据此接口返回结果来判断是否显示绑定相关的界面.
```c
HCLoginType accountType = HCSDKManager.Instance.GetAccountType();
```

### 11、返回当前是否可以自动登录
游戏可以根据此接口返回的结果来判断是否可以直接调用`AutoLogin`接口进行自动静默登录. 如果不可以，需要显示登录界面，然后根据玩家选择登录类型调用`Login`接口。
```c
bool isCanAutoLogin = HCAccountManager.Instance.IsCanAutoLogin();
```

### 12、Q&A
** 1、 一个Google账号可对应多个游戏账号吗？ **       
不能。一个Google账号只能对应一个游戏账号。        
    
** 2、先调用游客登录，再调用Google登录，此时游客账号和Google账号会发生绑定吗？    **    
不会。先调用游客登录，再调用Google登录，会返回新的UserID作为新的账号进行游戏。只有调用绑定接口时，才会发生游客账号和Google账号的绑定，返回同一个UserID，即游客账号的UserID，使用同一个游戏进程。        
但游客UserID和设备ID有关，此时如果设备ID变了，那前面的没进行绑定的游客账号可能就丢掉了。        
    
** 3、先用游客登录，返回UserID1，有游戏进度后，选择Google账号绑定，我的UserID会变吗？**        
不会变。绑定后UserID仍为UserID1，只是SDK内部做了一个绑定。相当于游客账号发生绑定行为后，返回的还是原来的游客账号ID。        
    
** 4、进游戏选择Google登录，有游戏进度后，重新进入游戏选游客登录，有游戏进度后，点Google账号绑定。此时会发生什么？**        
绑定已有进度的Google账号时，SDK会返回给游戏2个UserID，即当前游客账号UserID和已有进度的Google账号对应的UserID，游戏可自行制作界面，给玩家选择Google账号要绑定哪个游戏进度对应的UserID。然后通过强制绑定接口把玩家选定的UserID传给SDK进行和该Google账号的强制绑定。   
          
** 5、对于一进游戏默认为游客登录的游戏，我先用A设备玩有进度并绑定了我仅有的Google账号，然后我又用B设备玩有进度后也要绑定我唯一的Google账号，这时候会发生什么？  **      
这种情况同4，都是绑定已有的Google账号。             
    
** 6、新生成的UserID会重复吗？   **     
不会。新生成的UserID都是唯一的，不会重复。        

** 7、Unity Editor下可以进行账号系统验证吗？   **   
可以。Unity Editor可以进行账号系统的相关调试。
