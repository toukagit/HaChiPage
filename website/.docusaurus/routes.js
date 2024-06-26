
import React from 'react';
import ComponentCreator from '@docusaurus/ComponentCreator';

export default [
  {
    path: '/hachi-doc/zh/__docusaurus/debug/',
    component: ComponentCreator('/hachi-doc/zh/__docusaurus/debug/','074'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/__docusaurus/debug/config/',
    component: ComponentCreator('/hachi-doc/zh/__docusaurus/debug/config/','2ff'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/__docusaurus/debug/content/',
    component: ComponentCreator('/hachi-doc/zh/__docusaurus/debug/content/','5f6'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/__docusaurus/debug/globalData/',
    component: ComponentCreator('/hachi-doc/zh/__docusaurus/debug/globalData/','f58'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/__docusaurus/debug/metadata/',
    component: ComponentCreator('/hachi-doc/zh/__docusaurus/debug/metadata/','058'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/__docusaurus/debug/registry/',
    component: ComponentCreator('/hachi-doc/zh/__docusaurus/debug/registry/','84b'),
    exact: true
  },
  {
    path: '/hachi-doc/zh/__docusaurus/debug/routes/',
    component: ComponentCreator('/hachi-doc/zh/__docusaurus/debug/routes/','d3c'),
    exact: true
  },
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
    path: '/hachi-doc/zh/',
    component: ComponentCreator('/hachi-doc/zh/','a70'),
    routes: [
      {
        path: '/hachi-doc/zh/',
        component: ComponentCreator('/hachi-doc/zh/','dd1'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/download/',
        component: ComponentCreator('/hachi-doc/zh/download/','ab5'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/events/',
        component: ComponentCreator('/hachi-doc/zh/events/','38b'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/bv/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/bv/','03f'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/iv/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/iv/','ad1'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/nv/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/nv/','22f'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/hc-integration/rv/',
        component: ComponentCreator('/hachi-doc/zh/hc-integration/rv/','dac'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/IAP/',
        component: ComponentCreator('/hachi-doc/zh/IAP/','1ab'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/login/',
        component: ComponentCreator('/hachi-doc/zh/login/','fa9'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/other/',
        component: ComponentCreator('/hachi-doc/zh/other/','b6f'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/qa/qaandroid/',
        component: ComponentCreator('/hachi-doc/zh/qa/qaandroid/','1f9'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/qa/qaios/',
        component: ComponentCreator('/hachi-doc/zh/qa/qaios/','730'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/remoteConfig/',
        component: ComponentCreator('/hachi-doc/zh/remoteConfig/','fd8'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/zh/sdk-projectsettings/sdk-projectsettings-ios/',
        component: ComponentCreator('/hachi-doc/zh/sdk-projectsettings/sdk-projectsettings-ios/','39f'),
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
