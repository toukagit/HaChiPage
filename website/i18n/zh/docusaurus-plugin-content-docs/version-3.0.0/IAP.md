---
title: "内购"
sidebar_label: "内购"
description: ""
sidebar_position: 3
---

# 内购 
:::danger
 - **需要添加 USE_IAP 宏定义**   
 - **[Unity In App Purchasing 插件版本需 4.12.0 或更高](https://docs.unity3d.com/Packages/com.unity.purchasing@4.9/manual/StoresSupported.html) (UnityEditor 2020.3+)**
 - ** 必须实现 [ 【8、奖励下发上报(必接)】 ](#8奖励下发上报必接) **
 
 - ** SDK会在购买成功和购买失败后自动检查本地是否包含未验证订单，建议开发者进入主界面等时机主动请求补单。[【9、补单】](#9补单) ** 
 - ** 测试内购时，需需要先把谷歌账号添加到Google后台测试账号中。 **
 - ** 需用手机端点击测试链接加入测试账号，不能使用电脑端加入测试账号；如果电脑端已加入则需退出电脑端登录。** 
:::
## 一、内购接入方法
### 1、导入IAP插件
导入Unity In App Purchasing插件。
Unity菜单栏 -> Window -> Package Manager -> In App Purchasing -> Install。<br/><br/>
** 如果In App Purchasing插件看不到4.12.0版本时，请按照以下步骤添加：按名称添加包 -> 输入：com.unity.purchasing**

<center>

<img src="../img/HCSDK/image37.png"/>

</center>


### 2、添加宏定义
```c
USE_IAP 
```

### 3、添加内购商品
:::tip
  支持两种添加方式:       
  **a. 通过 AddProductsStatic 接口添加商品(<font color="ff0000">在初始化SDK接口前调用</font>) **<br/>
  **b. 通过 AddProducts 接口添加商品**<br/>
  
  <font color="ff0000"> 注意：添加商品类型必须和后台申请类型一致，否则可能请求不到对应商品信息。</font> <br/>
 
    ProductType.NonConsumable  只能购买一次。适合一次性购买的商品，如额外的关卡<br/>
    ProductType.Consumable     可以反复购买。适合虚拟货币等可消耗商品<br/>
    ProductType.Subscription   可以反复购买和恢复。耐用品，但有效期有限（订阅）<br/>

:::

a. 通过 **HCSDKManager.Instance.AddProductsStatic** 接口添加商品ID 
```c
Dictionary<string, ProductType> ProductDic = new Dictionary<string, ProductType>()
{
    { "com.tkkk.unitysdk.demo.1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a12",ProductType.Consumable}
};

HCSDKManager.Instance.AddProductsStatic(ProductDic);
```

<font color="ff0000">注：此方法需要在初始化SDK前调用，即初始化SDK前设置好商品信息。</font>

<br/><br/>


b. 通过 **HCSDKManager.Instance.AddProducts** 接口添加商品ID 
```c
Dictionary<string, ProductType> ProductDic = new Dictionary<string, ProductType>()
{
    { "com.tkkk.unitysdk.demo.1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a12",ProductType.Consumable}
};

HCSDKManager.Instance.AddProducts(ProductDic);
```

### 4、初始化内购回调
:::danger
 - **初始化内购回调必须设置在SDK初始化之前**
:::
```c
HCSDKManager.Instance.SetOnPurchaseInitLinstener((result,errorMsg)=>
{
    if (result)
    {
        // Iap初始化成功
        HCDebugger.LogDebug("Iap init success");
    }
    else
    {
        // Iap初始化失败
        HCDebugger.LogDebug("Iap init fail, errorMsg:"+errorMsg);
    }
});
```

### 5、购买监听回调
:::danger
 - **支付回调必须设置在SDK初始化之前**
 - **支付回调为异步回调，回调回来时要确保游戏奖励下发正常。建议游戏侧可在支付过程中增加遮罩屏蔽用户操作**   
:::

```c
void Start()
{
    // 设置购买监听回调
    HCSDKManager.Instance.SetOnPurchaseDone(PurchaseCallback);
}

/// 苹果/谷歌三方支付订单号
/// 游戏侧自定义商品名称
/// 支付的商品ID
/// 是否成功支付
/// 游戏扩展字段
/// 是否为恢复购买订单
/// 是否为恢复购买触发，主要用于弹框提示（仅iOS）
/// 支付状态
private void PurchaseCallback(string orderID, string productName, string productID, bool purchaseResult, string gameExtra,bool orderAlreadyExists, bool isRestore, PurchasingCode code)
{
    if (purchaseResult)
    {
        //购买成功，下发奖励
    }
    else
    {
        //恢复购买商品
        if(orderAlreadyExists){
        
            //恢复购买成功，下发非消耗品，如：去广告
        
        }else{
        
           // 购买失败
        
        }
    }
}
```
**说明：** <br/>
1、purchaseResult 或 orderAlreadyExists 为true时，正常下发商品。需游戏侧根据需求自行处理，对于非消耗品等，不可重复下发的奖励的情况。（如去广告礼包包含去广告+500钻石，卸载重装恢复购买，只需重新奖励去广告，而500钻石之前已经下发过无需再次下发，具体逻辑以需求文档为准）<br/>
2、purchaseResult 字段和 orderAlreadyExists 字段不会同时为true。<br/>
3、回调中支付状态说明如下：
```c

public enum PurchasingCode
{
    PurchasingUnavailable,          // 无法使用系统购买功能
    ExistingPurchasePending,        // 请求新购买时正在进行前一项购买
    ProductUnavailable,             // 无法在商店购买商品
    SignatureInvalid,               // 购买收据的签名验证失败
    UserCancelled,                  // 用户选择取消而不是继续购买
    PaymentDeclined,                // 付款出现问题
    DuplicateTransaction,           // 当交易已经成功完成时出现的重复交易错误
    Unknown,                        // 未识别的购买问题的通用原因
    ServerRequestFailed,            // 客户端购买成功请求服务端失败
    ServerAuthenticationFailed,     // 客户端购买成功服务端验证失败
    PurchasingSuccess               // 客户端购买成功服务端验证成功
}
```


### 6、购买商品接口
```c 
public void BuyProduct()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
    string productName = "a1";
    string gameExtra = "a1GameExtraParam";
    HCSDKManager.Instance.BuyProductByID(productID,productName,gameExtra);
}
```

### 7、恢复购买（仅iOS）
```c
HCSDKManager.Instance.RestorePurchases();
```
**说明：**<br/>
1、对于iOS产品，苹果要求如果内购条目中包含非消耗类型商品，必须要有恢复购买功能。<br/>
2、恢复购买功能请根据需求文档添加。一般逻辑为，设置界面添加恢复购买按钮，卸载重装后，点击恢复购买按钮，把已购买的非消耗品恢复。<br/>
3、有可恢复的商品时，最终会调用到购买成功回调（第4点），游戏需保证能正常下发奖励。<br/>
4、例：<br/>
某个商品为非消耗型条目，奖励为：去广告+100金币。那恢复购买时，只恢复去广告，不恢复100金币。<br/>
每次调用恢复购买方法，都会给购买成功回调，需游戏自己加逻辑判断不重复下发或将恢复购买按钮隐藏。<br/>

### 8、奖励下发上报(必接)
:::danger
 游戏必须实现此接口，完成内购事件闭环。<br/>
 游戏需要再购买成功或恢复购买成功即 purchaseResult 或 orderAlreadyExists 其中一个为true时调用该接口。
:::

```c
/// <summary>
/// IAP 游戏下发奖励后上报
/// </summary>
/// <param name="productName">商品名称</param>
/// <param name="productID">商品SKU ID</param>
/// <param name="orderID">订单ID</param>
/// <param name="gameExtra01">游戏拓展字段-购买商品数量</param>
/// <param name="gameExtra02">游戏拓展字段</param>
public void LogCheckingOrder(string productName, string productID, string orderID, string gameExtra01, string gameExtra02);

例：
private void PurchaseCallback(string orderID, string productName, string productID, bool purchaseResult,
        string gameExtra, bool orderAlreadyExists)
{
    if (purchaseResult || orderAlreadyExists)
    {
        mPurchaseBtn.text = "购买成功";
        HCSDKManager.Instance.LogCheckingOrder(productName,productID,orderID,"gameExtra01","gameExtra02");
    }
    else
    {
        mPurchaseBtn.text = "购买失败";
    }

    HCDebugger.LogDebug("PurchaseCallback orderID:" + orderID + " productName:" + productName + " productID" +
                        productID + " purResult" + purchaseResult + " gameExtra:" + gameExtra +
                        " orderAlreadyExists:" + orderAlreadyExists);
}
```

### 9、补单
```c
HCSDKManager.Instance.ReadFailOrderId();
```
SDK会在购买成功和购买失败后主动检查本地是否包含未验证订单，未验证订单校验成功后将触发 [ 【4、购买监听回调】 ](#4购买监听回调)，开发者也可根据实际情况主动调用补单接口进行补单逻辑。

### 10、获取本地化价格字符串接口
会返回带货币符号的价格字符串，如：'$1.99' '￥6.99'。
```c
public void GetPriceByID()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
   
    // 会返回带货币符号的价格字符串，如：'$1.99' '￥6.99'
    string price = HCSDKManager.Instance.GetPriceByID(productID);
}
```

### 11、查询连续订阅产品信息 (v3.1.4 新增)
SDK支持以下两种方式查询已购买的连续订阅产品的信息：
#### 11.1 注册回调
初始化SDK前注册回调，当IAP插件初始化成功后SDK会检查当前是否存在连续订阅型产品信息。<br/>
开发者可在在订单过期时收回续订权益，即 validity = false 时或HCSubscribeData中Is_expired = 1时回收权益。（具体表现可根据需求文档而定）

```c
public void SetOnCheckSubscribeValidity(Action<string, bool, HCSubscribeData> onCheckSubscribeValidityAction);

例：
HCSDKManager.Instance.SetOnCheckSubscribeValidity((productId,validity,data)=>
{
    // productId 商品ID
    // validity 是否过期 fales：过期，true：未过期
    // data 订阅型商品信息
    HCDebugger.LogDebug("SubscribeData ===> "+JsonConvert.SerializeObject(data));
});
```
#### 11.2 主动查询
开发者可在合适的时机主动调用查询接口查询订阅型商品信息
```c
public void CheckSubsribeDataByProductId(string productId,Action<HCSubscribeData> onCheckSubsribeByProductIdAction);

例：
HCSDKManager.Instance.CheckSubsribeDataByProductId("productId", (data) =>
{
    // 商品ID
    // data 订阅型商品信息
    HCDebugger.LogDebug("SubscribeData ===> "+JsonConvert.SerializeObject(data));
});

```


连续订阅商品信息** HCSubscribeData **说明如下：

```c

        public int Illegal_order;       // 0:代表合法订单，1:代表非法订单
        public string Illegal_msg;      // 非法订单信息
        public string Environment;      // production & sandbox
        public string Purchase_time;    // 订阅时间，单位毫秒
        public int Is_subscribed;       // 是否订阅过 0：未订阅过，1：订阅过
        public int Is_expired;          // 是否过期 0未过期，1：已过期
        public int Is_cancelled;        // 0：未取消，1：已取消
        public int Is_free_trial;       // 0：不是免费试用，1：是免费试用
        public int Is_auto_renewing;    // 是否自动续订 0：非自动，1：自动 
        public string Remaining_time;   // 订阅到期剩余时间，单位毫秒
        public string Expiry_time;      // 过期时间，单位毫秒
        public string Latest_order_id;  // 当前订阅的最新订单号
        public string Product_id;       // 产品ID
        
```


### 12、获取所有商品信息（可选）
返回AppStore/Google Play 上所有配置的商品。
```c
void Start()
{
    HCSDKManager.Instance.OnGetProductsInfo(OnProductInfoCallback);
}

 public void OnProductInfoCallback(Product[] products)
 {
    /// ex:
    ///     products[0].metadata.localizedTitle
    ///     products[0].metadata.localizedPriceString
    ///     products[0].metadata.localizedDescription
    ///     products[0].metadata.isoCurrencyCode
 } 
```

### 13、根据商品ID获取商品信息（可选）
```c
string productID = "com.tkkk.unitysdk.demo.a1";

Product prodyct = HCSDKManager.Instance.GetProductInfoByID(productID);
```

### 14、内购异常
如遇到支付失败，请确认以下问题：
- 支付回调必须设置在SDK初始化之前
- 所有商品类别需和后台配置一致，消耗品、非消耗品还是订阅产品
- GooglePlay中国地区账号无法调起支付，需切换地区或使用其他地区账号
- 网络原因，尝试切换不同vpn节点

## 二、服务端对接（可选）
SDK支付成功后，游戏根据回调获取支付结果。 有服务器的游戏优先接入SDK服务器支付回调接口，支付成功后，由SDK服务器通知游戏服务器进行商品下发。单机游戏确保收到客户端支付成功回调后发放商品。         

### 第三方游戏回调前期准备
1、找对接方获取游戏端授权加密sercret。       
2、提供游戏端回调地址给对接方进行回调地址配置。

目前后台只支持配置一个支付回调地址，如需回调到多台服务器，需研发侧服务端自行进行接口转发。例如同步转发到线上服务器和测试服务器。
### 游戏端回调地址接口说明
** 1、请求方式: post        **      
** 2、header授权:   **   ``` Authorization: secretkey  ```               
** 3、Body json        **      
<table>
  <tr>
    <td>参数</td>
    <td>类型</td>
    <td>是否必填</td>
    <td>描述</td>
    <td>示例值</td>
  </tr>
  <tr>
    <td>env</td>
    <td>String</td>
    <td>是</td>
    <td>环境变量（qa:测试环境; prod:线上环境）</td>
    <td>prod</td>
  </tr>
    <tr>
    <td>platform</td>
    <td>String</td>
    <td>是</td>
    <td>平台（android/ios）</td>
    <td>android</td>
  </tr>
    <tr>
    <td>pkg</td>
    <td>String</td>
    <td>是</td>
    <td>游戏包名</td>
    <td>com.test.demo</td>
  </tr>
    <tr>
    <td>user_id</td>
    <td>String</td>
    <td>是</td>
    <td>用户ID</td>
    <td>0cc852594cb2dfd0381af38f687b44906</td>
  </tr>
  <tr>
    <td>product_id</td>
    <td>String</td>
    <td>是</td>
    <td>商品ID</td>
    <td>com.tkkk.unitysdk.demo.a1</td>
  </tr>
  <tr>
    <td>order_id</td>
    <td>String</td>
    <td>是</td>
    <td>订单ID</td>
    <td>GPA.3340-7674-3284-90321</td>
  </tr>
  <tr>
    <td>price</td>
    <td>String</td>
    <td>是</td>
    <td>价格</td>
    <td>1.99</td>
  </tr>
  <tr>
    <td>currency</td>
    <td>String</td>
    <td>是</td>
    <td>货币单位</td>
    <td>USD</td>
  </tr>
  <tr>
    <td>game_extra_param</td>
    <td>String</td>
    <td>否</td>
    <td>游戏扩展字段</td>
    <td>game_extra_param_value</td>
  </tr>
  <tr>
    <td>ts</td>
    <td>String</td>
    <td>是</td>
    <td>时间戳</td>
    <td>1692346624</td>
  </tr>
  <tr>
    <td>sign</td>
    <td>String</td>
    <td>是</td>
    <td>加密值</td>
    <td>33dasfdewffggg</td>
  </tr>
</table>

```c
body json样例（secretkey: 64f1b1fb8efadc41dcd29d5c）
{
    "env": "qa",
    "platform": "android",
    "pkg": "com.test.demo",
    "user_id": "0cc852594cb2dfd0381af38f687b44906",
    "product_id": "com.tkkk.unitysdk.demo.a1",
    "order_id": "GPA.3340-7674-3284-90321",
    "price": "1.99",
    "currency": "USD",
    "game_extra_param":"game_extra_param_value"
    "ts": "1692346624",
    "sign": "c9e91f2b7d28eec1130df9ddea5697e8"
}

```

** 4、加密方式：**  
sign值为：按照返回参数顺序-md5(参数对应值1+参数对应值2+参数对应值n+secretkey), +代表连接符，不参与计算

```c
$sign = md5("qa"+"android"+"com.test.demo"+"0cc852594cb2dfd0381af38f687b44906"+"com.tkkk.unitysdk.demo.a1"+"GPA.3340-7674-3284-90321"+"1.99"+"USD"+"game_extra_param_value"+"1692346624"+$secretKey)
```

** 5、重试机制 **   
在5个小时内最多重试10次，直到返回的http status为200且输出"success"为止。
  - 第一次 35秒
  - 第二次 40秒
  - 第三次 115秒
  - 第四次 150秒
  - 第五次 385秒
  - 第六次 755秒
  - 第七次 1500秒
  - 第八次 2610秒
  - 第九次 4230秒
  - 第十次 6850秒


