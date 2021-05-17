package dao;

import domain.Student;

public interface StudentDao {

    //持久层   数据读写    JDBC+
    public void insert(Student student);
    public void delete(Integer sid);
    public void update(Student student);
    public Student selectOne(Integer sid);
}
