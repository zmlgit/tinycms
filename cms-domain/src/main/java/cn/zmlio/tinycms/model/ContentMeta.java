package cn.zmlio.tinycms.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_contentmeta")
public class ContentMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_id")
    private Integer metaId;

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

    @OneToOne(mappedBy = "meta", cascade = CascadeType.MERGE)
    private Article article;

    public Integer getMetaId() {
        return metaId;
    }

    public void setMetaId(Integer metaId) {
        this.metaId = metaId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String from) {
        this.origin = from;
    }

    public int getReader() {
        return reader;
    }

    public void setReader(int reader) {
        this.reader = reader;
    }

    public int getFavour() {
        return favour;
    }

    public void setFavour(int favour) {
        this.favour = favour;
    }

    public int getOpponent() {
        return opponent;
    }

    public void setOpponent(int opponent) {
        this.opponent = opponent;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
