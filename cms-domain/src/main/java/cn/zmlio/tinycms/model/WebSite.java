package cn.zmlio.tinycms.model;

import lombok.Data;

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
@Data
public class WebSite {

    @Id
    @Column(length = 40)
    private String siteId = UUID.randomUUID().toString().toUpperCase();

    @Column(unique = true)
    private String domain;

    @Column(unique = true)
    private String indexUrl;

    private int port = 80;
    
    private String resourcePath;

    private String websiteName;
}
