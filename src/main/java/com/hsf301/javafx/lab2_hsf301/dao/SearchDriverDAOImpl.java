package com.hsf301.javafx.lab2_hsf301.dao;

import com.hsf301.javafx.lab2_hsf301.entity.SearchDrivers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SearchDriverDAOImpl implements SearchDriversDAO{
    private EntityManagerFactory entityManagerFactory;
    public SearchDriverDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public List<SearchDrivers> selectAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("from SearchDrivers");
            List<SearchDrivers> list = query.getResultList();
            entityManager.getTransaction().commit();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SearchDrivers selectByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("from SearchDrivers where email = :email",SearchDrivers.class);
            query.setParameter("email", email);
            List<SearchDrivers> list = query.getResultList();
            entityManager.getTransaction().commit();
            return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(SearchDrivers searchDrivers) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(searchDrivers);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SearchDrivers> findSearchDrives(String email, String name, String status) {
        StringBuilder queryStr = new StringBuilder("SELECT a FROM  SearchDrivers  a WHERE 1=1");
        if (email != null && !email.trim().isEmpty()) {
            queryStr.append(" AND a.email LIKE :email");
        }
        if (name != null && !name.trim().isEmpty()) {
            queryStr.append(" AND a.agentName LIKE :agentName");
        }
        if (status != null && !status.trim().isEmpty()) {
            queryStr.append(" AND a.status LIKE :status"); // Sử dụng LIKE cho status
        }
        queryStr.append(" ORDER BY a.registerDate ASC, a.Agent_Name ASC");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            TypedQuery<SearchDrivers> query = entityManager.createQuery(queryStr.toString(), SearchDrivers.class);
            if (email != null && !email.trim().isEmpty()) {
                query.setParameter("email", "%" + email + "%");
            }
            if (name != null && !name.trim().isEmpty()) {
                query.setParameter("agentName", "%" + name + "%");
            }
            if (status != null && !status.trim().isEmpty()) {
                query.setParameter("status", "%" + status + "%");
            }
            List<SearchDrivers> result = query.getResultList();
            entityManager.getTransaction().commit();
            return result;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi tìm kiếm đại lý", e);
        } finally {
            entityManager.close();
        }
    }
}
