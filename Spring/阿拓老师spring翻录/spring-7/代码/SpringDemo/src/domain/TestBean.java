package domain;

import java.util.Map;

public class TestBean {

    private String name;
    private Computer computer;
    private Map<String,Computer> map;//内部类  Entry(key,value)
    //private List<Map<String,String>> list;

    public TestBean() {
    }

    public TestBean(String name, Computer computer, Map<String, Computer> map) {
        this.name = name;
        this.computer = computer;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Map<String, Computer> getMap() {
        return map;
    }

    public void setMap(Map<String, Computer> map) {
        this.map = map;
    }
}
