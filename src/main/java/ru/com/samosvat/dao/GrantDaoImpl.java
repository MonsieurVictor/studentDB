package ru.com.samosvat.dao;

import org.apache.log4j.Logger;
import ru.com.samosvat.model.Grant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrantDaoImpl extends AbstractDao implements GrantDao {
    private static Logger log = Logger.getLogger(GrantDaoImpl.class.getName());

    public GrantDaoImpl(DbType currentConnection) {
        this.setDbType(currentConnection);
    }

    @Override
    public List<Grant> getAll() {
        List<Grant> grants = new ArrayList<>();
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_GET_ALL)) {
            log.info("create connection");
            log.info("create statement");
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                Grant grant = new Grant(result.getInt(Grant.ID_COLUMN),
                        result.getInt(Grant.STUDENT_ID_COLUMN),
                        result.getInt(Grant.AVG_MARK_COLUMN),
                        result.getInt(Grant.GRANT_COLUMN));
                grants.add(grant);
            }
        } catch (SQLException e) {
            log.error("error", e);
        }
        return grants;
    }

    @Override
    public Grant getById(int id) {
        try (Connection conn = DaoFactory.getConnection(this.getDbType());
             PreparedStatement stat = conn.prepareStatement(SQL_GET_BY_ID)) {
            log.info("create connection");
            log.info("create statement");
            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                return Grant.getNewInstance(id,
                        result.getInt(Grant.STUDENT_ID_COLUMN),
                        result.getInt(Grant.AVG_MARK_COLUMN),
                        result.getInt(Grant.GRANT_COLUMN));
            }
        } catch (SQLException e) {
            log.error("error", e);
        }
        return new Grant();
    }

    @Override
    public void create(Grant grant) {
        try (Connection conn = DaoFactory.getConnection(DbType.POSTGRESQL);
             PreparedStatement stat = conn.prepareStatement(SQL_CREATE)) {
            log.info("create connection");
            log.info("create statement");
            stat.setInt(1, grant.getStudentId());
            stat.setInt(2, grant.getAvgMark());
            stat.setInt(3, grant.getGrant());
            stat.executeUpdate();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }

    @Override
    public void update(Grant grant) {
        try (Connection conn = DaoFactory.getConnection(DbType.POSTGRESQL);
             PreparedStatement stat = conn.prepareStatement(SQL_UPDATE)) {
            log.info("create connection");
            log.info("create statement");
            stat.setInt(1, grant.getStudentId());
            stat.setInt(2, grant.getAvgMark());
            stat.setInt(3, grant.getGrant());
            stat.setInt(4, grant.getId());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }

    @Override
    public void delete(Grant grant) {
        try (Connection conn = DaoFactory.getConnection(DbType.POSTGRESQL);
             PreparedStatement stat = conn.prepareStatement(SQL_DELETE)) {
            log.info("create connection");
            log.info("create statement");
            stat.setInt(1, grant.getId());
            stat.execute();
        } catch (SQLException e) {
            log.error("error", e);
        }
    }
}
