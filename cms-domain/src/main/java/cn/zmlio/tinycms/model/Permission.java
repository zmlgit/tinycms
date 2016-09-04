package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by ZML on 2016/9/4.
 */
@Entity
@Table(name = "sys_permission")
@Data
public class Permission {

    @Id
    @Column(length = 40)
    private String perId= UUID.randomUUID().toString().toUpperCase();

    private String perName;

    private String perAlis;

    @ManyToMany(mappedBy = "perms")
    private List<Role> roles;


}
