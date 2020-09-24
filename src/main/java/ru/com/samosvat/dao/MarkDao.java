package ru.com.samosvat.dao;

import ru.com.samosvat.model.Mark;

import java.util.List;

public interface MarkDao {
    String SQL_GET_ALL = "SELECT * FROM " + Mark.TABLE_NAME;

    String SQL_CREATE = "INSERT INTO " + Mark.TABLE_NAME
            + " (" + Mark.STUDENT_ID_COLUMN + ", "
            + Mark.SUBJECT_ID_COLUMN + ", "
            + Mark.MARK_COLUMN + ")"
            + " VALUES (?,?,?)";

    List<Mark> getAll();
    void create(Mark mark);
}
