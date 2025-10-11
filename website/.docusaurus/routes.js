
import React from 'react';
import ComponentCreator from '@docusaurus/ComponentCreator';

export default [
  {
    path: '/hachi-doc/zh/helloReact/',
    component: ComponentCreator('/hachi-doc/zh/helloReact/','7bb'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/markdown-page/',
    component: ComponentCreator('/hachi-doc/zh/markdown-page/','1d9'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/versions/',
    component: ComponentCreator('/hachi-doc/zh/versions/','245'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/1.0.0/',
    component: ComponentCreator('/hachi-doc/zh/1.0.0/','cd3'),
    routes: [
      {
        path: '/hachi-doc/zh/1.0.0/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/','494'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/download/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/download/','562'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/events/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/events/','4ee'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/hc-integration/bv/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/hc-integration/bv/','786'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/hc-integration/iv/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/hc-integration/iv/','94d'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/hc-integration/nv/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/hc-integration/nv/','d36'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/hc-integration/rv/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/hc-integration/rv/','f34'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/IAP/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/IAP/','c7c'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/login/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/login/','285'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/other/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/other/','02b'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/qa/qaandroid/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/qa/qaandroid/','0a0'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/qa/qaios/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/qa/qaios/','344'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/remoteConfig/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/remoteConfig/','1c0'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/1.0.0/sdk-projectsettings/sdk-projectsettings-ios/',
        component: ComponentCreator('/hachi-doc/zh/1.0.0/sdk-projectsettings/sdk-projectsettings-ios/','28d'),
        exact: true,
        sidebar: "tutorialSidebar"
      }
    ]
  },
  {
    path: '/hachi-doc/zh/3.0.0/',
    component: ComponentCreator('/hachi-doc/zh/3.0.0/','5b9'),
    routes: [
      {
        path: '/hachi-doc/zh/3.0.0/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/','7c8'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/download/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/download/','e96'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/events/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/events/','787'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/hc-integration/bv/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/hc-integration/bv/','a39'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/hc-integration/iv/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/hc-integration/iv/','84e'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/hc-integration/nv/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/hc-integration/nv/','c39'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/hc-integration/rv/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/hc-integration/rv/','615'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/hc-integration/sp/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/hc-integration/sp/','0eb'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/IAP/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/IAP/','eef'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/integration/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/integration/','5da'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/login/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/login/','3d7'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/other/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/other/','f6f'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/qa/qaandroid/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/qa/qaandroid/','f8e'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/qa/qaios/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/qa/qaios/','e8e'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/remoteConfig/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/remoteConfig/','539'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/sdk-projectsettings/sdk-projectsettings-android/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/sdk-projectsettings/sdk-projectsettings-android/','d84'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/3.0.0/sdk-projectsettings/sdk-projectsettings-ios/',
        component: ComponentCreator('/hachi-doc/zh/3.0.0/sdk-projectsettings/sdk-projectsettings-ios/','dec'),
        exact: true,
        sidebar: "tutorialSidebar"
      }
    ]
  },
  {
    path: '/hachi-doc/zh/',
    component: ComponentCreator('/hachi-doc/zh/','a85'),
    routes: [
      {
        path: '/hachi-doc/zh/',
        component: ComponentCreator('/hachi-doc/zh/','f06'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/download/',
        component: ComponentCreator('/hachi-doc/zh/download/','fd3'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/events/',
        component: ComponentCreator('/hachi-doc/zh/events/','cac'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/bv/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/bv/','a21'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/iv/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/iv/','a77'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/rv/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/rv/','b79'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/sp/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/sp/','016'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/IAP/',
        component: ComponentCreator('/hachi-doc/zh/IAP/','0a4'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/integration/',
        component: ComponentCreator('/hachi-doc/zh/integration/','b11'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/login/',
        component: ComponentCreator('/hachi-doc/zh/login/','162'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/other/',
        component: ComponentCreator('/hachi-doc/zh/other/','bce'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/qa/qaandroid/',
        component: ComponentCreator('/hachi-doc/zh/qa/qaandroid/','a7c'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/qa/qaios/',
        component: ComponentCreator('/hachi-doc/zh/qa/qaios/','176'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/remoteConfig/',
        component: ComponentCreator('/hachi-doc/zh/remoteConfig/','566'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/sdk-projectsettings/sdk-projectsettings-android/',
        component: ComponentCreator('/hachi-doc/zh/sdk-projectsettings/sdk-projectsettings-android/','0d0'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/sdk-projectsettings/sdk-projectsettings-ios/',
        component: ComponentCreator('/hachi-doc/zh/sdk-projectsettings/sdk-projectsettings-ios/','001'),
        exact: true,
        sidebar: "tutorialSidebar"
      }
    ]
  },
  {
    path: '*',
    component: ComponentCreator('*')
  }
];
