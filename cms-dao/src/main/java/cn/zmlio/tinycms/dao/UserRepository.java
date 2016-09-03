package cn.zmlio.tinycms.dao;

import cn.zmlio.tinycms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ZML on 2016/9/3.
 */
public interface UserRepository extends JpaRepository<User,String> {

}
