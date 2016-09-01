package cn.zmlio.tinycms.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "cms_category")
public class ContentCategory {

    @Id
    @Column(name = "category_id",length = 40)
    private String categoryId= UUID.randomUUID().toString().toUpperCase();

    @Column(name = "category_name")
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "parent_id")
    private ContentCategory superCategory;

    @OneToMany(mappedBy = "superCategory",fetch = FetchType.LAZY)
    private List<ContentCategory> subCategories;

    @Column(name = "category_code",length = 32)
    private String categoryCode;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ContentCategory getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(ContentCategory superCategory) {
        this.superCategory = superCategory;
    }

    public List<ContentCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<ContentCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
