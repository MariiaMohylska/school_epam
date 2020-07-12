package model.entity;

import java.util.Objects;

public class Mark {
    private int id;
    private int idSubjClass;
    private int idStudent;
    private int mark;

    public Mark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSubjClass() {
        return idSubjClass;
    }

    public void setIdSubjClass(int idSubjClass) {
        this.idSubjClass = idSubjClass;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return id == mark1.id &&
                idSubjClass == mark1.idSubjClass &&
                idStudent == mark1.idStudent &&
                mark == mark1.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSubjClass, idStudent, mark);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", idSubjClass=" + idSubjClass +
                ", idStudent=" + idStudent +
                ", mark=" + mark +
                '}';
    }
}
