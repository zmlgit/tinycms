package cn.zmlio.tinycms.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_keyword")
public class ContentKeyword {
    @Id
    @Column(name = "key_id",length = 40)
    private String keyId= UUID.randomUUID().toString().toUpperCase();

    /**
     * 文章关键字
     */
    @Column(name = "keyword", length = 32, unique = true)
    private String keyword;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "ContentKeyword{" +
                "keyId=" + keyId +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
