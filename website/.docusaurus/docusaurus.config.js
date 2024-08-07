/*
 * AUTOGENERATED - DON'T EDIT
 * Your edits in this file will be overwritten in the next build!
 * Modify the docusaurus.config.js file at your site's root instead.
 */
export default {
  "title": "Hachi SDK Docs",
  "tagline": "Dinosaurs are cool",
  "titleDelimiter": "-",
  "url": "https://toukagit.github.io/hachi-doc/",
  "baseUrl": "/hachi-doc/zh/",
  "onBrokenLinks": "throw",
  "onBrokenMarkdownLinks": "warn",
  "favicon": "img/favicon.ico",
  "trailingSlash": true,
  "baseUrlIssueBanner": false,
  "organizationName": "toukagame",
  "projectName": "hachi-doc",
  "i18n": {
    "defaultLocale": "en",
    "locales": [
      "en",
      "zh"
    ],
    "localeConfigs": {
      "en": {
        "htmlLang": "en-US",
        "direction": "ltr"
      },
      "zh": {
        "label": "简体中文",
        "htmlLang": "zh-CN",
        "direction": "ltr"
      }
    }
  },
  "presets": [
    [
      "classic",
      {
        "docs": {
          "path": "docs",
          "routeBasePath": "/",
          "breadcrumbs": true,
          "showLastUpdateTime": false,
          "sidebarPath": "/Users/junconglee/Desktop/TKG_Game/HaChiSDK/HaChiPage/website/sidebars.js",
          "onlyIncludeVersions": [
            "1.0.0",
            "3.0.0"
          ]
        },
        "pages": {},
        "blog": false,
        "theme": {
          "customCss": "/Users/junconglee/Desktop/TKG_Game/HaChiSDK/HaChiPage/website/src/css/custom.css"
        }
      }
    ]
  ],
  "themeConfig": {
    "colorMode": {
      "defaultMode": "light",
      "disableSwitch": false,
      "respectPrefersColorScheme": true
    },
    "hideableSidebar": true,
    "navbar": {
      "hideOnScroll": false,
      "title": "Hachi SDK",
      "logo": {
        "alt": "My Site Logo",
        "src": "img/logo.svg",
        "width": 32,
        "height": 32
      },
      "items": [
        {
          "type": "doc",
          "docId": "index",
          "position": "left",
          "label": "Docs"
        },
        {
          "type": "docsVersionDropdown",
          "position": "right",
          "dropdownActiveClassDisabled": true,
          "dropdownItemsBefore": [],
          "dropdownItemsAfter": []
        },
        {
          "type": "localeDropdown",
          "position": "right",
          "dropdownItemsBefore": [],
          "dropdownItemsAfter": []
        }
      ]
    },
    "prism": {
      "theme": {
        "plain": {
          "color": "#393A34",
          "backgroundColor": "#f6f8fa"
        },
        "styles": [
          {
            "types": [
              "comment",
              "prolog",
              "doctype",
              "cdata"
            ],
            "style": {
              "color": "#999988",
              "fontStyle": "italic"
            }
          },
          {
            "types": [
              "namespace"
            ],
            "style": {
              "opacity": 0.7
            }
          },
          {
            "types": [
              "string",
              "attr-value"
            ],
            "style": {
              "color": "#e3116c"
            }
          },
          {
            "types": [
              "punctuation",
              "operator"
            ],
            "style": {
              "color": "#393A34"
            }
          },
          {
            "types": [
              "entity",
              "url",
              "symbol",
              "number",
              "boolean",
              "variable",
              "constant",
              "property",
              "regex",
              "inserted"
            ],
            "style": {
              "color": "#36acaa"
            }
          },
          {
            "types": [
              "atrule",
              "keyword",
              "attr-name",
              "selector"
            ],
            "style": {
              "color": "#00a4db"
            }
          },
          {
            "types": [
              "function",
              "deleted",
              "tag"
            ],
            "style": {
              "color": "#d73a49"
            }
          },
          {
            "types": [
              "function-variable"
            ],
            "style": {
              "color": "#6f42c1"
            }
          },
          {
            "types": [
              "tag",
              "selector",
              "keyword"
            ],
            "style": {
              "color": "#00009f"
            }
          }
        ]
      },
      "darkTheme": {
        "plain": {
          "color": "#F8F8F2",
          "backgroundColor": "#282A36"
        },
        "styles": [
          {
            "types": [
              "prolog",
              "constant",
              "builtin"
            ],
            "style": {
              "color": "rgb(189, 147, 249)"
            }
          },
          {
            "types": [
              "inserted",
              "function"
            ],
            "style": {
              "color": "rgb(80, 250, 123)"
            }
          },
          {
            "types": [
              "deleted"
            ],
            "style": {
              "color": "rgb(255, 85, 85)"
            }
          },
          {
            "types": [
              "changed"
            ],
            "style": {
              "color": "rgb(255, 184, 108)"
            }
          },
          {
            "types": [
              "punctuation",
              "symbol"
            ],
            "style": {
              "color": "rgb(248, 248, 242)"
            }
          },
          {
            "types": [
              "string",
              "char",
              "tag",
              "selector"
            ],
            "style": {
              "color": "rgb(255, 121, 198)"
            }
          },
          {
            "types": [
              "keyword",
              "variable"
            ],
            "style": {
              "color": "rgb(189, 147, 249)",
              "fontStyle": "italic"
            }
          },
          {
            "types": [
              "comment"
            ],
            "style": {
              "color": "rgb(98, 114, 164)"
            }
          },
          {
            "types": [
              "attr-name"
            ],
            "style": {
              "color": "rgb(241, 250, 140)"
            }
          }
        ]
      },
      "additionalLanguages": []
    },
    "docs": {
      "versionPersistence": "localStorage"
    },
    "metadata": [],
    "autoCollapseSidebarCategories": false,
    "tableOfContents": {
      "minHeadingLevel": 2,
      "maxHeadingLevel": 3
    }
  },
  "onDuplicateRoutes": "warn",
  "staticDirectories": [
    "static"
  ],
  "customFields": {},
  "plugins": [],
  "themes": [],
  "scripts": [],
  "stylesheets": [],
  "clientModules": [],
  "noIndex": false
};
