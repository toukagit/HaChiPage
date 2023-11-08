
import React from 'react';
import ComponentCreator from '@docusaurus/ComponentCreator';

export default [
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
    component: ComponentCreator('/hachi-doc/versions/','384'),
    exact: true
  },
  {
    path: '/hachi-doc/',
    component: ComponentCreator('/hachi-doc/','4c7'),
    routes: [
      {
        path: '/hachi-doc/',
        component: ComponentCreator('/hachi-doc/','b9b'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/download/',
        component: ComponentCreator('/hachi-doc/download/','d38'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/events/',
        component: ComponentCreator('/hachi-doc/events/','f9d'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/bv/',
        component: ComponentCreator('/hachi-doc/hc-integration/bv/','454'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/iv/',
        component: ComponentCreator('/hachi-doc/hc-integration/iv/','74f'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/nv/',
        component: ComponentCreator('/hachi-doc/hc-integration/nv/','36b'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/hc-integration/rv/',
        component: ComponentCreator('/hachi-doc/hc-integration/rv/','ae6'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/IAP/',
        component: ComponentCreator('/hachi-doc/IAP/','802'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/login/',
        component: ComponentCreator('/hachi-doc/login/','92c'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/other/',
        component: ComponentCreator('/hachi-doc/other/','f55'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/remoteConfig/',
        component: ComponentCreator('/hachi-doc/remoteConfig/','477'),
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
