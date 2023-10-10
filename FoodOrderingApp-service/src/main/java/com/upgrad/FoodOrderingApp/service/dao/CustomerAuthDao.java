package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerAuthDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * This method save token to customerauth table
     *
     * @param customerAuthEntity
     * @return
     */
    public CustomerAuthEntity createCustomerAuth(CustomerAuthEntity customerAuthEntity){
        entityManager.persist(customerAuthEntity);
        return customerAuthEntity;
    }

    /**
     * This method update customerauth table
     *
     * @param customerAuthEntity
     * @return
     */
    public CustomerAuthEntity updateCustomerAuth(CustomerAuthEntity customerAuthEntity){
        entityManager.merge(customerAuthEntity);
        return customerAuthEntity;
    }

    /**
     * This method customer auth table based on accesstoken
     * @param accessToken
     * @return
     */
    public CustomerAuthEntity getCustomerAuthByAccessToken(String accessToken){
        try{
            CustomerAuthEntity customerAuthEntity = entityManager.createNamedQuery("getCustomerAuthByAccessToken",CustomerAuthEntity.class).setParameter("access_Token",accessToken).getSingleResult();
            return customerAuthEntity;
        }catch (NoResultException nre){
            return null;
        }

    }

}
