---
title: "In-app purchase"
sidebar_label: "In-app purchase"
description: ""
sidebar_position: 3
---

# In-app purchase
:::danger
 - **Need to add USE_IAP macro definition**   
 - **[Unity In App Purchasing plugin version 4.9.3 or higher](https://docs.unity3d.com/Packages/com.unity.purchasing@4.9/manual/StoresSupported.html) (UnityEditor 2020.3+)**
:::
## In-app purchase access method
### 1、Import IAP plug-in
Import the Unity In App Purchasing plug-in.   
Unity menu -> Window -> Package Manager -> In App Purchasing -> Install。


### 2、Add macro definition
```c
USE_IAP 
```

### 3、Add in-store items

:::tip
  Two adding methods are supported:    
  **a. Pre-set the product ID in IAPProducts.cs**         
  **b. Add the product ID through the AddProducts interface**
  
  <font color="ff0000"> Note: The added product type must be the same as the background application type, otherwise the corresponding product information may not be requested.</font> <br/>
 
    ProductType.NonConsumable  It can only be purchased once. Good for one-time purchases, such as extra levels
    ProductType.Consumable     Can be purchased repeatedly. Suitable for consumable goods such as virtual currency
    ProductType.Subscription   Can be purchased and restored repeatedly. Durable goods, but for a limited period (subscription)

:::

a. Pre-set the item ID in **HCPurchaseProducts.cs**
```c
public static class HCPurchaseProducts
{
    /// <summary>
    /// Unadvertised product ID(product ID unified lowercase)
    /// </summary>
    public const string NoAds = "test.removeads";

    public readonly static Dictionary<string, ProductType> ProductDic = new Dictionary<string, ProductType>()
    {    
         // ProductType.NonConsumable  It can only be purchased once. Good for one-time purchases, such as extra levels
         // ProductType.Consumable     Can be purchased repeatedly. Suitable for consumable goods such as virtual currency
         // ProductType.Subscription   Can be purchased and restored repeatedly. Durable goods, but for a limited period (subscription)
        { NoAds, ProductType.NonConsumable},
        //Add more product
        ...
        ...
    };
}
```

b. By ** HCSDKManager. Instance. AddProducts add commodity ID ** interface
```c
Dictionary<string, ProductType> ProductDic = new Dictionary<string, ProductType>()
{
    { "com.tkkk.unitysdk.demo.1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a12",ProductType.Consumable}
};

HCSDKManager.Instance.AddProducts(ProductDic);
```

### 4、Buy listening callback
:::danger
 - **Payment callbacks must be set before SDK initialization**
 - **The payment callback is an asynchronous callback, and when the callback is returned, ensure that the game reward is issued normally. It is suggested that the game side can add a mask to shield user actions during the payment process**   
:::

```c
void Start()
{
    // Set the purchase listening callback
    HCSDKManager.Instance.SetOnPurchaseDone(PurchaseCallback);
}

/// Apple/Google Pay order number
/// Custom product name on the game side
/// The product ID of the payment
/// Successful payment or not
/// Game extension field
private void PurchaseCallback(string orderID, string productName, string productID, bool purchaseResult, string gameExtra)
{
    if (purchaseResult)
    {
        //Successful purchase
    }
    else
    {
        //Purchase failed
    }
}
```

### 5、Purchase interface
```c 
public void BuyProduct()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
    string productName = "a1";
    string gameExtra = "a1GameExtraParam";
    HCSDKManager.Instance.BuyProductByID(productID,productName,gameExtra);
}
```

### 6、Gets the localized price string interface
Returns a price string with a currency symbol, such as '$1.99' '￥6.99'.
```c
public void GetPriceByID()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
   
    // Returns a price string with a currency symbol, such as '$1.99' '￥6.99'.
    string price = HCSDKManager.Instance.GetPriceByID(productID);
}
```


### 7、Get all product information
Return all configured items on AppStore/Google Play.
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

### 8、Get product information based on product ID
```c
string productID = "com.tkkk.unitysdk.demo.a1";

Product prodyct = HCSDKManager.Instance.GetProductInfoByID(productID);
```

### 9、The in-app purchase is abnormal
In case of payment failure, please confirm the following issues:
- Payment callbacks must be set before SDK initialization
- All product categories must be consistent with the background configuration, consumables, non-consumables or subscription products
- GooglePlay China account cannot be adjusted to pay, you need to switch regions or use another region account
- Attempts to switch between different vpn nodes due to network reasons
