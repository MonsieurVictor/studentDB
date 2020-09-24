package ru.com.samosvat;

import ru.com.samosvat.dao.*;
import ru.com.samosvat.model.Mark;
import ru.com.samosvat.model.Student;
import ru.com.samosvat.model.Subject;

public class Main {
    private static final DbType currentConnection;
    static {
        currentConnection = DbType.POSTGRESQL;
    }

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl(currentConnection);
        SubjectDao subjectDao = new SubjectDaoImpl(currentConnection);
        MarkDao markDao = new MarkDaoImpl(currentConnection);
        Subject subjectMath = subjectDao.getById(3);
//        Subject subjectEnglish = subjectDao.getById(1);
//        Student studentVasIv = studentDao.getById(1);
//        Mark markVasIvEng = new Mark(studentVasIv.getId(),subjectEnglish.getId(),10);
//        markDao.create(markVasIvEng);
//        Student studentPetka = studentDao.getById(2);
//        Mark markPetkaMath = new Mark(studentPetka.getId(),subjectMath.getId(),12);
//        markDao.create(markPetkaMath);
//        subjectDao.delete(subjectMath);
        // set to Vas Iv 10 mark in English
        // Petka - math - 12 mark
        // delete Subject Math
    }
}
