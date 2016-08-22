package cn.zmlio.tinycms.model;

import javax.persistence.*;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_keyword")
public class ContentKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_id")
    private Integer keyId;

    /**
     * 文章关键字
     */
    @Column(name = "keyword", length = 32, unique = true)
    private String keyword;


    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
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
