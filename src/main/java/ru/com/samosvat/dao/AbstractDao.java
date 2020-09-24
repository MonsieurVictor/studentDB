package ru.com.samosvat.dao;

public class AbstractDao {
    private DbType dbType;
    private String className;

    public AbstractDao() {
        this.dbType = DbType.POSTGRESQL;
    }

    public AbstractDao(DbType dbType) {
        this.dbType = dbType;
    }

    protected String getClassName(){
        return className;
    }

    protected void setClassName(String text){
        this.className = text;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }
}
