package ru.com.samosvat.model;

import java.util.Objects;

public class Mark {
    public static final String TABLE_NAME = "marks";
    public static final String ID_COLUMN = "id";
    public static final String STUDENT_ID_COLUMN = "student_id";
    public static final String SUBJECT_ID_COLUMN = "subject_id";
    public static final String MARK_COLUMN = "mark";

    private int id;
    private int studentId;
    private int subjectId;
    private int mark;

    public Mark() {
    }

    public Mark(int studentId, int subjectId, int mark) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.mark = mark;
    }

    public Mark(int id, int studentId, int subjectId, int mark) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.mark = mark;
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        Mark mark1 = (Mark) o;
        return id == mark1.id &&
                studentId == mark1.studentId &&
                subjectId == mark1.subjectId &&
                mark == mark1.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, subjectId, mark);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                ", mark=" + mark +
                '}';
    }
}
