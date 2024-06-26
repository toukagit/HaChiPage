---
title: "In-app purchase"
sidebar_label: "In-app purchase"
description: ""
sidebar_position: 3
---

# In-app purchase
:::danger
 - **Need to add USE_IAP macro definition**   
 - **[Unity In App Purchasing plugin version 4.12.0 or higher](https://docs.unity3d.com/Packages/com.unity.purchasing@4.9/manual/StoresSupported.html) (UnityEditor 2020.3+)**
:::
## In-app purchase access method
### 1、Import IAP plug-in
Import the Unity In App Purchasing plug-in.   
Unity menu -> Window -> Package Manager -> In App Purchasing -> Install。

If the version of the plug-in In App Purchasing is not 4.12.0, follow these steps to add it:

<center>

<img src="../img/HCSDK/image37.png"/>

</center>

**input：com.unity.purchasing** 

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
        //Restore purchase
        if(orderAlreadyExists){
        
            //Restore purchase success
        
        }else{
        
           // Purchase fail
        
        }
    }
}
```
** Description: ** <br/>
1. The orderAlreadyExists field is used to determine whether to restore the purchased item. <br/>
2. When this callback is executed, the purchase is successful if orderAlreadyExists = true, and the reward should be issued again; For example, after the user has purchased an AD, uninstall and reinstall the application, and click to resume the purchase, the AD should be issued again. <br/>
3. The purchaseResult and orderAlreadyExists fields are not both true.


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

### 9、Restore purchase (iOS Only)

```c
HCSDKManager.Instance.RestorePurchases();
```

** Description: **<br/>
1.for iOS products, Apple requires that if the in-purchase item contains non-consumable items, there must be a recovery purchase function. <br/>
2.Restore the purchase function, please add according to the requirement document. The general logic is to add a restore purchase button on the setup screen. After uninstallation and reinstallation, click the Restore purchase button to restore purchased non-consumables. <br/>
3.when there is a recoverable item, it will eventually be called to the successful purchase callback (point 4), and the game needs to ensure that the reward can be issued normally. <br/>
4.Example: <br/>
If an item is a non-consumable item, the reward is: remove AD and 100 gold. When resuming the purchase, only the remove AD is restored, and 100 gold coins are not restored. <br/>
Each time the recovery purchase method is called, the successful purchase will be called back, and the game needs to add logic to judge not to repeat or hide the recovery purchase button. <br/>

### 10、The in-app purchase is abnormal
In case of payment failure, please confirm the following issues:
- Payment callbacks must be set before SDK initialization
- All product categories must be consistent with the background configuration, consumables, non-consumables or subscription products
- GooglePlay China account cannot be adjusted to pay, you need to switch regions or use another region account
- Attempts to switch between different vpn nodes due to network reasons

### 11、Continue to renew products
When the iap plug-in initializes successfully, it checks for the existence of a continuous subscription product. Please register the callback before initializing the SDK

```c
HCSDKManager.Instance.SetOnCheckSubscribeValidity((productId,validity)=>{

    HCDebugger.LogDebug("OnCheckSubscribeValidity productId:"+productId+ " validity"+ validity);
    if (validity)
    {
        // The goods are within the validity period
    }
    else
    {
        // Goods have expired
    }
});
```
Note: The SDK validates all subscription orders, so the callback is executed multiple times. validity returns false in the callback when the expired order is executed. validity returns true when the latest subscription order is executed if the user did not unorder the item.
