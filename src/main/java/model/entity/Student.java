package model.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Student {
    private int id;
    private int idName;
    private int idAddress;
    private int idClass;
    private LocalDate BDay;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdName() {
        return idName;
    }

    public void setIdName(int idName) {
        this.idName = idName;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public LocalDate getBDay() {
        return BDay;
    }

    public void setBDay(LocalDate BDay) {
        this.BDay = BDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                idName == student.idName &&
                idAddress == student.idAddress &&
                idClass == student.idClass &&
                Objects.equals(BDay, student.BDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idName, idAddress, idClass, BDay);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", idName=" + idName +
                ", idAddress=" + idAddress +
                ", idClass=" + idClass +
                ", BDay=" + BDay +
                '}';
    }
}
