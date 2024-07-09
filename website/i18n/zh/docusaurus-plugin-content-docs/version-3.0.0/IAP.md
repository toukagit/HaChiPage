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
:::
## 内购接入方法
### 1、导入IAP插件
导入Unity In App Purchasing插件。
Unity菜单栏 -> Window -> Package Manager -> In App Purchasing -> Install。<br/><br/>
** 如果In App Purchasing插件版本不是4.12.0时，请按照以下步骤添加：**

<center>

<img src="../img/HCSDK/image37.png"/>

</center>


** 输入：com.unity.purchasing  ** 

### 2、添加宏定义
```c
USE_IAP 
```

### 3、添加内购商品
:::tip
  支持两种添加方式:       
  **a. 通过 AddProductsStatic 接口添加商品(在初始化SDK接口前调用) **<br/>
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
注：<br/>
此方法需要在初始化SDK前调用，即初始化SDK前设置好商品信息。<br/>

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


### 4、购买监听回调
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
private void PurchaseCallback(string orderID, string productName, string productID, bool purchaseResult, string gameExtra,bool orderAlreadyExists)
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
1、orderAlreadyExists 字段用于判断是否是恢复购买/补单的商品。<br/>
2、当执行到此回调时，purchaseResult = true 说明购买成功；orderAlreadyExists = true时，说明此商品为恢复购买/补单的商品，此时应再次下发奖励；例如用户购买了去广告，卸载重装应用后，恢复购买时，应再次下发去广告商品。<br/>
3、purchaseResult 字段和 orderAlreadyExists 字段不会同时为true。

### 5、购买商品接口
```c 
public void BuyProduct()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
    string productName = "a1";
    string gameExtra = "a1GameExtraParam";
    HCSDKManager.Instance.BuyProductByID(productID,productName,gameExtra);
}
```

### 6、恢复购买（仅iOS）
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

### 7、奖励下发上报
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


### 8、获取本地化价格字符串接口
会返回带货币符号的价格字符串，如：'$1.99' '￥6.99'。
```c
public void GetPriceByID()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
   
    // 会返回带货币符号的价格字符串，如：'$1.99' '￥6.99'
    string price = HCSDKManager.Instance.GetPriceByID(productID);
}
```

### 9、连续续订产品
当iap插件初始化成功时会检查当前是否存在连续订阅型产品，请在初始化SDK前注册回调。<br/>
开发者需要在订单过期时收回续订权益，即 validity = false 时回收权益。

```c
HCSDKManager.Instance.SetOnCheckSubscribeValidity((productId,validity)=>{

    HCDebugger.LogDebug("OnCheckSubscribeValidity productId:"+productId+ " validity"+ validity);
    if (validity)
    {
        // 商品在有效期内
    }
    else
    {
        // 商品已过期
    }
});
```
注：SDK会将所有订阅订单进行验证，因此该回调会执行多次，当执行到过期订单时该回调中validity会返回false，执行到最新一条订阅订单时，如果用户没有退订该商品，validity会返回true。

### 10、补单
```c
HCSDKManager.Instance.ReadFailOrderId();
```
SDK会在购买成功和购买失败后主动检查本地是否包含未验证订单，未验证订单校验成功后将触发 **4、购买监听回调**，开发者也可根据实际情况主动调用补单接口进行补单逻辑。

### 11、获取所有商品信息
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

### 12、根据商品ID获取商品信息
```c
string productID = "com.tkkk.unitysdk.demo.a1";

Product prodyct = HCSDKManager.Instance.GetProductInfoByID(productID);
```

### 13、内购异常
如遇到支付失败，请确认以下问题：
- 支付回调必须设置在SDK初始化之前
- 所有商品类别需和后台配置一致，消耗品、非消耗品还是订阅产品
- GooglePlay中国地区账号无法调起支付，需切换地区或使用其他地区账号
- 网络原因，尝试切换不同vpn节点




