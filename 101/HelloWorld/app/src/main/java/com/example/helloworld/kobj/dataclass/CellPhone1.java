package com.example.helloworld.kobj.dataclass;

import java.util.Objects;

public class CellPhone1 {
    String brand;
    Double price;

    public CellPhone1(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPhone1 that = (CellPhone1) o;
        return Objects.equals(brand, that.brand) &&
                Objects.equals(price, that.price);
    }

    @Override
    public String toString() {
        return "CellPhone1{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price);
    }
}
