package org.ct.dao;

import org.ct.bean.Business;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBusinessDao<T> {
    Integer findTotalCount();

    List<T> findCurrentByPage(Business business);

    Long deleteBusiness(Integer id);

    Business findBusiness(Long id);

    Long addBusiness(Business business);

    Long updateBusiness(Business business);
}
