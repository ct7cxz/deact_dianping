package org.ct.service.impl;

import org.ct.bean.Orders;
import org.ct.constant.CommentStateConst;
import org.ct.dao.IOrderDao;
import org.ct.dto.OrdersDto;
import org.ct.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Value("${businessImage.url}")
    private String businessImageUrl;

    @Override
    public boolean add(OrdersDto ordersDto) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersDto, orders);
        orders.setCommentState(CommentStateConst.NOT_COMMENT);
        return 1 == orderDao.insert(orders) ? true : false;
    }

    @Override
    public List<OrdersDto> getListByMemberId(Long memberId) {
        List<OrdersDto> result = new ArrayList<OrdersDto>();
        Orders ordersForSelect = new Orders();
        ordersForSelect.setMemberId(memberId);
        List<Orders>  ordersList = orderDao.select(ordersForSelect);
        for(Orders orders : ordersList) {
            OrdersDto ordersDto = new OrdersDto();
            result.add(ordersDto);
            BeanUtils.copyProperties(orders, ordersDto);
            ordersDto.setImg(businessImageUrl + orders.getBusiness().getImgFileName());
            ordersDto.setTitle(orders.getBusiness().getTitle());
            ordersDto.setCount(orders.getBusiness().getNumber());
        }
        return result;
    }

    @Override
    public OrdersDto getById(Long id) {
        OrdersDto result = new OrdersDto();
        Orders orders = orderDao.selectById(id);
        BeanUtils.copyProperties(orders, result);
        return result;
    }
}
