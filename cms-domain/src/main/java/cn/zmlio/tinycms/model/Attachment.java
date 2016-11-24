package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ZML on 2016/8/28.
 */
@Entity
@Table(name = "cms_attachment")
@Data
public class Attachment extends AbstractEntity{


    @Column(name = "server_path")
    private String serverPath;//文件储存路径


    private long length;//文件长度

    @Column(name = "group_flag")
    private String groupFlag;//附件分组信息

    @Column(name = "file_name")
    private String fileName;//原始文件名称

    @Column(name = "serve_url")
    private String serveUrl;//外部可以访问到的url

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Attachment other = (Attachment) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
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
