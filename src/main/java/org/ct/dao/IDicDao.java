package org.ct.dao;

import org.ct.bean.Dic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商户字典类的dao曾
 */

@Repository
public interface IDicDao {
    List<Dic> findByType(String city);
}
