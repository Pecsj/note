package domain;

public class User {

    private String uname;
    private String upassword;
    private String nickName;

    public User() {
    }

    public User(String uname, String upassword, String nickName) {
        this.uname = uname;
        this.upassword = upassword;
        this.nickName = nickName;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
