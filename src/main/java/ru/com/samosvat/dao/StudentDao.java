package ru.com.samosvat.dao;

import ru.com.samosvat.model.Student;

import java.util.List;

public interface StudentDao {

    String SQL_GET_ALL = "SELECT * FROM " + Student.TABLE_NAME;
    String SQL_GET_BY_ID = SQL_GET_ALL + " WHERE " + Student.ID_COLUMN;
    String SQL_CREATE = "INSERT INTO " + Student.TABLE_NAME
            + " (" + Student.NAME_COLUMN + ", "
            + Student.FATHERNAME_COLUMN + ", "
            + Student.SURNAME_COLUMN + ", "
            + Student.ADDRESS_COLUMN + ", "
            + Student.PHONE_NUMBER_COLUMN + ") "
            + "VALUES (?, ?, ?, ?, ?)";

    String SQL_UPDATE = "UPDATE " + Student.TABLE_NAME + " SET "
            + Student.NAME_COLUMN + " =?, "
            + Student.FATHERNAME_COLUMN + " =?, "
            + Student.SURNAME_COLUMN + " =?, "
            + Student.ADDRESS_COLUMN + " =?, "
            + Student.PHONE_NUMBER_COLUMN + " =?"
            + " WHERE " + Student.ID_COLUMN + " =?";

    String SQL_DELETE = "DELETE FROM " + Student.TABLE_NAME
            + " WHERE " + Student.ID_COLUMN + " =?";

    List<Student> getAll();
    Student getById(int id);
    void create(Student student);
    void update(Student student);
    void delete(Student student);
}
