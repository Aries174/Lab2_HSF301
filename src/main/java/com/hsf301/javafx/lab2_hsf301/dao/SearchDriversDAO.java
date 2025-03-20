package com.hsf301.javafx.lab2_hsf301.dao;

import com.hsf301.javafx.lab2_hsf301.entity.SearchDrivers;

import java.util.List;

public interface SearchDriversDAO {
    List<SearchDrivers> selectAll();
    SearchDrivers selectByEmail(String email);
    void delete(int id);
    void save(SearchDrivers searchDrivers);
    List<SearchDrivers> findSearchDrives(String email,String name,String status);
}
