package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Entity
@Table(name = "sys_user")
@Data
public class User {

    @Id
    @Column(name = "user_id", length = 40)
    private String userId = UUID.randomUUID().toString().toUpperCase();

    @Column(unique = true, nullable = true, length = 64)
    private String username;

    @Column(unique = true, nullable = true, length = 15)
    private String mobile;

    @Column(unique = true, nullable = true, length = 64)
    private String email;

    @Column(unique = true, nullable = true, length = 64)
    private String password;

    @Column(unique = true, nullable = true, length = 40)
    private String salt;

    private Date createTime;

    private String displayName;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private List<Role> roles;

}
