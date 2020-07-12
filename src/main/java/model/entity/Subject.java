package model.entity;

import java.util.Objects;

public class Subject {

    private int id;
    private String subjName;

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjName() {
        return subjName;
    }

    public void setSubjName(String subjName) {
        this.subjName = subjName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id &&
                Objects.equals(subjName, subject.subjName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjName);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjName='" + subjName + '\'' +
                '}';
    }
}
