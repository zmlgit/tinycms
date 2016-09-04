package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_keyword")
@Data
public class ContentKeyword {
    @Id
    @Column(name = "key_id",length = 40)
    private String keyId= UUID.randomUUID().toString().toUpperCase();

    /**
     * 文章关键字
     */
    @Column(name = "keyword", length = 32, unique = true)
    private String keyword;

}
