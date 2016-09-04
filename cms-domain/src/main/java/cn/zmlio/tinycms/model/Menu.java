package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by ZML on 2016/9/4.
 */
@Data
@Entity
@Table(name = "sys_menu")
public class Menu {

    @Id
    @Column(length = 40)
    private String menuId = UUID.randomUUID().toString().toUpperCase();

    private String menuName;

    private String style;

    private String className;

    private String href;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Menu> subMenus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu parent;

}
