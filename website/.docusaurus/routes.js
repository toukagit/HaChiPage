
import React from 'react';
import ComponentCreator from '@docusaurus/ComponentCreator';

export default [
  {
    path: '/hachi-doc/__docusaurus/debug/',
    component: ComponentCreator('/hachi-doc/__docusaurus/debug/','f73'),
    exact: true
  },
  {
    path: '/hachi-doc/__docusaurus/debug/config/',
    component: ComponentCreator('/hachi-doc/__docusaurus/debug/config/','b2d'),
    exact: true
  },
  {
    path: '/hachi-doc/__docusaurus/debug/content/',
    component: ComponentCreator('/hachi-doc/__docusaurus/debug/content/','e74'),
    exact: true
  },
  {
    path: '/hachi-doc/__docusaurus/debug/globalData/',
    component: ComponentCreator('/hachi-doc/__docusaurus/debug/globalData/','6b1'),
    exact: true
  },
  {
    path: '/hachi-doc/__docusaurus/debug/metadata/',
    component: ComponentCreator('/hachi-doc/__docusaurus/debug/metadata/','bd7'),
    exact: true
  },
  {
    path: '/hachi-doc/__docusaurus/debug/registry/',
    component: ComponentCreator('/hachi-doc/__docusaurus/debug/registry/','aca'),
    exact: true
  },
  {
    path: '/hachi-doc/__docusaurus/debug/routes/',
    component: ComponentCreator('/hachi-doc/__docusaurus/debug/routes/','73d'),
    exact: true
  },
  {
    path: '/hachi-doc/helloReact/',
    component: ComponentCreator('/hachi-doc/helloReact/','b51'),
    exact: true
  },
  {
    path: '/hachi-doc/markdown-page/',
    component: ComponentCreator('/hachi-doc/markdown-page/','335'),
    exact: true
  },
  {
    path: '/hachi-doc/versions/',
    component: ComponentCreator('/hachi-doc/versions/','302'),
    exact: true
  },
  {
    path: '/hachi-doc/',
    component: ComponentCreator('/hachi-doc/','5bf'),
    routes: [
      {
        path: '/hachi-doc/',
        component: ComponentCreator('/hachi-doc/','98d'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/download/',
        component: ComponentCreator('/hachi-doc/download/','2de'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/events/',
        component: ComponentCreator('/hachi-doc/events/','8bc'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/bv/',
        component: ComponentCreator('/hachi-doc/hc-integration/bv/','581'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/iv/',
        component: ComponentCreator('/hachi-doc/hc-integration/iv/','248'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/nv/',
        component: ComponentCreator('/hachi-doc/hc-integration/nv/','c63'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/rv/',
        component: ComponentCreator('/hachi-doc/hc-integration/rv/','917'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/IAP/',
        component: ComponentCreator('/hachi-doc/IAP/','fb6'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/login/',
        component: ComponentCreator('/hachi-doc/login/','7dd'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/other/',
        component: ComponentCreator('/hachi-doc/other/','cc0'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/qa/qaandroid/',
        component: ComponentCreator('/hachi-doc/qa/qaandroid/','644'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/qa/qaios/',
        component: ComponentCreator('/hachi-doc/qa/qaios/','73a'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/remoteConfig/',
        component: ComponentCreator('/hachi-doc/remoteConfig/','370'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/sdk-projectsettings/sdk-projectsettings-ios/',
        component: ComponentCreator('/hachi-doc/sdk-projectsettings/sdk-projectsettings-ios/','ec6'),
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
