import React from 'react';

import Layout from '@theme/Layout';

import useDocusaurusContext from '@docusaurus/useDocusaurusContext';
import Link from '@docusaurus/Link';
import useBaseUrl from '@docusaurus/useBaseUrl';

import versions from '../../../versions.json';
import hachiSdkVersions from '../../../hachi_sdk_versions.json';

function getNameFormUrl(url) {
    // 使用URL对象来解析链接
    const parsedUrl = new URL(url);
// 从路径中获取文件名
    return parsedUrl.pathname.split('/').pop();
}

function Version() {
    const context = useDocusaurusContext();
    const {siteConfig = {}} = context;
    const latestVersion = versions[0];
    const pastVersions = versions.filter(version => version !== latestVersion);
    const repoUrl = `https://github.com/${siteConfig.organizationName}/${siteConfig.projectName}`;
    if (hachiSdkVersions.length < 1) {
        return (
            <Layout permalink="/versions"
                    description="single-spa Versions page listing all documented site versions">
                <div>
                    没有配置sdk,请到配置文件中先配置 hachi_sdk_versions.json
                </div>
            </Layout>
        )
    }

    const firstSDKInfo = hachiSdkVersions[0];
    return (
        <Layout
            permalink="/versions"
            description="single-spa Versions page listing all documented site versions">
            <div className="container margin-vert--xl">
                <h1>HaChi SDK Release note</h1>
                <div className="margin-bottom--lg">
                    <h2>Latest version</h2>

                    <b><Link to={useBaseUrl('/download')}><font size="5">HaChiSDK
                        v{firstSDKInfo.sdk_version}</font></Link> </b> <br/>
                    <table border="0" width="80%" align="left">
                        <tbody>
                        <tr>
                            <td style={{"width": "15%"}}>SDK Name</td>
                            <td style={{"width": "15%"}}>SDK Version</td>
                            <td style={{"width": "15%"}}>Update Time</td>
                            <td style={{"width": "40%"}}>Update Content</td>
                            <td style={{"width": "25%"}}>Download</td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td style={{"width": "15%"}}>HaChiSDK</td>
                            <td style={{"width": "15%"}}>{firstSDKInfo.sdk_version}</td>
                            <td style={{"width": "15%"}}>{firstSDKInfo.update_time}</td>
                            <td style={{"width": "40%"}}>
                                {firstSDKInfo.update_content.zh.split('\n').map((line, index) => (
                                    <React.Fragment key={index}>
                                        {line}
                                        <br/>
                                    </React.Fragment>
                                ))}
                            </td>
                            <td style={{"width": "25%"}}>
                                <a href={firstSDKInfo.download}>{getNameFormUrl(firstSDKInfo.download)}</a><br/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </div>

                {hachiSdkVersions.length > 1 ?
                    <div className="margin-bottom--lg">

                        <h3 id="archive">Historical version</h3>
                        <hr/>
                        {hachiSdkVersions.map((item, index) => (
                            index !== 0 &&
                            <div key={index}>
                                <div><b><font size="4">HaChiSDK v{item.sdk_version}</font></b></div>
                                <div>
                                    <table border="0" width="80%">
                                        <tbody>
                                        <tr>
                                            <td style={{"width": "15%"}}>SDK Name</td>
                                            <td style={{"width": "15%"}}>SDK Version</td>
                                            <td style={{"width": "15%"}}>Update Time</td>
                                            <td style={{"width": "40%"}}>Update Content</td>
                                            <td style={{"width": "25%"}}>Download</td>
                                        </tr>
                                        </tbody>
                                        <tbody>
                                        <tr>
                                            <td style={{"width": "15%"}}>HaChiSDK</td>
                                            <td style={{"width": "15%"}}>{item.sdk_version}</td>
                                            <td style={{"width": "15%"}}>{item.update_time}</td>
                                            <td style={{"width": "40%"}}>
                                                {item.update_content.zh.split('\n').map((line, index) => (
                                                    <React.Fragment key={index}>
                                                        {line}
                                                        <br/>
                                                    </React.Fragment>
                                                ))}
                                            </td>
                                            <td style={{"width": "25%"}}>
                                                <a href={item.download}>{getNameFormUrl(item.download)}</a><br/>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        ))}
                    </div>
                    : <div></div>}

            </div>

        </Layout>
    );
}

export default Version;
