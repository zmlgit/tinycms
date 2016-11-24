package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by zhangmanliang on 2016/8/25.
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role extends AbstractEntity {

    private String roleCode;

    private String roleName;

    private String roleAlias;

    @ManyToMany(mappedBy = "roles", targetEntity = User.class)
    private Set<User> users;

}
