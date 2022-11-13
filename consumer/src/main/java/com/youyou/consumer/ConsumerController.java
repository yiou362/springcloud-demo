package com.youyou.consumer;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author youliang
 * @date 2022/11/13
 */

@RestController
public class ConsumerController {
//    @Autowired
//    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate template;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String index() {
        return template.getForEntity("http://producer-service/hello", String.class).getBody();
    }
}
