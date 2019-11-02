package org.ct.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMemberDao {
    /**
     * 判断当前号码是否存在
     * @param phone
     * @return
     */
    Long exists(Long phone);

    List<Long> getIdByPhone(Long phone);
}
