
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
    component: ComponentCreator('/hachi-doc/versions/','384'),
    exact: true
  },
  {
    path: '/hachi-doc/',
    component: ComponentCreator('/hachi-doc/','de0'),
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
        path: '/hachi-doc/faq/',
        component: ComponentCreator('/hachi-doc/faq/','93e'),
        exact: true,
        sidebar: "tutorialSidebar"
      },
      {
        path: '/hachi-doc/selfTest/',
        component: ComponentCreator('/hachi-doc/selfTest/','d86'),
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
