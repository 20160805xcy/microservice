package com.xcy.microserviecorder.service;

import com.xcy.microserviecorder.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author xcy
 * @date 2019/01/31 11:12
 * @description 商品微服务
 * @since V1.0.0
 */
@Service
public class ItemService {

    //spring框架对restful方式的http请求做了封装,来简化操作
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${com.xcy.itemService.url}")
    private String itemServiceUrl;

    public Item queryItemById(Long id) {


        String serviceId = "xcy-microservice-item";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if (null == instances) return null;

        //为了演示,这里只获取一个实例
        ServiceInstance serviceInstance = instances.get(0);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();

        //return restTemplate.getForObject(itemServiceUrl + id, Item.class);
        return restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);
    }

}
