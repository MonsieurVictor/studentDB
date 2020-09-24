package ru.com.samosvat.model;

import java.util.Objects;

public class Student {

    public static final String TABLE_NAME = "students";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String FATHERNAME_COLUMN = "father_name";
    public static final String SURNAME_COLUMN = "surname";
    public static final String ADDRESS_COLUMN = "address";
    public static final String PHONE_NUMBER_COLUMN = "phone";

    private int id;
    private String name;
    private String fatherName;
    private String surName;
    private String address;
    private String phoneNumber;

    public Student() {
        this.id = 0;
        this.name = "";
        this.fatherName = "";
        this.surName = "";
        this.address = "";
        this.phoneNumber = "";
    }

    public Student(String name, String fatherName, String surName, String address, String phoneNumber) {
        this.name = name;
        this.fatherName = fatherName;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Student(int id, String name, String fatherName, String surName, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getFatherName(), student.getFatherName()) &&
                Objects.equals(getSurName(), student.getSurName()) &&
                Objects.equals(getAddress(), student.getAddress()) &&
                Objects.equals(getPhoneNumber(), student.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFatherName(), getSurName(), getAddress(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", surName='" + surName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
