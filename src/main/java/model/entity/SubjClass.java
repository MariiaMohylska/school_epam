package model.entity;

import java.util.Objects;

public class SubjClass {
    private int id;
    private int idSubject;
    private int idClass;

    public SubjClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjClass subjClass = (SubjClass) o;
        return id == subjClass.id &&
                idSubject == subjClass.idSubject &&
                idClass == subjClass.idClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSubject, idClass);
    }

    @Override
    public String toString() {
        return "SubjClass{" +
                "id=" + id +
                ", idSubject=" + idSubject +
                ", idClass=" + idClass +
                '}';
    }
}
