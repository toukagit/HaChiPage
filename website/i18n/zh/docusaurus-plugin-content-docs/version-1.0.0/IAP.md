---
title: "内购"
sidebar_label: "内购"
description: ""
sidebar_position: 3
---

# 内购 
:::danger
 - **需要添加 USE_IAP 宏定义**   
 - **[Unity In App Purchasing 插件版本需 4.9.3 或更高](https://docs.unity3d.com/Packages/com.unity.purchasing@4.9/manual/StoresSupported.html) (UnityEditor 2020.3+)**
:::
## 内购接入方法
### 1、导入IAP插件
导入Unity In App Purchasing插件。
Unity菜单栏 -> Window -> Package Manager -> In App Purchasing -> Install。


### 2、添加宏定义
```c
USE_IAP 
```

### 3、添加内购商品
:::tip
  支持两种添加方式:       
  **a. 在IAPProducts.cs中预设置商品ID**         
  **b. 通过AddProducts接口添加商品ID**
  
  <font color="ff0000"> 注意：添加商品类型必须和后台申请类型一致，否则可能请求不到对应商品信息。</font> <br/>
 
    ProductType.NonConsumable  只能购买一次。适合一次性购买的商品，如额外的关卡
    ProductType.Consumable     可以反复购买。适合虚拟货币等可消耗商品
    ProductType.Subscription   可以反复购买和恢复。耐用品，但有效期有限（订阅）

:::

a. 在**HCPurchaseProducts.cs**中预设置商品ID
```c
public static class HCPurchaseProducts
{
    /// <summary>
    /// 去广告商品ID(商品ID统一小写)
    /// </summary>
    public const string NoAds = "test.removeads";

    public readonly static Dictionary<string, ProductType> ProductDic = new Dictionary<string, ProductType>()
    {    
         // ProductType.NonConsumable  只能购买一次。适合一次性购买的商品，如额外的关卡
         // ProductType.Consumable     可以反复购买。适合虚拟货币等可消耗商品
         // ProductType.Subscription   可以反复购买和恢复。耐用品，但有效期有限（订阅）
        { NoAds, ProductType.NonConsumable},
        //Add more product
        ...
        ...
    };
}
```

b. 通过 **HCSDKManager.Instance.AddProducts**接口添加商品ID 
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
private void PurchaseCallback(string orderID, string productName, string productID, bool purchaseResult, string gameExtra)
{
    if (purchaseResult)
    {
        //购买成功
    }
    else
    {
        //购买失败
    }
}
```

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

### 6、获取本地化价格字符串接口
会返回带货币符号的价格字符串，如：'$1.99' '￥6.99'。
```c
public void GetPriceByID()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
   
    // 会返回带货币符号的价格字符串，如：'$1.99' '￥6.99'
    string price = HCSDKManager.Instance.GetPriceByID(productID);
}
```


### 7、获取所有商品信息
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

### 8、根据商品ID获取商品信息
```c
string productID = "com.tkkk.unitysdk.demo.a1";

Product prodyct = HCSDKManager.Instance.GetProductInfoByID(productID);
```

### 9、内购异常
如遇到支付失败，请确认以下问题：
- 支付回调必须设置在SDK初始化之前
- 所有商品类别需和后台配置一致，消耗品、非消耗品还是订阅产品
- GooglePlay中国地区账号无法调起支付，需切换地区或使用其他地区账号
- 网络原因，尝试切换不同vpn节点
