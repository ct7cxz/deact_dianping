package org.ct.dao;

import org.ct.bean.SysParam;
import org.springframework.stereotype.Repository;

/**
 * 获取系统参数时间
 */
@Repository
public interface ISysParamDao {

    /**
     * 根据KEY获取对应的系统参数值
     * @param key
     * @return 系统参数值
     */
    SysParam selectByKey(String key);

    /**
     * 根据KEY修改对应的系统参数值
     * @param sysParam
     * @return 影响行数
     */
    int updateByKey(SysParam sysParam);

}
