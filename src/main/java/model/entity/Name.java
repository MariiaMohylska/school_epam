package model.entity;

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
