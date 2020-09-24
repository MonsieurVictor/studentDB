package ru.com.samosvat.dao;

import org.apache.log4j.Logger;
import ru.com.samosvat.model.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarkDaoImpl extends AbstractDao implements MarkDao {

    public static Logger log = Logger.getLogger(MarkDaoImpl.class.getName());

    public MarkDaoImpl() {
        super();
        this.setClassName(MarkDaoImpl.class.getName());
    }

    public MarkDaoImpl(DbType dbType) {
        super(dbType);
        this.setClassName(MarkDaoImpl.class.getName());
    }

    @Override
    public List<Mark> getAll() {
        List<Mark> marks = new ArrayList<>();
        try(Connection conn = DaoFactory.getConnection(this.getDbType());
            PreparedStatement stat = conn.prepareStatement(SQL_GET_ALL)) {
            log.info("create connection");
            log.info("create statement");
            ResultSet result = stat.executeQuery();
            while (result.next()){
                Mark mark = new Mark(result.getInt(Mark.ID_COLUMN),
                        result.getInt(Mark.STUDENT_ID_COLUMN),
                        result.getInt(Mark.SUBJECT_ID_COLUMN),
                        result.getInt(Mark.MARK_COLUMN));
                marks.add(mark);
            }
        } catch (SQLException e) {
            log.error("error", e);
        }
        return marks;
    }

    @Override
    public void create(Mark mark) {
        try(Connection conn = DaoFactory.getConnection(this.getDbType());
        PreparedStatement stat = conn.prepareStatement(SQL_CREATE)) {
            log.info("create connection");
            log.info("create statement");
            stat.setInt(1, mark.getStudentId());
            stat.setInt(2, mark.getSubjectId());
            stat.setInt(3, mark.getMark());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }
}
