package model.entity;

import java.util.Objects;

public class Classes {
    private int id;
    private String classes;

    public Classes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes1 = (Classes) o;
        return id == classes1.id &&
                Objects.equals(classes, classes1.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classes);
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", classes='" + classes + '\'' +
                '}';
    }
}
