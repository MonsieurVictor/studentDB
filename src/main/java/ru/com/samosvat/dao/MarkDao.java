package ru.com.samosvat.dao;

import ru.com.samosvat.model.Mark;

import java.util.List;

public interface MarkDao {
    String SQL_GET_ALL = "SELECT * FROM " + Mark.TABLE_NAME;
    String SQL_GET_BY_ID = "SELECT * FROM marks WHERE id = ?";
    String SQL_CREATE = "INSERT INTO " + Mark.TABLE_NAME
            + " (" + Mark.STUDENT_ID_COLUMN + ", "
            + Mark.SUBJECT_ID_COLUMN + ", "
            + Mark.MARK_COLUMN + ")"
            + " VALUES (?,?,?)";
    String SQL_UPDATE = "UPDATE marks SET student_id =?, subject_id =?, mark =? WHERE id =?";
    String SQL_DELETE = "DELETE FROM marks WHERE id =?";

    List<Mark> getAll();
    void create(Mark mark);
    void update(Mark mark);
    void delete(Mark mark);
}
