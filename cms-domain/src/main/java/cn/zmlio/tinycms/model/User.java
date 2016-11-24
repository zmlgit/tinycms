package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "sys_user")
@Data
public class User extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "encrypt")
    private String encrypt;

    @Column(name = "display_name")
    private String displayName;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

}
