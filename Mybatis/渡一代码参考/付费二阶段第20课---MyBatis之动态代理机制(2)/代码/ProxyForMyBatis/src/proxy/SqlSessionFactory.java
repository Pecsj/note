package proxy;

public class SqlSessionFactory {

    public SqlSession openSession(){
        return new SqlSession();
    }
}
