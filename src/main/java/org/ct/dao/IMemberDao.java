package org.ct.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao {
    /**
     * 判断当前号码是否存在
     * @param phone
     * @return
     */
    Long exists(Long phone);
}
