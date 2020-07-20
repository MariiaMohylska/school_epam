package model.entity;

import model.exceptions.IncorrectData;

import java.util.Objects;

public class Phone {

    private int id;
    private String phone;
    private int idStudent;

    public Phone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws IncorrectData {
        if(phone.matches("[(]{1}\\d{3}[)]{1}\\d{3}[-]{1}\\d{2}[-]{1}\\d{2}")) {
            this.phone = phone;
        }else{
            throw new IncorrectData("Incorrect phone number or wrong format");
        }
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone1 = (Phone) o;
        return id == phone1.id &&
                idStudent == phone1.idStudent &&
                Objects.equals(phone, phone1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, idStudent);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", idStudent='" + idStudent + '\'' +
                '}';
    }
}
