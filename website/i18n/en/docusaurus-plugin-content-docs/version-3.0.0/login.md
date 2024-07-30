---
title: "Account system"
sidebar_label: "Account system"
description: ""
sidebar_position: 3
---

# Account system
:::tip 

- Before starting the integration of the account system, please confirm the timing of the account system and select the login method to be supported. We provide visitor login, email login and third-party login methods.

- In addition to account login, we also support account deletion, login method query, account logout, account binding, mandatory binding, automatic login, return to the current account type, return to the current can automatically log in.    

- HachiSDK provides login interface and [Login account information interface](#2log-in-to-the-account-information-interface). Developers can design and make account information interface according to game UI style and style or use the login account information interface provided by SDK.

- When you log in with Google Games, you need to add your Google account to your Google Background Test account.

:::


## Common interface

### 1、Account login
Login type
```c
public enum HCLoginType
{
    // GUESTER login
    LOGIN_BY_GUESTER = 0,

    // Email account login (not supported)
    LOGIN_BY_EMAIL = 1,

    // Google login
    LOGIN_BY_GOOGLE = 2,

    // Facebook login
    LOGIN_BY_FACEBOOK = 3,

    // Apple login
    LOGIN_BY_Apple = 4,

    // Google Play Games Services login
    LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES = 9,

    // GameCenter login
    LOGIN_BY_GAMECENTER = 10,

    // Google Play Games Services auto login
    LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES_AUTO = 101,

    // GameCenter auto login
    LOGIN_BY_GAMECENTER_AUTO = 102,
}
```

Login status
```c
 public enum HCLoginStatus
{
    // Login successful
    LOGIN_STATUS_SUCC = 0,

    // The login was cancelled by the user
    LOGIN_STATUS_CANCEL = 1,

    // Automatic login has no cached data
    LOGIN_STATUS_NO_CACHE = 2,

    // Login failure
    LOGIN_STATUS_FAILED = -1
}
```

Login
```c
public void ButtonEvent_Login()
{
    HCSDKManager.Instance.Login(HCLoginType.LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES_AUTO, _loginAction);
}

void Start()
{
    _loginAction = (LoginInfo) =>
    {
        Debug.Log($"Landing callback {LoginInfo.loginStatus} type:{LoginInfo.userInfo.loginType} msg:{LoginInfo.loginMsg} userId:{LoginInfo.userInfo.userID} token:{LoginInfo.userInfo.token}");
        if (LoginInfo.loginStatus == HCLoginStatus.LOGIN_STATUS_SUCC)
        {
            // Successful landing
            _userId = LoginInfo.userInfo.userID;
            _userType = LoginInfo.userInfo.loginType;
            _token = LoginInfo.userInfo.token;
        }
        else
        {
            // Login failure
            _userId = "";
            _userType = HCLoginType.LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES_AUTO;
            _token = "";
        }
};
```

The login types LOGIN_BY_GOOGLE_PLAY_GAMES_SERVICES_AUTO, LOGIN_BY_GAMECENTER_AUTO, and others operate similarly to social login types, featuring both login and bind functionalities. However, in the event of initial login failure, the SDK internally switches to a guest login type (unlike other social logins that simply return a failure). This triggers the guest account logic. Subsequent calls to this type will prioritize guest login and attempt to bind the social type. <font color="#ff0000">Developers need not concern themselves with the internal processing logic; they should handle actions based on the returned login type (e.g., displaying a bind button for guest types).</font>


### 2、Log in to the account information interface

note:<br/>
SDK Adds the pop-up window of account information, and processes the interface of account binding/account deletion and related logic through the SDK.<br/>
The developer needs to act on the information in the close callback (_closeCallback) : <br/>
- If the user switches the account in the pop-up interface of account information, that is, the first parameter is true, the game side needs to process the game progress archive according to the userID (the third parameter) returned by the SDK after the switch. <br/>
- If the user deletes the account in the pop-up interface of account information, that is, if the second parameter is true, the userID returned by the third parameter is empty, the game side needs to return to the main interface or restart the game, and call the login method again to log in. <br/>
- If the two parameters are false at the same time, the account has not changed and no processing is required on the game side. <br/>

The first and second arguments cannot be true at the same time. <br/>

```c
/// <summary>
/// 
/// </summary>
/// <param name="_loginType">The login method used by the game is confirmed by the requirements document</param>
/// <param name="_closeCallback">The first parameter is whether the current account switchover is performed. For example, true is returned when the pop-up is closed after the account switchover succeeds. Otherwise, false is returned</param>
/// <param name="_closeCallback">The second parameter is: whether the current account is deleted. For example, true is returned when the pop-up is closed after the account is successfully deleted. Otherwise, false is returned</param>
/// <param name="_closeCallback">The third parameter is: the current userId</param>
public void OpenAccountMenu(HCLoginType _loginType, Action<bool,bool,string> _closeCallback);

e.g.
public void Button_OpenAccountMenu()
{
    // When the interface is closed, a callback is triggered. You can determine whether the account is switched or deleted based on the parameters in the callback
    HCSDKManager.Instance.OpenAccountMenu(HCLoginType.LOGIN_BY_Apple, (isSwitchAccount, isDeleteAccount, userId) =>
    {
        HCDebugger.LogDebug("account menu isSwitchAccount:" + isSwitchAccount + "  isDeleteaAccount:" + isDeleteAccount + " userId:" + userId + "loginType:" + HCLoginType.LOGIN_BY_Apple.ToString());
    });
}
```
Instructions:
The pop-up window of account information is added to the SDK. There are two states of the pop-up window of account information, one is for tourists to log in with an unbound third-party account (Figure 1), and the other is for a bound third-party account:

<center>

<img src="../img/HCSDK/image48.png" width="30%" height="30%"/> <img src="../img/HCSDK/image49.png" width="30%" height="30%"/>

</center>

1. Custom login is not bound to an account
- Click User ID to copy the user ID to the clipboard;
- Click the account binding button and call the login popup of the corresponding login mode. If the login mode is Google Game login, call the Google Game login popup window (for the time being, only one login mode is supported for a game). After the User successfully logs in, the User ID will be bound to the corresponding account;
- If the binding behavior of the three accounts has occurred, the userids of the bound accounts and the userids of the current process will be displayed for the player to select. After the player selects one of the userids to bind, the progress of the userids will be lost;

<center>

<img src="../img/HCSDK/image50.png" width="30%" height="30%"/>


</center>

- Click Delete account button, check the box twice to confirm whether to delete, click OK button to delete the current User ID and binding relationship;

<center>

<img src="../img/HCSDK/image51.png" width="30%" height="30%"/>

</center>



2. Bound account

- Click User ID to copy the user ID to the clipboard;
- Click the switch account button and call the corresponding login mode of the game access pop-up window. If the game access is Google Game login mode, the Google game login pop-up window will pop up (for the time being, only one login mode is supported for a game), and the game archive will be switched together after the user successfully switches the account
- Click Delete account button, check the box twice to confirm whether to delete, click OK button to delete the current User ID and binding relationship;



## Other interface

### 1、When the account system appears
After entering the game, the login interface is displayed directly. Players must fill in/check the information to complete the login and enter the game. (Only enter the display game login screen for the first time, and then use the selected method to log in directly.)
![](/img/HCSDK/login01.png)

Players can enter the game experience immediately by silent login, and bind the account at the appropriate game location. (Non-tourist accounts enter the game, do not show the binding button.)

![](/img/HCSDK/login02.png)

### 2、Instructions
1. Separate calls to visitor login, Google login, Facebook login, and Apple login return different userids. (The case of account binding is special.)
2. Note that login is to call the login interface, and binding the tourist account to the third-party account after successful login is the interface to call the binding account. Only when the account binding interface is called, the tourist account and the third-party account will be bound in the SDK.
3. After the login of non-tourist account type is successful, the binding function is not provided (that is, the binding button is not displayed). The login type returned after the tourist is successfully bound is the type of the bound three-party account, and the returned UserID is the same as the UserID returned when the tourist logs in.



### 3、Account logout
The account logout interface can be invoked when the game switches the account to do the logout operation. The SDK will call back the game after completing the account exit. No requirement scenario can not be called.

```c
HCSDKManager.Instance.Logout();
```

### 4、Login Mode Query interface
```c
List<HCLoginType> list = HCSDKManager.Instance.AvailableLoginChannelList();
```

### 5、Account deletion
In order to enhance the transparency of the Android ecosystem, Google has expanded the control of users over their data. Games that require support for account login must provide an entry for users to delete their accounts. Must be called in place with the interface.

```c
HCSDKManager.Instance.DeleteAccount();
```

### 6、Account binding
:::info Instructions
1. The account binding function is to bind the tourist account to the tripartite account service when the visitor logs in the game.
2. Only the tourist account can be bound to the third party account, and the tourist account cannot be bound again after being bound once. If the binding interface is called again, the status code of the bound account will be returned;
3. The binding button can no longer be displayed after binding. The bind button is displayed when the visitor login type is based on loginType in the callback.
4. The UserID returned after the tourist account is bound to the third party account is still the UserID of the tourist account, but the two are bound in the SDK.
5. As long as the tourist account has not been bound to a social account, it has the right to be bound to a social account; If the social media account has been linked to another tourist account, it has the right to force binding. This involves forcibly binding interfaces.
6. When the user uses the bound social account to bind, the game can pop up the interface to list two accounts and the corresponding game progress, so that the player can choose which social account to bind. After the player selects, the mandatory binding interface can be called.
7. <font color="#ff0000"> After the binding is successful, the game needs to determine whether the UserID returned after the binding is consistent with the current login UserID. If not, the progress needs to be switched to the corresponding game progress of the UserID returned after the binding is successful (switching account). </font>

:::

```c
Binding type
public enum HCBindAccountStatus
    {
        // Binding failure
        BIND_CODE_FAILED = -1,
        
        // Binding successful
        BIND_CODE_SUCC = 0,
        
        // unbind
        BIND_CODE_CANCEL = 1,
        
        // An account has been bound and needs to be selected
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
        
        Debug.Log($"Bound callback {BindInfo.bindStatus} type:{BindInfo.userInfo.loginType} msg:{BindInfo.bindMsg} userId:{BindInfo.userInfo.userID} token:{BindInfo.userInfo.token} userIdList:{BindInfo.userIDs}");
        if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SELECT)
        {
            HCDebugger.LogDebug("Bind callback - Select screen");
            return;
        }

        if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SUCC)
        {
            HCDebugger.LogDebug("Bind callback - Bind successfully");
            if (!BindInfo.userInfo.userID.Equals(_userId))
            {
                HCDebugger.LogDebug($"Bind callback - Bind successfully - Log in again userId:{BindInfo.userInfo.userID} _userId:{_userId}");
                        
                return;
            }

                HCToast.ShowToast("Binding successful");
                return;
        }

        HCToast.ShowToast($"Binding failure {BindInfo.bindMsg}");
    };
}

public void ButtonEvent_BindAccount()
{

    HCSDKManager.Instance.BindAccount(HCLoginType.LOGIN_BY_GOOGLE, _bindAccountCallback);
}
```

### 7、Forced binding
When the user uses the social account that has been bound to bind the operation, the game can pop up the interface to list the two accounts and the corresponding game progress, for the player to choose which social account to bind. After the player selects, the mandatory binding interface can be called.
```c
void Start()
{   
    _bindAccountCallback = (BindInfo) =>
    {
    Debug.Log($"Bound callback {BindInfo.bindStatus} type:{BindInfo.userInfo.loginType} msg:{BindInfo.bindMsg} userId:{BindInfo.userInfo.userID} token:{BindInfo.userInfo.token} userIdList:{BindInfo.userIDs}");
    if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SELECT)
    {
        HCDebugger.LogDebug("Bind callback - Select screen");
        return;
    }

    if (BindInfo.bindStatus == HCBindAccountStatus.BIND_CODE_SUCC)
    {
        HCDebugger.LogDebug("Bind callback - Bind successfully");
        if (!BindInfo.userInfo.userID.Equals(_userId))
        {
            HCDebugger.LogDebug($"Bind callback - Bind successfully - Log in again userId:{BindInfo.userInfo.userID} _userId:{_userId}");
                    
            return;
        }

            HCToast.ShowToast("Binding successful");
            return;
    }

    HCToast.ShowToast($"Binding failure {BindInfo.bindMsg}");
    };
}

public void ButtonEvent_ForceBindAccount()
{
    HCSDKManager.Instance.ForceBindAccount("", _bindAccountCallback);
}
```

### 8、Automatic login
The SDK automatically logs in based on the type of the last login. You can use the IsCanAutoLogin interface to determine whether the automatic login interface is available. If the automatic login interface is invoked when it is not available, a login failure message is displayed.
```c
HCSDKManager.Instance.AutoLogin();
```

### 9、Returns the current account type
After successful login, obtain the type of the current account. The game side can determine whether to display the binding interface according to the result returned by this interface.
```c
HCLoginType accountType = HCSDKManager.Instance.GetAccountType();
```

### 10、Returns whether automatic login is currently available
Based on the result returned by this interface, the game can determine whether it can directly invoke the 'AutoLogin' interface for automatic silent login. If not, you need to display the Login interface, and then call the 'login' interface according to the login type selected by the player.
```c
bool isCanAutoLogin = HCAccountManager.Instance.IsCanAutoLogin();
```

## Q&A

** 1、 Can one Google account correspond to multiple game accounts? **       
No. One Google account can only correspond to one game account.  
    
** 2、First call the visitor login, and then call Google login, at this time the tourist account and Google account will be bound？    **    
No. Calling visitor login first, and then calling Google login, will return a new UserID as a new account to play the game. Only when the binding interface is called, the binding of the visitor account and Google account will occur, returning the same UserID, that is, the UserID of the visitor account, using the same game process.
However, the tourist UserID is related to the device ID, and if the device ID changes, the previous unbound tourist account may be lost.      
    
** 3、Log in as a tourist first, return UserID1, after the game progress, select Google account binding, will my UserID change？**        
It won't change. After binding, the UserID is still UserID1, but a binding is made inside the SDK. Equivalent to the binding behavior of the tourist account, the return is still the original tourist account ID.    
    
** 4、Enter the game select Google login, after the game progress, re-enter the game select visitors login, after the game progress, click Google account binding. What happens at this point？**        
When the Google account with existing progress is bound, the SDK will return two userids to the game, that is, the UserID corresponding to the current tourist account and the Google account with existing progress. The game can make its own interface to select the UserID corresponding to the Google account to be bound. Then the UserID selected by the player is passed to the SDK through the forced binding interface to forcibly bind the Google account.   
          
** 5、For A game that defaults to visitor login, I first use device A to play progress and bind my only Google account, and then I use device B to play progress and bind my only Google account, what happens at this time? **      
This case is the same as 4, are bound to the existing Google account.
    
** 6、Will the newly generated userids be repeated?   **     
No. The newly generated userids are unique and will not be repeated.  

** 7、Can I verify the account system in Unity Editor?  **   
Agreed. The Unity Editor can debug the account system.


```




