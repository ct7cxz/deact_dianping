package org.ct.service.impl;

import org.ct.bean.SysUser;
import org.ct.dao.ISysUserDao;
import org.ct.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserDao userDao;

    @Override
    public boolean findSysUser(SysUser user) {
        return userDao.findSysUser(user).size() == 1 ? true : false;
    }
}
