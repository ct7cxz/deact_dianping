package org.ct.service.impl;

import org.ct.dao.IDicDao;
import org.ct.bean.Dic;
import org.ct.service.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商户字典表service实现类
 */
@Service
public class DicServiceImpl implements IDicService {

    @Autowired
    private IDicDao dicDao;

    @Override
    public List<Dic> findByType(String city) {
        List<Dic> dicList= dicDao.findByType(city);
        return dicList;
    }
}
