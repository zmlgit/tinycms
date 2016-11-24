package cn.zmlio.tinycms.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by zhangmanliang on 2016/8/25.
 */
@Data
@Entity
@Table(name = "sys_permission")
public class Permission extends AbstractEntity {
    private String permName;
}
