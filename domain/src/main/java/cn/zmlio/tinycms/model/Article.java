package cn.zmlio.tinycms.model;

import javax.persistence.*;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer articleId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meta_id")
    private ContentMeta meta;

    @Column(name = "content")
    @Lob
    private String content;//文章具体内容

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public ContentMeta getMeta() {
        return meta;
    }

    public void setMeta(ContentMeta meta) {
        this.meta = meta;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
