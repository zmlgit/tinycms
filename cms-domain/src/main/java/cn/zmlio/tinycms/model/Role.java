package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by ZML on 2016/9/4.
 */
@Entity
@Table(name = "sys_role")
@Data
public class Role {

    @Id
    @Column(length = 40)
    private String roleId = UUID.randomUUID().toString().toUpperCase();
    ;

    @Column(length = 40)
    private String roleName;

    @Column(length = 40)
    private String roleAlis;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permission> perms;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.DETACH)
    private List<User> users;

}
