---
title: "App Open"
sidebar_label: "App Open"
description: ""
sidebar_position: 4
---

:::tip
When a program starts up, it is referred to as a **cold start**. When the program is switched to the background and then brought back to the foreground, it is referred to as a **hot start**.
:::

## Showing a App Open Ad
The SDK controls the loading and display of open screen ads.

## Best practice
It is best to display an open screen AD in loading scene, and the developer must receive the initialization callback before entering the main scene of the game. <br/>
Internal logic: the developer calls the SDK initialization method,
- If the screen switch is on, the load screen advertisement will be displayed.
    - The load advertisement in 5s will be displayed normally, and the initialization callback will be given when the open screen advertisement is closed;
    - If the on-screen advertisement is not ready after 5s, the initialization will be directly callback, and the cold start advertisement will not be displayed this time; (5s can be controlled by online parameters)
- If the screen switch is off, the initialization callback is also directly performed; 

SDK initialization callback see [【SDK Integration - Initialize SDK】](integration.md)

