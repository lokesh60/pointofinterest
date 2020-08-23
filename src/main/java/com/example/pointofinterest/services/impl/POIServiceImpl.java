package com.example.pointofinterest.services.impl;

import com.example.pointofinterest.client.HereMapService;
import com.example.pointofinterest.common.APIConstants;
import com.example.pointofinterest.dto.HereMapResponseDTO;
import com.example.pointofinterest.model.HereMapResponse;
import com.example.pointofinterest.model.Items;
import com.example.pointofinterest.services.POIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/***
 * This class with make use for @HereMapService.class to get the response from HEREMAP
 */
@Component
public class POIServiceImpl implements POIService {
    private static Logger LOGGER = LoggerFactory.getLogger(POIServiceImpl.class);
    @Autowired
    private HereMapService hereMapService;

  public static ObjectMapper objectMapper=new ObjectMapper();
  static {
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }


    /***
     *It will call the 3 different type category and consolidate the result
     * @param location
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public HereMapResponse getHereMapData(String location) throws ExecutionException, InterruptedException {
        HereMapResponse hereMapResponse = new HereMapResponse();
        List<Items> itemList = new ArrayList<>();
        CompletableFuture<List<Items>> restaurantDataFuture = getHereMapRestaurantData(location);
        CompletableFuture<List<Items>> parkingSpotsDataFuture = getHereMapParkingSpotsData(location);
        CompletableFuture<List<Items>> chargingStationsDataFuture = getHereMapChargingStationsData(location);
        itemList.addAll(restaurantDataFuture.get());
        itemList.addAll(parkingSpotsDataFuture.get());
        itemList.addAll(chargingStationsDataFuture.get());
        hereMapResponse.setItems(itemList);
        return hereMapResponse;
    }

    /***
     *
     * @param location
     * @return
     */
    @Async
    public CompletableFuture<List<Items>> getHereMapRestaurantData(String location) {
        LOGGER.info("CALLING HERE MAP API FOR {}", APIConstants.RESTAURANT);
        String response = hereMapService.hereMapDetails(location, APIConstants.RESTAURANT);
        try {
            HereMapResponseDTO hereMapResponseDTO = objectMapper.readValue(response, HereMapResponseDTO.class);
            List<Items> itemsList = hereMapResponseDTO.getResults().getItems();
            Collections.sort(itemsList);
            if (itemsList.size() > 3) {
                itemsList = itemsList.subList(0, 3);
            }
            return CompletableFuture.completedFuture(itemsList);
        } catch (JsonProcessingException e) {
            LOGGER.error("ERROR IN PARSING THE RESPONSE JSON {}", e);
            return null;
        }
    }

    /**
     * @param location
     * @return
     */
    @Async
    public CompletableFuture<List<Items>> getHereMapParkingSpotsData(String location) {
        LOGGER.info("CALLING HERE MAP API FOR {}", APIConstants.PARKING_SPOTS);
        String response = hereMapService.hereMapDetails(location, APIConstants.PARKING_SPOTS);
        try {
            HereMapResponseDTO hereMapResponseDTO = objectMapper.readValue(response, HereMapResponseDTO.class);
            List<Items> itemsList = hereMapResponseDTO.getResults().getItems();
            Collections.sort(itemsList);
            if (itemsList.size() > 3) {
                itemsList = itemsList.subList(0, 3);
            }
            return CompletableFuture.completedFuture(itemsList);
        } catch (JsonProcessingException e) {
            LOGGER.error("ERROR IN PARSING THE RESPONSE JSON {}", e);
            return null;
        }
    }

    /**
     * @param location
     * @return
     */
    @Async
    public CompletableFuture<List<Items>> getHereMapChargingStationsData(String location) {
        LOGGER.info("CALLING HERE MAP API FOR {}", APIConstants.CHARGING_STATIONS);
        String response = hereMapService.hereMapDetails(location, APIConstants.CHARGING_STATIONS);
        try {
            HereMapResponseDTO hereMapResponseDTO = objectMapper.readValue(response, HereMapResponseDTO.class);
            List<Items> itemsList = hereMapResponseDTO.getResults().getItems();
            Collections.sort(itemsList);
            if (itemsList.size() > 3) {
                itemsList = itemsList.subList(0, 3);
            }
            return CompletableFuture.completedFuture(itemsList);
        } catch (JsonProcessingException e) {
            LOGGER.error("ERROR IN PARSING THE RESPONSE JSON {}", e);
            return null;
        }
    }

}
