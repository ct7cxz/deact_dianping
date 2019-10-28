package org.ct.service;

import org.ct.dto.AdDto;
import org.ct.bean.Ad;

import java.util.List;

/**
 * 广告界面的service接口
 */
public interface IAdService {

    //新增广告
    boolean saveAd(AdDto adDto);

    List<AdDto> findCurrentByPage(AdDto adDto);

    boolean adDelete(Integer id);

    Ad showAdUpdate(Integer id);

    Boolean adUpdate(AdDto adDto);

    List<AdDto> findAppCurrent(AdDto adDto);
}
