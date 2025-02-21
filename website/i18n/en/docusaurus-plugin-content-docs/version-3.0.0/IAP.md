---
title: "In-app purchase"
sidebar_label: "In-app purchase"
description: ""
sidebar_position: 3
---

# In-app purchase
:::danger
 - ** Need to add USE_IAP macro definition **   
 - ** [Unity In App Purchasing plugin version 4.12.0 or higher](https://docs.unity3d.com/Packages/com.unity.purchasing@4.9/manual/StoresSupported.html) (UnityEditor 2020.3+) **
 - ** Must achieve [ 【8、reward issuance reporting(Must join)】 ](#8reward-issuance-reportmust-join) **
 - ** SDK will automatically check whether the local contains unverified orders after successful purchase and failed purchase, and it is recommended that developers take the initiative to request a replacement order when entering the main interface. [[9、 replenishment]](#9replenishment)  ** 
 - ** To test in-app purchases, you need to add your Google account to your Google Background test account first. **
 - ** You need to click the test link on the mobile terminal to join the test account, and you cannot join the test account on the computer terminal. If the PC has been added, log out of the PC.** 

:::
## In-app purchase access method
### 1、Import IAP plug-in
Import the Unity In App Purchasing plug-in.   
Unity menu -> Window -> Package Manager -> In App Purchasing -> Install。

** If you don't see version 4.12.0 In App Purchasing plug-in, follow these steps to add: Add packages by name -> Enter: com.unity.purchasing **

<center>

<img src="../img/HCSDK/image37.png"/>

</center>


### 2、Add macro definition
```c
USE_IAP 
```

### 3、Add in-store items

:::tip
  Two adding methods are supported:    
  **a. Adding an item through the AddProductsStatic interface (<font color="ff0000">called before initializing the SDK interface</font>)**
  **b. Add the product ID through the AddProducts interface**
  
  <font color="ff0000"> Note: The added product type must be the same as the background application type, otherwise the corresponding product information may not be requested.</font> <br/>
 
    ProductType.NonConsumable  It can only be purchased once. Good for one-time purchases, such as extra levels<br/>
    ProductType.Consumable     Can be purchased repeatedly. Suitable for consumable goods such as virtual currency<br/>
    ProductType.Subscription   Can be purchased and restored repeatedly. Durable goods, but for a limited period<br/> (subscription)

:::

a. By ** HCSDKManager. Instance. AddProductsStatic add commodity ID ** interface 
```c
Dictionary<string, ProductType> ProductDic = new Dictionary<string, ProductType>()
{
    { "com.tkkk.unitysdk.demo.1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a1",ProductType.Consumable},
    { "com.tkkk.unitysdk.demo.a12",ProductType.Consumable}
};

HCSDKManager.Instance.AddProductsStatic(ProductDic);
```

<font color="ff0000">note：This method needs to be called before initializing the SDK, that is, set the product information before initializing the SDK.</font>


<br/><br/>

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

### 4、Initialize iap callback
:::danger
 - **The initial callback must be set before SDK initialization**
:::
```c
HCSDKManager.Instance.SetOnPurchaseInitLinstener((result,errorMsg)=>
{
    if (result)
    {
        // Iap init success
        HCDebugger.LogDebug("Iap init success");
    }
    else
    {
        // Iap init fail
        HCDebugger.LogDebug("Iap init fail, errorMsg:"+errorMsg);
    }
});
```

### 5、Buy listening callback
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
/// Whether the recovery purchase is triggered, mainly used to prompt a dialog box(iOS only)
private void PurchaseCallback(string orderID, string productName, string productID, bool purchaseResult, string gameExtra,bool isRestore, PurchasingCode code)
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
1. Items are normally delivered from purchaseResult or orderAlreadyExists that is true. The game side should handle the reward itself according to the demand, and the reward can not be issued repeatedly for non-consumable items. (If the de-advertising package contains de-advertising +500 diamonds, uninstall and reinstall to resume the purchase, only need to re-reward the de-advertising, and 500 diamonds have been issued before without being issued again,For details about the logic, see the requirements document)<br/>
2. The purchaseResult and orderAlreadyExists fields are not both true. <br/>
3. The payment status in the callback is described as follows：
```c
public enum PurchasingCode
{
    PurchasingUnavailable,          // The system purchase function cannot be used
    ExistingPurchasePending,        // The previous purchase was in progress when the new purchase was requested
    ProductUnavailable,             // Unable to buy goods in the store
    SignatureInvalid,               // Signature verification of purchase receipt failed
    UserCancelled,                  // The user chose to cancel rather than continue the purchase
    PaymentDeclined,                // Payment problem
    DuplicateTransaction,           // A duplicate transaction error that occurs when the transaction has been successfully completed
    Unknown,                        // Common cause of unidentified purchase problems
    ServerRequestFailed,            // The client failed to request the server for purchase. Procedure
    ServerAuthenticationFailed,     // The client purchase succeeds. Server authentication fails
    PurchasingSuccess               // The client purchase succeeds. The server authentication succeeds
}
```

### 6、Purchase interface
```c 
public void BuyProduct()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
    string productName = "a1";
    string gameExtra = "a1GameExtraParam";
    HCSDKManager.Instance.BuyProductByID(productID,productName,gameExtra);
}
```

### 7、Restore purchase (iOS Only)

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


### 8、Reward issuance report(Must join)
:::danger
 The game must implement this interface to complete the closed loop of internal purchase events.<br/>
 This interface is invoked when one of purchaseResult or orderAlreadyExists is true from Purchaseresult.
:::

```c
/// <summary>
/// IAP games report rewards after delivery
/// </summary>
/// <param name="productName">Trade name</param>
/// <param name="productID">Product SKU ID</param>
/// <param name="orderID">Order ID</param>
/// <param name="gameExtra01">Game Expansion field - Number of items purchased</param>
/// <param name="gameExtra02">Game expansion field</param>
public void LogCheckingOrder(string productName, string productID, string orderID, string gameExtra01, string gameExtra02);

e.g:
private void PurchaseCallback(string orderID, string productName, string productID, bool purchaseResult,
        string gameExtra, bool orderAlreadyExists)
{
    if (purchaseResult || orderAlreadyExists)
    {
        mPurchaseBtn.text = "Successful purchase";
        HCSDKManager.Instance.LogCheckingOrder(productName,productID,orderID,"gameExtra01","gameExtra02");
    }
    else
    {
        mPurchaseBtn.text = "Purchase failure";
    }

    HCDebugger.LogDebug("PurchaseCallback orderID:" + orderID + " productName:" + productName + " productID" +
                        productID + " purResult" + purchaseResult + " gameExtra:" + gameExtra +
                        " orderAlreadyExists:" + orderAlreadyExists);
}
```

### 9、replenishment
```c
HCSDKManager.Instance.ReadFailOrderId();
```
The SDK will proactively check whether the local contains unverified orders after the purchase success and purchase failure. After the unverified order verification is successful, it will trigger [【4、Buy listening callback】](#4buy-listening-callback). The developer can also actively call the replenishment interface for replenishment logic according to the actual situation.


### 10、Gets the localized price string interface
Returns a price string with a currency symbol, such as '$1.99' '￥6.99'.
```c
public void GetPriceByID()
{
    string productID = "com.tkkk.unitysdk.demo.a1";
   
    // Returns a price string with a currency symbol, such as '$1.99' '￥6.99'.
    string price = HCSDKManager.Instance.GetPriceByID(productID);
}
```

### 11、Query Continuous Subscription product information (v3.1.4 new)
The SDK supports two ways to query information about purchased continuous subscription products:
#### 11.1 Registration callback
Register the callback before initializing the SDK. When the IAP plug-in initializes successfully, the SDK checks whether continuous subscription product information exists.<br/>
The developer can reclaim the renewal benefits when the order expires, i.e., when validity = false or Is_expired = 1 in HCSubscribeData. (Specific performance can be determined according to the requirements document)

```c
public void SetOnCheckSubscribeValidity(Action<string, bool, HCSubscribeData> onCheckSubscribeValidityAction);

e.g.：
HCSDKManager.Instance.SetOnCheckSubscribeValidity((productId,validity,data)=>
{
    // productId 
    // validity Indicates whether the validity is expired. fales: the validity is expired. true: the validity is not expired
    // data Subscription-based product information
    HCDebugger.LogDebug("SubscribeData ===> "+JsonConvert.SerializeObject(data));
});
```
#### 11.2 Active query
Developers can actively call the query interface at the right time to query subscription commodity information
```c
public void CheckSubsribeDataByProductId(string productId,Action<HCSubscribeData> onCheckSubsribeByProductIdAction);

e.g.：
HCSDKManager.Instance.CheckSubsribeDataByProductId("productId", (data) =>
{
    // productId
    // data Subscription-based product information
    HCDebugger.LogDebug("SubscribeData ===> "+JsonConvert.SerializeObject(data));
});

```


Continuous Subscription Product Information ** HCSubscribeData ** Description is as follows:

```c

    public int Illegal_order;       // 0: indicates a legal order, 1: indicates an illegal order
    public string Illegal_msg;      // Illegal order information
    public string Environment;      // production & sandbox
    public string Purchase_time;    // Subscription time, in milliseconds
    public int Is_subscribed;       // Subscribed or not 0: Not subscribed. 1: subscribed
    public int Is_expired;          // Expired 0 Not expired, 1: expired
    public int Is_cancelled;        // 0: not canceled. 1: canceled
    public int Is_free_trial;       // 0: not a free trial, 1: a free trial
    public int Is_auto_renewing;    // Whether to renew automatically 0: not automatic, 1: automatic
    public string Remaining_time;   // Time remaining for subscription expiration, in milliseconds
    public string Expiry_time;      // Expiration time, in milliseconds
    public string Latest_order_id;  // The latest order number for your current subscription
    public string Product_id;       // Product ID
        
```


### 12、Get all product information（optional）
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

### 13、Get product information based on product ID（optional）
```c
string productID = "com.tkkk.unitysdk.demo.a1";

Product prodyct = HCSDKManager.Instance.GetProductInfoByID(productID);
```

### 14、The in-app purchase is abnormal
In case of payment failure, please confirm the following issues:
- Payment callbacks must be set before SDK initialization
- All product categories must be consistent with the background configuration, consumables, non-consumables or subscription products
- GooglePlay China account cannot be adjusted to pay, you need to switch regions or use another region account
- Attempts to switch between different vpn nodes due to network reasons

## Server Integration (Optional)
After a successful payment through the SDK, the game retrieves the payment result via a callback. For games with a server, it is recommended to prioritize integration with the SDK server's payment callback interface. After a successful payment, the SDK server will notify the game server to deliver the purchased goods. In the case of standalone games, ensure that the goods are delivered to the player after receiving a successful payment callback from the client.

       

### Preparation for third-party game callback
1、Obtain game-side authorization encryption secret from the integration partner.       
2、Provide the game-side callback URL to the integration partner for configuration.

Currently, only one payment callback address can be configured in the background. If the payment callback is required to multiple servers, the R&D server must perform interface forwarding. For example, synchronous forwarding to an online server and a test server.
### Game-side Callback Address Interface Description
** 1、Request Method: Post        **      
** 2、Header Authorization:  ``` Authorization: secretkey  ```                        **      
** 3、Body Json        **      
<table>
  <tr>
    <td>Name</td>
    <td>Type</td>
    <td>isRequired</td>
    <td>Des</td>
    <td>Example Value</td>
  </tr>
  <tr>
    <td>env</td>
    <td>String</td>
    <td>Y</td>
    <td>Environment <br/>(qa: test; prod: production)</td>
    <td>prod</td>
  </tr>
    <tr>
    <td>platform</td>
    <td>String</td>
    <td>Y</td>
    <td>platform（android/ios）</td>
    <td>android</td>
  </tr>
    <tr>
    <td>pkg</td>
    <td>String</td>
    <td>Y</td>
    <td>package name</td>
    <td>com.test.demo</td>
  </tr>
    <tr>
    <td>user_id</td>
    <td>String</td>
    <td>Y</td>
    <td>UserID</td>
    <td>0cc852594cb2dfd0381af38f687b44906</td>
  </tr>
  <tr>
    <td>product_id</td>
    <td>String</td>
    <td>Y</td>
    <td>Product ID</td>
    <td>com.tkkk.unitysdk.demo.a1</td>
  </tr>
  <tr>
    <td>order_id</td>
    <td>String</td>
    <td>Y</td>
    <td>Order ID</td>
    <td>GPA.3340-7674-3284-90321</td>
  </tr>
  <tr>
    <td>price</td>
    <td>String</td>
    <td>Y</td>
    <td>Price</td>
    <td>1.99</td>
  </tr>
  <tr>
    <td>currency</td>
    <td>String</td>
    <td>Y</td>
    <td>Currency</td>
    <td>USD</td>
  </tr>
  <tr>
    <td>game_extra_param</td>
    <td>String</td>
    <td>N</td>
    <td>Game Extra Param</td>
    <td>game_extra_param_value</td>
  </tr>
  <tr>
    <td>ts</td>
    <td>String</td>
    <td>Y</td>
    <td>Timestamp</td>
    <td>1692346624</td>
  </tr>
  <tr>
    <td>sign</td>
    <td>String</td>
    <td>Y</td>
    <td>Encrypted Value</td>
    <td>33dasfdewffggg</td>
  </tr>
</table>

```c
Body JSON Example （secretkey: 64f1b1fb8efadc41dcd29d5c）
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

** 4、Encryption Method **  
Calculate the value of the "Sign" field by concatenating the parameter values (parameter value 1 + parameter value 2 + parameter value n + secret key) in the order of the returned parameters, and then applying MD5 encryption. The "+" sign is used as a connector and is not included in the calculation.

```c
$sign = md5("qa"+"android"+"com.test.demo"+"0cc852594cb2dfd0381af38f687b44906"+"com.tkkk.unitysdk.demo.a1"+"GPA.3340-7674-3284-90321"+"1.99"+"USD"+"game_extra_param_value"+"1692346624"+$secretKey)
```

** 5、Retry Mechanism **   
Retry up to 10 times within a 5-hour timeframe with the following intervals:

Retry 1: After 35 seconds   <br/>
Retry 2: After 40 seconds   <br/>
Retry 3: After 115 seconds   <br/>
Retry 4: After 150 seconds   <br/>
Retry 5: After 385 seconds   <br/>
Retry 6: After 755 seconds   <br/>
Retry 7: After 1500 seconds   <br/>
Retry 8: After 2610 seconds   <br/>
Retry 9: After 4230 seconds   <br/>
Retry 10: After 6850 seconds   <br/>
Continue retrying until the returned HTTP status is 200 and the output is 'success'.
