package ru.com.samosvat.model;

import java.util.Objects;

public class Grant {
    public static final String TABLE_NAME = "grants";
    public static final String ID_COLUMN = "id";
    public static final String STUDENT_ID_COLUMN = "student_id";
    public static final String AVG_MARK_COLUMN = "avg_mark";
    public static final String GRANT_COLUMN = "salary";

    private int id;
    private int studentId;
    private int avgMark;
    private int grant;

    public Grant() {
    }

    public Grant(int studentId, int avgMark, int grant) {
        this.studentId = studentId;
        this.avgMark = avgMark;
        this.grant = grant;
    }

    public Grant(int id, int studentId, int avgMark, int grant) {
        this.id = id;
        this.studentId = studentId;
        this.avgMark = avgMark;
        this.grant = grant;
    }

    public static Grant getNewInstance(int id, int studentId, int avg_mark, int grant) {
        return new Grant(id, studentId, avg_mark, grant);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(int avgMark) {
        this.avgMark = avgMark;
    }

    public int getGrant() {
        return grant;
    }

    public void setGrant(int grant) {
        this.grant = grant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grant)) return false;
        Grant grants = (Grant) o;
        return getId() == grants.getId() &&
                getStudentId() == grants.getStudentId() &&
                getAvgMark() == grants.getAvgMark() &&
                getGrant() == grants.getGrant();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentId(), getAvgMark(), getGrant());
    }

    @Override
    public String toString() {
        return "Grants{" +
                "id=" + id +
                ", student_id=" + studentId +
                ", avg_mark=" + avgMark +
                ", grant=" + grant +
                '}';
    }
}
