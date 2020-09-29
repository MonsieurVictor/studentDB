package ru.com.samosvat.dao;

import org.apache.log4j.Logger;
import ru.com.samosvat.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends AbstractDao implements StudentDao {

    private static Logger log = Logger.getLogger(StudentDaoImpl.class.getName());

    public StudentDaoImpl() {
        super();
        this.setClassName(SubjectDaoImpl.class.getName());
    }

    public StudentDaoImpl(DbType dbType) {
        super(dbType);
        this.setClassName(SubjectDaoImpl.class.getName());
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_GET_ALL)) {
            log.info("get connection");
            log.info("get statement");
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                Student student = new Student(result.getInt(Student.ID_COLUMN),
                        result.getString(Student.NAME_COLUMN),
                        result.getString(Student.FATHERNAME_COLUMN),
                        result.getString(Student.SURNAME_COLUMN),
                        result.getString(Student.ADDRESS_COLUMN),
                        result.getString(Student.PHONE_NUMBER_COLUMN));
                students.add(student);
            }
        } catch (SQLException e) {
            log.error("error", e.getNextException());
        }
        return students;
    }

    @Override
    public Student getById(int id) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_GET_BY_ID)) {
            log.info("get connection");
            log.info("get statement");
            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                Student student = new Student(result.getInt(Student.ID_COLUMN),
                        result.getString(Student.NAME_COLUMN),
                        result.getString(Student.FATHERNAME_COLUMN),
                        result.getString(Student.SURNAME_COLUMN),
                        result.getString(Student.ADDRESS_COLUMN),
                        result.getString(Student.PHONE_NUMBER_COLUMN));
                return student;
            }
        } catch (SQLException e) {
            log.error("error", e);
        }
        return new Student();
    }

    @Override
    public void create(Student student) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_CREATE)) {
            log.info("get connection");
            log.info("get statement");
            stat.setString(1, student.getName());
            stat.setString(2, student.getFatherName());
            stat.setString(3, student.getSurName());
            stat.setString(4, student.getAddress());
            stat.setString(5, student.getPhoneNumber());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }

//    @Override
//    public void create(List<Student> students) {
//
//    }


    @Override
    public void update(Student student) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_UPDATE)) {
            log.info("get connection");
            log.info("get statement");
            stat.setString(1, student.getName());
            stat.setString(2, student.getFatherName());
            stat.setString(3, student.getSurName());
            stat.setString(4, student.getAddress());
            stat.setString(5, student.getPhoneNumber());
            stat.setInt(6, student.getId());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }

    @Override
    public void delete(Student student) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_DELETE)) {
            log.info("get connection");
            log.info("get statement");
            stat.setInt(1, student.getId());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }
}