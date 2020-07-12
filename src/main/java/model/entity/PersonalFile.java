package model.entity;

import java.util.Date;
import java.util.Objects;

public class PersonalFile {

    private int id;
    private String number;
    private int idStudent;
    private Date entryDate;
    private Date gradDate;

    public PersonalFile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getGradDate() {
        return gradDate;
    }

    public void setGradDate(Date gradDate) {
        this.gradDate = gradDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalFile that = (PersonalFile) o;
        return id == that.id &&
                idStudent == that.idStudent &&
                Objects.equals(number, that.number) &&
                Objects.equals(entryDate, that.entryDate) &&
                Objects.equals(gradDate, that.gradDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, idStudent, entryDate, gradDate);
    }

    @Override
    public String toString() {
        return "PersonalFile{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", idStudent=" + idStudent +
                ", entryDate=" + entryDate +
                ", gradDate=" + gradDate +
                '}';
    }
}
