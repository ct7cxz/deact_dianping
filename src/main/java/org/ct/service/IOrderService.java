package org.ct.service;

import org.ct.dto.OrdersDto;

import java.util.List;

public interface IOrderService {
    boolean add(OrdersDto ordersDto);

    List<OrdersDto> getListByMemberId(Long memberId);

    OrdersDto getById(Long id);
}
