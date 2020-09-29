package ru.com.samosvat.dao;

import ru.com.samosvat.model.Grant;

import java.util.List;

public interface GrantDao {

    String SQL_GET_ALL = "SELECT * FROM grants";
    String SQL_GET_BY_ID = "SELECT * FROM grants WHERE id =?";
    String SQL_CREATE = "INSERT INTO grants (student_id, avg_mark, salary) VALUES (?,?,?)";
    String SQL_UPDATE = "UPDATE grants SET student_id =?, avg_mark =?, salary =? WHERE id =?";
    String SQL_DELETE = "DELETE FROM grants WHERE id = ?";

    List<Grant> getAll();
    Grant getById(int id);
    void create(Grant grant);
    void update(Grant grant);
    void delete(Grant grant);
}