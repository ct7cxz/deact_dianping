package org.ct.dao;

import org.ct.bean.Ad;
import org.ct.dto.AdDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理广告的持久层接口
 */
@Repository
public interface IAdDao {

    //新增广告
    int saveAd(Ad ad);

    //查询所有
    Ad findAll();

    //分页查询
    List<Ad> findCurrentByPage(AdDto adDto);

    Integer findTotalCount();

    Long adDelete(Integer id);

    Ad showAdUpdate(Integer id);

    Long updateAd(Ad ad);
}
