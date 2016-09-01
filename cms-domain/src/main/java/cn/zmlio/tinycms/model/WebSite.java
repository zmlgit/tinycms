package cn.zmlio.tinycms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by ZML on 2016/8/28.
 */
@Entity
@Table(name = "cms_website")
public class WebSite {

    @Id
    @Column(length = 40)
    private String siteId = UUID.randomUUID().toString().toUpperCase();

    @Column(unique = true)
    private String domain;

    @Column(unique = true, name = "index_url")
    private String indexUrl;

    private int port = 80;
    @Column(name = "resource_path")
    private String resourcePath;

    @Column(name = "website_name")
    private String websiteName;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    @Override
    public String toString() {
        return "WebSite{" +
                "siteId=" + siteId +
                ", domain='" + domain + '\'' +
                ", indexUrl='" + indexUrl + '\'' +
                ", port=" + port +
                ", resourcePath='" + resourcePath + '\'' +
                ", websiteName='" + websiteName + '\'' +
                '}';
    }
}
