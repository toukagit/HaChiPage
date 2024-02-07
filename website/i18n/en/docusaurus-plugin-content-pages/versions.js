import React from 'react';

import Layout from '@theme/Layout';

import useDocusaurusContext from '@docusaurus/useDocusaurusContext';
import Link from '@docusaurus/Link';
import useBaseUrl from '@docusaurus/useBaseUrl';

import versions from '../../../versions.json';

function Version() {
  const context = useDocusaurusContext();
  const {siteConfig = {}} = context;
  const latestVersion = versions[0];
  const pastVersions = versions.filter(version => version !== latestVersion);
  const repoUrl = `https://github.com/${siteConfig.organizationName}/${siteConfig.projectName}`;
  return (
    <Layout
      permalink="/versions"
      description="single-spa Versions page listing all documented site versions">
      <div className="container margin-vert--xl">
        <h1>HaChi SDK Release note</h1>
        <div className="margin-bottom--lg">
        <h2>Latest version</h2>
        
		<b><Link to={useBaseUrl('/download')}><font size="5">HaChiSDK v2.1.0</font></Link> </b>  <br />
        <table border="0" width="80%" align="left">
          <tr>
                    <td>SDK Name</td>
                    <td>SDK Version</td>
                    <td>Update Time</td>
                    <td>Update Content</td>
                    <td>Download</td>
                  </tr>
                  <tr>
                    <td >HaChiSDK</td>
                    <td>2.1.0</td>
                    <td>2024-02-07</td>
                    <td>
                        1. fix bugs.
                    </td>
                    <td>
                    <a href="https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/2.1.0/HCSDK_2.1.0_f0ea0b4.unitypackage">HCSDK_2.1.0_f0ea0b4.unitypackage</a><br/>
                    </td>
          </tr>
          </table>
          <br/><br/><br/><br/><br/><br/><br/>
        </div>

        <div className="margin-bottom--lg">
                <h3 id="archive">Historical version</h3>
                <hr />
          
                  <b><font size="4">HaChiSDK v2.0.0</font> </b>  <br />
                  <table border="0" width="80%" align="left">
                    <tr>
                              <td>SDK Name</td>
                              <td>SDK Version</td>
                              <td>Update Time</td>
                              <td>Update Content</td>
                              <td>Download</td>
                            </tr>
                            <tr>
                              <td >HaChiSDK</td>
                              <td>2.0.0</td>
                              <td>2024-01-05</td>
                              <td>
                                  1. All ids to be filled in are read from the configuration file.
                              </td>
                              <td>
                              <a href="https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/2.0.0/HCSDK_2.0.0_32a0ea8.unitypackage">HCSDK_2.0.0_32a0ea8.unitypackage</a><br/>
                              </td>
                    </tr>
                    </table>
                    <br/><br/><br/><br/><br/><br/><br/>
                  <b><font size="4">HaChiSDK v1.1.2</font> </b>  <br />
                  <table border="0" width="80%" align="left">
                    <tr>
                              <td>SDK Name</td>
                              <td>SDK Version</td>
                              <td>Update Time</td>
                              <td>Update Content</td>
                              <td>Download</td>
                            </tr>
                            <tr>
                              <td >HaChiSDK</td>
                              <td>1.1.2</td>
                              <td>2023-11-09</td>
                              <td>
                                  1. Add the toast pop-up parameter to the display incentive video interface, which is enabled by default
                              </td>
                              <td>
                              <a href="https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/1.1.2/HCSDK_1.1.2_47527f7.unitypackage">HCSDK_1.1.2_47527f7.unitypackage</a><br/>
                              </td>
                    </tr>
                    </table>
                    <br/><br/><br/><br/><br/><br/><br/>
                  <b><font size="4">HaChiSDK v1.0.0</font> </b>  <br />
                  <table border="0" width="80%" align="left">
                      <tr>
                          <td>SDK Name</td>
                          <td>SDK Version</td>
                          <td>Update Time</td>
                          <td>Update Content</td>
                          <td>Download</td>
                      </tr>
                      <tr>
                          <td >HaChiSDK </td>
                          <td>1.0.0</td>
                          <td>2023-10-26</td>
                          <td>
                                1、Initial release
                          </td>
                          <td>
                              <a href="https://touka-artifacts.oss-cn-beijing.aliyuncs.com/TKG%20%E5%8F%91%E8%A1%8C%E6%8A%80%E6%9C%AF/Hachi%20SDK/Unity/1.0.0/HCSDK_1.0.0_dc754a8.unitypackage">HCSDK_1.0.0_dc754a8.unitypackage</a><br/>
                                                  
                          </td>
                      </tr>
                  </table>
                  </div>
              </div>

    </Layout>
  );
}

export default Version;
