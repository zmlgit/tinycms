package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zhangmanliang on 2016/11/24.
 */
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class AbstractEntity {

    @Id
    @Column(name = "user_id", length = 40)
    private String id = UUID.randomUUID().toString().toUpperCase();

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private boolean yn = true;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "create_user")
    private User createUser;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "update_user")
    private User updateUser;

}
