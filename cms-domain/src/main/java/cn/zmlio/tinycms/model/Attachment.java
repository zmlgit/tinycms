package cn.zmlio.tinycms.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ZML on 2016/8/28.
 */
@Entity
@Table(name = "cms_attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachId;//附件ID

    @Column(name = "server_path")
    private String serverPath;//文件储存路径


    private long length;//文件长度

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "group_flag")
    private String groupFlag;//附件分组信息

    @Column(name = "file_name")
    private String fileName;//原始文件名称

    @Column(name = "serve_url")
    private String serveUrl;//外部可以访问到的url

    public int getAttachId() {
        return attachId;
    }

    public void setAttachId(int attachId) {
        this.attachId = attachId;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getServeUrl() {
        return serveUrl;
    }

    public void setServeUrl(String serveUrl) {
        this.serveUrl = serveUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attachId == null) ? 0 : attachId.hashCode());
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((serveUrl == null) ? 0 : serveUrl.hashCode());
        result = prime * result + ((serverPath == null) ? 0 : serverPath.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Attachment other = (Attachment) obj;
        if (attachId == null) {
            if (other.attachId != null)
                return false;
        } else if (!attachId.equals(other.attachId))
            return false;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        if (serveUrl == null) {
            if (other.serveUrl != null)
                return false;
        } else if (!serveUrl.equals(other.serveUrl))
            return false;
        if (serverPath == null) {
            if (other.serverPath != null)
                return false;
        } else if (!serverPath.equals(other.serverPath))
            return false;
        return true;
    }
}
