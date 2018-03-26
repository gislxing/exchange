package com.xr.exchange.dao;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.model.AdminBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
public interface AdminDao {

    List<AdminBean> getAllAdmin(@Param("adminListBean") AdminListBean adminListBean, @Param("showLevel") Integer showLevel, @Param("loginAdmin") AdminBean loginAdmin);

    Integer saveAdmin(AdminBean adminBean);

    int getCountAdmin(AdminBean adminBean);

    AdminBean getCountAdminLogin(AdminBean adminBean);

    void upateStatus(@Param("username") String username, @Param("status") String status);

    void upateKeyId(@Param("adminBean") AdminBean adminBean,@Param("id") Integer id);

    void delete(@Param("username") String username);

    AdminBean getAdmin(@Param("id") Integer id);

    void updateAdmin(AdminBean adminBean);

    Integer upPassword(@Param("oldpassword") String oldpassword, @Param("password") String password, @Param("id") int id);
}
