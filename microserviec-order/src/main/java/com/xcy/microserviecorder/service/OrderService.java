package com.xcy.microserviecorder.service;

import com.xcy.microserviecorder.pojo.Item;
import com.xcy.microserviecorder.pojo.Order;
import com.xcy.microserviecorder.pojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author xcy
 * @date 2019/01/31 10:54
 * @description 订单Service
 * @since V1.0.0
 */
@Service
public class OrderService {

    private static final Map<String, Order> MAP = new HashMap<>();

    static {
        Order order = new Order();
        order.setOrderId("59193738268961441");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);
        List<OrderDetail> orderDetailList = new ArrayList<>();


        Item item = new Item(); //此处并没有商品的数据,需要调用商品的微服务来获取
        item.setId(1L);
        orderDetailList.add(new OrderDetail(order.getOrderId(), item));

        item = new Item();
        item.setId(2L);//构造第二个商品
        orderDetailList.add(new OrderDetail(order.getOrderId(), item));

        //一个订单里面有2个商品
        order.setOrderDetails(orderDetailList);

        MAP.put(order.getOrderId(), order);

    }

    @Autowired
    private ItemService itemService;

    public Order queryOrderById(String id) {
        Order order = MAP.get(id);
        if (null == order) return null;

        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            //通过商品微服务查询商品信息
            Item item = itemService.queryItemById(orderDetail.getItem().getId());

            if (null == item) continue;

            orderDetail.setItem(item);
        }
        return order;
    }
}
