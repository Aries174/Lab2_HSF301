package com.hsf301.javafx.lab2_hsf301.service;

import com.hsf301.javafx.lab2_hsf301.dao.SearchDriverDAOImpl;
import com.hsf301.javafx.lab2_hsf301.dao.SearchDriversDAO;
import com.hsf301.javafx.lab2_hsf301.dto.SearchDriversDTO;
import com.hsf301.javafx.lab2_hsf301.entity.SearchDrivers;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchDriversImpl implements SearchDriversService {
    private final SearchDriversDAO searchDriversDAO;

    public SearchDriversImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAs");
        searchDriversDAO = new SearchDriverDAOImpl(emf);
    }

    @Override
    public void createSearchDriver(String name, String email, String address, String password) {
        SearchDrivers searchDrivers = new SearchDrivers();
        searchDrivers.setAgentName(name);
        searchDrivers.setEmail(email);
        searchDrivers.setAddress(address);
        searchDrivers.setPassword(password);
        searchDrivers.setAccountBalance(0.0);
        searchDrivers.setStatus("Active");
        searchDrivers.setRegisterDate(new Date());
        searchDriversDAO.save(searchDrivers);
    }

    @Override
    public List<SearchDriversDTO> getAllSearchDrivers() {
        List<SearchDriversDTO> list=new ArrayList<>();
        List<SearchDrivers> searchDrivers=searchDriversDAO.selectAll();
        for(SearchDrivers searchDriver:searchDrivers){
            SearchDriversDTO dto=new SearchDriversDTO();
            dto.setAgentID(searchDriver.getAgentID());
            dto.setAgentName(searchDriver.getAgentName());
            dto.setEmail(searchDriver.getEmail());
            dto.setAddress(searchDriver.getAddress());
            dto.setPassword(searchDriver.getPassword());
            dto.setAccountBalance(searchDriver.getAccountBalance());
            dto.setRegisterDate(searchDriver.getRegisterDate());
            dto.setStatus(searchDriver.getStatus());
            list.add(dto);
        }
        return list;
    }

    @Override
    public SearchDriversDTO getSearchDriver(String email, String password) {
        SearchDrivers searchDriver=searchDriversDAO.selectByEmail(email);
        if(searchDriver!=null && searchDriver.getPassword().equals(password)){
            SearchDriversDTO dto=new SearchDriversDTO();
            dto.setAgentID(searchDriver.getAgentID());
            dto.setAgentName(searchDriver.getAgentName());
            dto.setEmail(searchDriver.getEmail());
            dto.setAddress(searchDriver.getAddress());
            dto.setPassword(searchDriver.getPassword());
            dto.setAccountBalance(searchDriver.getAccountBalance());
            dto.setRegisterDate(searchDriver.getRegisterDate());
            dto.setStatus(searchDriver.getStatus());
            return dto;
        }
        return null;
    }

    @Override
    public List<SearchDriversDTO> getSearchDrivers(String email, String name, String status) {
        List<SearchDriversDTO> list=new ArrayList<>();
        List<SearchDrivers> searchDrivers=searchDriversDAO.findSearchDrives(email, name, status);
        for(SearchDrivers searchDriver:searchDrivers){
            SearchDriversDTO dto=new SearchDriversDTO();
            dto.setAgentID(searchDriver.getAgentID());
            dto.setAgentName(searchDriver.getAgentName());
            dto.setEmail(searchDriver.getEmail());
            dto.setAddress(searchDriver.getAddress());
            dto.setPassword(searchDriver.getPassword());
            dto.setAccountBalance(searchDriver.getAccountBalance());
            dto.setRegisterDate(searchDriver.getRegisterDate());
            dto.setStatus(searchDriver.getStatus());
            list.add(dto);
        }
        return list;
    }
}
