package com.example.pointofinterest.client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HereMapService", url = "${feignclient.url}")
public interface HereMapService {

    @Cacheable("heremapResult")
    @RequestMapping(method = RequestMethod.GET, value ="/discover/search?app_id=${heremap.app_id}&app_code=${heremap.app_code}")
    String hereMapDetails(@RequestParam("at") String at,@RequestParam("q") String q);
}
