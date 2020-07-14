package model.logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class StudentShort {
    private int id;
    private String FileNumber;
    private String Surname;
    private String Name;
    private String FatherName;
    private String classNumber;
    private LocalDate BDay;
    private List<String> phone = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileNumber() {
        return FileNumber;
    }

    public void setFileNumber(String fileNumber) {
        FileNumber = fileNumber;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public LocalDate getBDay() {
        return BDay;
    }

    public void setBDay(LocalDate BDay) {
        this.BDay = BDay;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentShort that = (StudentShort) o;
        return id == that.id &&
                Objects.equals(FileNumber, that.FileNumber) &&
                Objects.equals(Surname, that.Surname) &&
                Objects.equals(Name, that.Name) &&
                Objects.equals(FatherName, that.FatherName) &&
                Objects.equals(classNumber, that.classNumber) &&
                Objects.equals(BDay, that.BDay) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FileNumber, Surname, Name, FatherName, classNumber, BDay, phone);
    }

    @Override
    public String toString() {
        return "StudentShort{" +
                "id=" + id +
                ", FileNumber='" + FileNumber + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", FatherName='" + FatherName + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", BDay=" + BDay +
                ", phone=" + phone +
                '}';
    }
}
