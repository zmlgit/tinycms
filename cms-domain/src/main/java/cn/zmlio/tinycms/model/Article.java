package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_article")
@Data
public class Article extends AbstractEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meta_id")
    private ContentMeta meta;

    @Column(name = "content")
    @Lob
    private String content;//文章具体内容

}
