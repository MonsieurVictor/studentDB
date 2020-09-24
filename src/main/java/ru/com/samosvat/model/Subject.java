package ru.com.samosvat.model;

import java.util.Objects;

public class Subject {
    public static final String TABLE_NAME = "subjects";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";

    private int id;
    private String name;

    public Subject() {
        this.name = "";
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getIdColumn() {
        return ID_COLUMN;
    }

    public static String getNameColumn() {
        return NAME_COLUMN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return getId() == subject.getId() &&
                Objects.equals(getName(), subject.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
