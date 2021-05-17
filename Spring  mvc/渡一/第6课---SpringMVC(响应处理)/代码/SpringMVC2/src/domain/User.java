package domain;

import java.util.Date;
import java.util.List;

public class User {

    private String name;
    private Integer age;
    private String sex;
    private Date birthday;
    //钱包属性
    private List<Wallet> list;

    public User() {
    }

    public User(String name, Integer age, String sex, Date birthday, List<Wallet> list) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Wallet> getList() {
        return list;
    }

    public void setList(List<Wallet> list) {
        this.list = list;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", list=" + list +
                '}';
    }
}
