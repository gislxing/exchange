package com.xr.exchange.dao;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.ProxyPayListBean;
import com.xr.exchange.bean.ProxyPopListBean;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.ProxyPayVo;
import com.xr.exchange.model.ProxyPopVo;
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

    Integer rebutPop(@Param("proxyPopVo") ProxyPopVo proxyPopVo);

    void updateAdminMoney(@Param("adminId") Integer adminId,@Param("money") float money);


    Integer upPassword(@Param("oldpassword") String oldpassword, @Param("password") String password, @Param("id") int id);

    List<ProxyPayVo> getProxyPayList(@Param("proxyPayListBean") ProxyPayListBean proxyPayListBean, @Param("loginAdmin") AdminBean loginAdmin);

    List<ProxyPopVo> getProxyPopList(@Param("proxyPopListBean") ProxyPopListBean proxyPopListBean, @Param("loginAdmin") AdminBean loginAdmin);
}
