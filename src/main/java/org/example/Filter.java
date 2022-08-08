package org.example;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filter {
    public static List<Buildings> viewApartments() {
        EntityManager em = PersistanceService.getEmf().createEntityManager();
        Query query = em.createQuery("select b from Buildings b");
        List<Buildings> buildingsList = query.getResultList();
        em.close();
        return buildingsList;
    }

    public static List<Buildings> filterPriceMore(double d) {
        EntityManager em = PersistanceService.getEmf().createEntityManager();
        Query query = em.createQuery("select b from Buildings b where b.price > :d");
        query.setParameter("d", d);
        List<Buildings> buildingsList = query.getResultList();
        em.close();
        return buildingsList;
    }

    public static double filterGetMaxPrice() {
        EntityManager em = PersistanceService.getEmf().createEntityManager();
        Query query = em.createQuery("SELECT MAX(b.price) from Buildings b");
        Double result = (Double) query.getSingleResult();
        em.close();
        return result;
    }

    public static List<Buildings> filterGetAppartmentOnDistrict(String district){
        List<Buildings> buildingsList = new ArrayList<>();
        EntityManager em = PersistanceService.getEmf().createEntityManager();
        try {
            Query query = em.createQuery("select c from Buildings c where c.district = :d");
            query.setParameter("d", district);
            buildingsList = (List<Buildings>) query.getResultList();
        } catch (NoResultException noResultException){
            System.out.println("Appartments was not found in the district");
        }
        return buildingsList;
    }

    public static void insertTenRandomAppartments() {
        String[] streets = {"Юності, 20", "Космонавтів, 8", "Жовтнева, 17", "Миру, 147", "Шевченка, 33"};
        List<Buildings> buildingsList = new ArrayList<>();
        EntityManager em = PersistanceService.getEmf().createEntityManager();
        Random random = new Random();
        em.getTransaction().begin();
        for(int i = 0; i < 10; i++) {
            Buildings buildings = new Buildings(
                    String.valueOf(random.nextInt(10)),
                    streets[random.nextInt(streets.length)],
                    random.nextDouble(100) + 100,
                    (short) random.nextInt(6),
                    random.nextInt(20000) + 95000
            );
            System.out.println(buildings.toString());
            buildingsList.add(buildings);
            em.persist(buildings);
        }
        em.getTransaction().commit();
        em.close();
        System.out.println("=============was added next apartment==================================");
        for(Buildings b : buildingsList){
            System.out.println(b.toString());
        }
    }
}
