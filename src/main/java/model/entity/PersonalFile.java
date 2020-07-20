package model.entity;

import model.exceptions.IncorrectData;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class PersonalFile {

    private int id;
    private String number;
    private int idStudent;
    private LocalDate entryDate;
    private LocalDate gradDate;

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

    public void setNumber(String number) throws IncorrectData {
        if(number.matches("\\d{4}[/]\\d\\b")) {
            this.number = number;
        } else {
            throw new IncorrectData("Incorrect personal file number");
        }
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
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
