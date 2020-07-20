package model.entity;

import model.exceptions.IncorrectData;

import java.util.Objects;

public class Address {
    private int id;
    private String city;
    private String street;
    private String house;
    private String flat;

    public Address(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws IncorrectData {
        if(city.matches("^\\D+$")) {
            this.city = city.toUpperCase();
        }else {
            throw new IncorrectData("Incorrect address");
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws IncorrectData {
        if(street.matches("^\\D+$")) {
            this.street = street;
        } else {
            throw new IncorrectData("Incorrect street");
        }
    }

    public String getHouse() {
            return house;
    }

    public void setHouse(String house) throws IncorrectData {
        if(house.matches("^\\d+\\D*$")) {
            this.house = house;
        } else {
            throw  new IncorrectData("Incorrect house");
        }
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) throws IncorrectData {
        if(house.matches("^\\d+\\D*$")) {
            this.flat = flat;
        } else {
            throw new IncorrectData("Incorrect flat");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                city.equals(address.city) &&
                street.equals(address.street) &&
                house.equals(address.house) &&
                flat.equals(address.flat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, house, flat);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}
