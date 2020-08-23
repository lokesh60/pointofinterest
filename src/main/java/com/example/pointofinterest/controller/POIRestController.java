package com.example.pointofinterest.controller;


import com.example.pointofinterest.model.HereMapResponse;
import com.example.pointofinterest.services.POIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class POIRestController {
    Logger logger = LoggerFactory.getLogger(POIRestController.class);
    @Autowired
    private POIService pOIService;

    @GetMapping(value = "/pointofinterest")
    public ResponseEntity<Object> getClosestPOI(@RequestParam(name = "location") String location) {
        logger.info("Getting the closest POI for Location"+location);
        HereMapResponse response= null;
        try {
            response = pOIService.getHereMapData(location);
        } catch (Exception e) {
            return new ResponseEntity("Internal  Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
