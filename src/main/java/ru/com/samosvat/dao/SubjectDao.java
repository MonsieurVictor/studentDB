package ru.com.samosvat.dao;

import ru.com.samosvat.model.Student;
import ru.com.samosvat.model.Subject;

import java.util.List;

public interface SubjectDao {
    String SQL_GET_ALL = "SELECT * FROM " + Subject.TABLE_NAME;
    String SQL_GET_BY_ID =  SQL_GET_ALL + " WHERE " +  Subject.ID_COLUMN + " = ?";
    String SQL_CREATE = "INSERT INTO " + Subject.TABLE_NAME
            + " (" + Student.NAME_COLUMN + ") "
            + "VALUES (?)";
    String SQL_UPDATE = "UPDATE " + Subject.TABLE_NAME + " SET "
            + Subject.NAME_COLUMN + "=? WHERE " + Subject.ID_COLUMN + "=?";

    String SQL_DELETE = "DELETE FROM " + Subject.TABLE_NAME
            + " WHERE " + Subject.ID_COLUMN + "=?";

    List<Subject> getAll();
    Subject getById(int id);
    void create(Subject subject);
    void update(Subject subject);
    void delete(Subject subject);
}
