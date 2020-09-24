package ru.com.samosvat.dao;

import org.apache.log4j.Logger;
import ru.com.samosvat.model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl extends AbstractDao implements SubjectDao {

    public SubjectDaoImpl() {
        super();
        this.setClassName(SubjectDaoImpl.class.getName());
    }

    public SubjectDaoImpl(DbType dbType) {
        super(dbType);
        this.setClassName(SubjectDaoImpl.class.getName());
    }

    private static Logger log = Logger.getLogger(SubjectDaoImpl.class.getName());

    @Override
    public List<Subject> getAll() {
        List<Subject> subjects = new ArrayList<>();
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_GET_ALL)) {
            log.info("get connection");
            log.info("get statement");
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                Subject subject = new Subject(result.getInt(Subject.ID_COLUMN),
                        result.getString(Subject.NAME_COLUMN));
            }
        } catch (SQLException e) {
            log.error("error", e);
        }
        return subjects;
    }

    @Override
    public Subject getById(int id) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_GET_BY_ID)
        ) {
            log.info("get connection");
            log.info("get statement");
            stat.setInt(1, id);
            log.info("1");
            ResultSet result = stat.executeQuery();
            log.info("2");
            while (result.next()) {
                log.info("3");
                Subject subject = new Subject(result.getInt(Subject.ID_COLUMN),
                        result.getString(Subject.NAME_COLUMN));
                return subject;
            }
        } catch (SQLException e) {
            log.error("error", e);
        }
        return new Subject();
    }

    @Override
    public void create(Subject subject) {
        try (
                Connection conn = DaoFactory.getConnection(this.getDbType());
                PreparedStatement stat = conn.prepareStatement(SQL_CREATE)) {
            log.info("get connection");
            log.info("get statement");
            stat.setString(1, subject.getName());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }

    @Override
    public void update(Subject subject) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_UPDATE)) {
            log.info("get connection");
            log.info("get statement");
            stat.setString(1, subject.getName());
            stat.setInt(2, subject.getId());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }

    @Override
    public void delete(Subject subject) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_DELETE)) {
            log.info("get connection");
            log.info("get statement");
            stat.setInt(1, subject.getId());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }
}