package org.example;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Filter.insertTenRandomAppartments();

        System.out.println("=======ViewAllApartments================");
        List<Buildings> l = Filter.viewApartments();
        for(Buildings b: l){
            System.out.println(b);
        }

        System.out.println("=======FilterPriceMore================");
        List<Buildings> l2 = Filter.filterPriceMore(100000.0);

        for(Buildings b: l2){
            System.out.println(b);
        }

        System.out.println("=======FilterMaxPrice================");
        System.out.println(Filter.filterGetMaxPrice());

        System.out.println("=======FilterByDistrict================");
        List<Buildings> l3 = Filter.filterGetAppartmentOnDistrict("2");
        for(Buildings b: l3){
            System.out.println(b);
        }


    }
}
