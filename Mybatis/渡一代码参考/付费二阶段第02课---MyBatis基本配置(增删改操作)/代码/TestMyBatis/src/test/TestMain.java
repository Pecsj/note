package test;

import dao.StudentDao;

public class TestMain {

    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        dao.insert();
    }
}
