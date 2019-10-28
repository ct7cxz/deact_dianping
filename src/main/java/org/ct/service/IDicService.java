package org.ct.service;

import org.ct.bean.Dic;

import java.util.List;

/**
 * 字典表管理Service的接口
 */
public interface IDicService {
    List<Dic> findByType(String city);
}
