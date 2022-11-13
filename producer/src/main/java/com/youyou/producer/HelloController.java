package com.youyou.producer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * 应用级别的服务注册，所以会暴露全部的http接口，与hsf的接口级别的注册不同
 * @author youliang
 * @date 2022/11/9
 */

@RestController
@Slf4j
public class HelloController {
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        String serverInfo = instance.getHost() + ":" + instance.getPort();
        log.info("/hello, host:{}, service_id:{}", instance.getHost(), instance.getServiceId());
        return serverInfo;
    }

}
