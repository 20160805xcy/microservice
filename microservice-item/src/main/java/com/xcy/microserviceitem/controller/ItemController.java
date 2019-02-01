package com.xcy.microserviceitem.controller;

import com.xcy.microserviceitem.pojo.Item;
import com.xcy.microserviceitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcy
 * @date 2019/01/31 10:17
 * @description 商品Controller
 * @since V1.0.0
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 对外提供接口服务,查询商品信息
     * @param id
     * @return
     */
    @GetMapping(value = "item/{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        return itemService.queryItemById(id);
    }
}
