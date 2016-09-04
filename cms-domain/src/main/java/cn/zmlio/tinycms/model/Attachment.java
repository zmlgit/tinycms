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
public class Attachment {

    @Id
    @Column(length = 40)
    private String attachId= UUID.randomUUID().toString().toUpperCase();//附件ID

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

}
