package ru.com.samosvat;

import org.w3c.dom.ls.LSOutput;
import ru.com.samosvat.dao.*;
import ru.com.samosvat.model.*;

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
        Subject subjectEnglish = subjectDao.getById(1);
        Student studentVasIv = studentDao.getById(1);
        Mark markVasIvEng = new Mark(studentVasIv.getId(),subjectEnglish.getId(),10);
//        markDao.create(markVasIvEng);
        Student studentPetka = studentDao.getById(2);
        Mark markPetkaMath = new Mark(studentPetka.getId(),subjectMath.getId(),12);
//        markDao.create(markPetkaMath);
//        subjectDao.delete(subjectMath);
        markPetkaMath.setMark(2);
        markDao.update(markPetkaMath);
        markVasIvEng.setId(17);
        markDao.delete(markVasIvEng);
        GrantDao grantDao = new GrantDaoImpl(currentConnection);

        Grant grantVasIv = Grant.getNewInstance(0, studentVasIv.getId(), 9, 9000);
        System.out.println(studentVasIv);
        System.out.println(grantVasIv);

        // set to Vas Iv 10 mark in English
        // Petka - math - 12 mark
        // delete Subject Math
    }
}
