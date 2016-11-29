package cn.zmlio.tinycms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by zhangmanliang on 2016/8/25.
 */
@Data
@Table(name = "sys_role")
@Entity
@EqualsAndHashCode(callSuper = false)
public class Role extends AbstractEntity {

    private String roleCode;

    private String roleName;

    private String roleAlias;

    @ManyToMany(mappedBy = "roles", targetEntity = User.class)
    private Set<User> users;

}
