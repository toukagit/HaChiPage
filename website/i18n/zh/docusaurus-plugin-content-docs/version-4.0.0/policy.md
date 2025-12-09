---
title: "政策合规"
sidebar_label: "政策合规"
description: ""
sidebar_position: 3
---

# 政策合规

## 用户协议
```c
/// <summary>
/// 显示用户协议并询问是否同意
/// </summary>
/// <param name="hasPurchase">是否包含内购项目，true：包含内购项目；false：不含内购项目</param>
/// <param name="_closeCallbackallback">用户协议页面关闭回调</param>

HachiMgr.Instance.ShowUserAgreementWithPurchase(true, () =>
{
    HMDebugger.LogDebug("用户协议窗口关闭");
});
```


SDK内置弹框，调用接口后展示如下图：
<center>

<img src="../img/HCSDK/image74.jpg" width="30%" height="30%"/> 
</center>


## 信息弹窗

```c
HachiMgr.Instance.PopPrivacyPolicy();
```

SDK内置弹框，调用接口后展示如下图：
<center>

<img src="../img/HCSDK/image75.jpg" width="30%" height="30%"/> 
</center>

## 适龄提示

```c
/// <summary>
/// 点击年龄按钮后SDK展示适龄提示后续页面
/// </summary>
HachiMgr.Instance.ShowAgeView();

/// <summary>
/// 隐藏SDK展示的适龄提示后续页面
/// </summary>
HachiMgr.Instance.HideAgeView();
```

开发者设置年龄位置后，用户点击年龄按钮时展示SDK页面，如下图：
<center>

<img src="../img/HCSDK/image76.jpg" width="30%" height="30%"/> 
</center>
年龄按钮随游戏loading页面关闭后隐藏。

## 实名认证
需先登录后，根据登录回调中的certificationType判断是否需要展示实名认证弹框，如该账号已经认证过则无需展示实名认证弹框。

```c
/// <summary>
/// 实名认证接口
/// </summary>
/// <param name="_closeCallback">关闭回调</param>

HachiMgr.Instance.ShowUserVerification(() =>
{
    // 实名认证弹框关闭
});
```
实名认证弹窗如下图：
<center>

<img src="../img/HCSDK/image77.jpg" width="30%" height="30%"/> 
</center>

## 防沉迷
```c
/// <summary>
/// 防沉迷接口
/// </summary>
/// <param name="_callback">is_allowed 是否允许进入游戏,0:不能进入，1:允许进入；left_time 剩余有效的时间秒数；msg错误信息</param>
/// <param name="_callback">is_allowed=1,left_time=0 代表成年人</param>

HachiMgr.Instance.CheckAntiAddictionPlayable((allow, time, msg) =>
{
    HMDebugger.LogDebug("CheckAntiAddictionPlayable allow:"+allow+" time:"+time+" msg:"+msg);
});
```

** 示例：** 
``` c
/// <summary>
/// 实名认证类型
/// </summary>
public enum CertificationType
{
    /// <summary>
    /// 默认值，未开启认证
    /// </summary>
    None = 0,

    /// <summary>
    /// 未实名，需要客户端弹窗实名认证
    /// </summary>
    NotCertified_Client = 1,

    /// <summary>
    /// 已实名，可直接进入游戏
    /// </summary>
    Certified = 2,

    /// <summary>
    /// 未实名，走客户端阿里认证
    /// </summary>
    NotCertified_Ali = 3
}

HachiMgr.Instance.Login(new HMLoginRequest(HMLoginType.LOGIN_BY_GUESTER), (LoginInfo) =>
{
    // 登录成功
    if (LoginInfo.loginStatus == HMLoginStatus.LOGIN_STATUS_SUCC)
    {
        if(LoginInfo.userInfo.certificationType != CertificationType.Certified)
        {
            // 未认证过展示实名认证
            HachiMgr.Instance.ShowUserVerification(() =>
            {
                // 实名认证关闭，请求防沉迷，展示倒计时弹框
                HachiMgr.Instance.CheckAntiAddictionPlayable((allow, time, msg) =>
                {
                    // allow：是否允许进入，time：剩余有效的时间秒数，msg错误信息
                    // is_allowed=1,left_time=0 代表成年人
                    HMDebugger.LogDebug("CheckAntiAddictionPlayable allow:"+allow+" time:"+time+" msg:"+msg);
                });
            });
        }
        else
        {
            HachiMgr.Instance.CheckAntiAddictionPlayable((allow, time, msg) =>
            {
                HMDebugger.LogDebug("CheckAntiAddictionPlayable allow:"+allow+" time:"+time+" msg:"+msg);
            });
        }
    }
    else
    {
        // 登录失败
        
    }
});

```
