package org.ct.dao;

import org.ct.bean.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {
    /**
     * 新增商户信息
     * @param orders
     * @return
     */
    int insert(Orders orders);

    /**
     * 修改
     * @param orders 订单表对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 根据条件查询订单列表
     * @param orders 查询条件
     * @return 订单列表
     */
    List<Orders> select(Orders orders);

    /**
     * 依据id查询用户编号
     * @param id
     * @return
     */
    Orders selectById(Long id);
}
