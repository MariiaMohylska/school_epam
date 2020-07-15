package model.logic;

import model.entity.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class NewStudent  {
    private  int id;
    private String surname;
    private String name;
    private String fatherName;
    private String classNumber;
    private String fileNumber;
    private LocalDate entryDate;
    private LocalDate gradDate;
    private  String phoneNumber;
    private String city;
    private String street;
    private String house;
    private String flat;
    private LocalDate Bday;


    public NewStudent (){

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public LocalDate getBday() {
        return Bday;
    }

    public void setBday(LocalDate bday) {
        Bday = bday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getGradDate() {
        return gradDate;
    }

    public void setGradDate(LocalDate gradDate) {
        this.gradDate = gradDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewStudent that = (NewStudent) o;
        return id == that.id &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(fatherName, that.fatherName) &&
                Objects.equals(classNumber, that.classNumber) &&
                Objects.equals(fileNumber, that.fileNumber) &&
                Objects.equals(entryDate, that.entryDate) &&
                Objects.equals(gradDate, that.gradDate) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(house, that.house) &&
                Objects.equals(flat, that.flat) &&
                Objects.equals(Bday, that.Bday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, fatherName, classNumber, fileNumber, entryDate, gradDate, phoneNumber, city, street, house, flat, Bday);
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", fileNumber='" + fileNumber + '\'' +
                ", entryDate=" + entryDate +
                ", gradDate=" + gradDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", flat='" + flat + '\'' +
                ", Bday=" + Bday +
                '}';
    }
}