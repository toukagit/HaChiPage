
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
    path: '/hachi-doc/zh/',
    component: ComponentCreator('/hachi-doc/zh/','486'),
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
