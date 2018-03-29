package com.xr.exchange.constants;

/**
 * 常量类
 *
 * @author zjw
 * @create 2018/3/21.
 */
public interface Const {

    /**
     * 数据标示字符串
     */
    String STR_DATA = "data";

    /**
     * pageInfo标识
     */
    String STR_PAGE_INFO = "pageInfo";

    /**
     * 默认页码
     */
    Integer DEFAULT_PAGE_NUM = 1;

    /**
     * 默认每页条数
     */
    Integer DEFAULT_PAGE_SIZE = 15;

    /**
     * 搜索数据字符串标识
     */
    String STR_SEARCH_CONDITIONS = "searchData";

    /**
     * 标志字符串
     */
    String STR_FLAG = "flag";

    /**
     * 信息字符串
     */
    String STR_MSG = "msg";

    /**
     * 成功标志
     */
    String SUCCESS_FLAG = "success";

    /**
     * 失败标志
     */
    String FAILED_FLAG = "failed";

    /**
     * 管理员等级：交易所
     */
    Integer ADMIN_LEVEL_EXCHANGE = 1;

    /**
     * 管理员等级：运营中心
     */
    Integer ADMIN_LEVEL_OPERATION_CENTER = 2;

    /**
     * 管理员等级：综合会员
     */
    Integer ADMIN_LEVEL_COMPREHENSIVE_MEMBER = 3;

    /**
     * 管理员等级：微圈代理
     */
    Integer ADMIN_LEVEL_MICRO_PROXY = 4;

    /**
     * session 中保存的登陆用户 key
     */
    String KEY_SESSION_LOGIN_ADMIN = "adminBean";

    /**
     * 登陆用户等级标示
     */
    String SIGN_LOGIN_ADMIN_LEVEL = "loginAdminLevel";

    /**
     * 显示的管理员等级
     */
    String SIGN_ADMIN_SHOW_LEVEL = "showLevel";

    /**
     * 登录的管理员名称标示
     */
    String LOGIN_ADMIN_NAME = "username";
    /**
     * 当前用户等级
     */
    String SIGN_ADMIN_LEVEL = "level";

    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "123456";

    /**
     * 用户交易标志
     */
    Integer USER_DEAL_FLAG = 0;

    /**
     * 用户持仓标志
     */
    Integer USER_SETTLEMENT_DEAL_FLAG = 1;

    /**
     * 商品标志
     */
    String STR_GOODS_FLAG = "goodsList";
}
