package org.ct.service;

import org.ct.dto.BusinessDto;
import org.ct.bean.Business;
import org.ct.dto.BusinessListDto;

import java.util.List;

/**
 * 商户信息管理service接口
 */
public interface IBusinessService {
    List<BusinessDto> findCurrentByPage(BusinessDto businessDto);

    boolean deleteBusiness(BusinessDto businessDto);

    Business findBusiness(Long id);

    boolean addBusiness(BusinessDto businessDto);

    boolean updateBusiness(BusinessDto businessDto);

    BusinessListDto findAppCurrentByPage(BusinessDto businessDto);
}
