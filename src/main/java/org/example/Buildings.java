package org.example;


import javax.persistence.*;

@Entity
@Table(name = "Apartments")
public class Buildings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String district;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private double area;
    @Column(nullable = false)
    private short quantityOfRooms;
    private double price;

    public Buildings(){

    }

    public Buildings(String district, String address, double area, short quantityOfRooms, double price) {
        this.district = district;
        this.address = address;
        this.area = area;
        this.quantityOfRooms = quantityOfRooms;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public short getQuantityOfRooms() {
        return quantityOfRooms;
    }

    public void setQuantityOfRooms(short quantityOfRooms) {
        this.quantityOfRooms = quantityOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Buildings{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                String.format(", area= %.2f", area) +
                ", quantityOfRooms=" + quantityOfRooms +
                ", price=" + price +
                '}';
    }
}
