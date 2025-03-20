package com.hsf301.javafx.lab2_hsf301.service;

import com.hsf301.javafx.lab2_hsf301.dto.SearchDriversDTO;

import java.util.List;

public interface SearchDriversService {
    void createSearchDriver(String name,String email,String address,String password);
    List<SearchDriversDTO> getAllSearchDrivers();
    SearchDriversDTO getSearchDriver(String email,String password);
    List<SearchDriversDTO> getSearchDrivers(String email,String name,String status);
}
