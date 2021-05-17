package domain;

public class User {

    private String uname;
    private String upassword;

    //设计一个普通的方法
    public String testGetValue(){
        System.out.println("testGetValue方法执行啦");
        return "zzt";
    }


    public User() {
    }

    public User(String uname, String upassword) {
        this.uname = uname;
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
}
