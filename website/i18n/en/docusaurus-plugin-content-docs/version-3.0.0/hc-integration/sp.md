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
The preferred way to use open screen ads on a cold start is to use the load screen to load game or app assets, and display ads only on the load screen. <br/> For example, if the game has a load scenario, close the load scenario and load the game scenario when the SDK initialization callback is received. <br/>SDK initialization callback see [【SDK Integration - Initialize SDK】](integration.md)

