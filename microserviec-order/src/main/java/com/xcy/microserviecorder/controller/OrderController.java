package com.xcy.microserviecorder.controller;

import com.xcy.microserviecorder.pojo.Order;
import com.xcy.microserviecorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcy
 * @date 2019/01/31 11:16
 * @description 订单Controller
 * @since V1.0.0
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "order/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") String orderId) {
        return orderService.queryOrderById(orderId);
    }
}
