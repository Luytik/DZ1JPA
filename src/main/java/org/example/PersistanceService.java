package org.example;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class PersistanceService {
    //@PersistenceUnit(name = "JPATest")
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
    private PersistanceService(){

    }

    public static EntityManagerFactory getEmf(){
        return emf;
    }
}
