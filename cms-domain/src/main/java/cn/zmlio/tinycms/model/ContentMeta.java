package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_contentmeta")
@Data
public class ContentMeta {

    @Id
    @Column(name = "meta_id",length = 40)
    private String metaId= UUID.randomUUID().toString().toUpperCase();

    @Column(name = "create_time")
    private Date createTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;//作者

    @Column(name = "audit_state")
    private int auditState;//审核状态

    @Column(name = "audit_time")
    private Date auditTime;//审核时间

    private int source;//文章来源

    private String origin;//转载于xxx

    private int reader;//阅读量

    private int favour;//赞成数

    private int opponent;//反对数

    @OneToOne(mappedBy = "meta", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private Article article;

}
