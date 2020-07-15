package model.logic;

import model.entity.*;

import java.time.LocalDate;
import java.util.Objects;

public class NewStudentObject {
    private  int id;
    Name name = new Name();
    Classes classes = new Classes();
    PersonalFile personalFile = new PersonalFile();
    Phone phone = new Phone();
    Address address = new Address();
    private LocalDate Bday;

    public NewStudentObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public PersonalFile getPersonalFile() {
        return personalFile;
    }

    public void setPersonalFile(PersonalFile personalFile) {
        this.personalFile = personalFile;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBday() {
        return Bday;
    }

    public void setBday(LocalDate bday) {
        Bday = bday;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewStudentObject that = (NewStudentObject) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(classes, that.classes) &&
                Objects.equals(personalFile, that.personalFile) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(Bday, that.Bday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, classes, personalFile, phone, address, Bday);
    }

    @Override
    public String toString() {
        return "NewStudentObject{" +
                "id=" + id +
                ", name=" + name +
                ", classes=" + classes +
                ", personalFile=" + personalFile +
                ", phone=" + phone +
                ", address=" + address +
                ", Bday=" + Bday +
                '}';
    }
}
