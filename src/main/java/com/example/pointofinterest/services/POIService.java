package com.example.pointofinterest.services;

import com.example.pointofinterest.model.HereMapResponse;

import java.util.concurrent.ExecutionException;

public interface POIService {
    public HereMapResponse getHereMapData(String location) throws ExecutionException, InterruptedException;
}
