package com.iktex.clients;

import com.iktex.utils.EntityManagerUtils;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class InsuranceApiClient {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    }
}
