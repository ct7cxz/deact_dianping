package org.ct.dao;

import org.ct.bean.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISysUserDao {
    List<SysUser> findSysUser(SysUser user);
}
