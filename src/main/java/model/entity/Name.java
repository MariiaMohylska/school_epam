package model.entity;

import model.exceptions.IncorrectData;

import java.util.Objects;

public class Name {

    private int id;
    private String surname;
    private String name;
    private String fatherName;

    public Name() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws IncorrectData {
        if(surname.matches("^\\D+$")) {
            this.surname = surname.toUpperCase();
        } else {
            throw new IncorrectData("Incorrect surname");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IncorrectData {
        if(surname.matches("^\\D+$")) {
            this.name = name;
        } else {
            throw  new IncorrectData("Incorrect name");
        }
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) throws IncorrectData {
        if(surname.matches("^\\D+$")) {
            this.fatherName = fatherName;
        } else {
            throw new IncorrectData("Incorrect father name");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return id == name1.id &&
                Objects.equals(surname, name1.surname) &&
                Objects.equals(name, name1.name) &&
                Objects.equals(fatherName, name1.fatherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, fatherName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }
}
