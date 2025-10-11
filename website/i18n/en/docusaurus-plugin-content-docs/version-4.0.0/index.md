---
sidebar_position: 1
---

# Hachi SDK intro

The Hachi SDK, called HC SDK for short, is designed for medium to heavy games. Do not use it for other types of projects.

This SDK has aggregated the following three SDKS:

analyze
* ThinkingData
* Adjust
* Firebase
* Facebook

ads
* AppLovin
* Chartboost
* DT Exchange
* Google Ad Manager
* Admob（Google bidding and Google AdMob）
* InMobi
* IronSource
* Liftoff Monetize
* Meta Audience Network（Facebook）
* Mintegral
* Pangle
* Unity Ads
* Moloco
* Smaato
* Verve

** Matters needing attention **

Check whether the Unity project has integrated the above SDK by itself. If so, be sure to remove it. <br/>
Check whether the Unity project contains advertising SDK. If there is integration, be sure to remove it to avoid conflict with the Hachi SDK advertising function. <br/>
It is recommended to clean up unnecessary third party SDKS and try to start your access with pure game engineering.
