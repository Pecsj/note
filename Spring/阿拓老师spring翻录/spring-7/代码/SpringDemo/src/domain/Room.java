package domain;

public class Room {

    private String name;//机房房间号 属性
    private Computer computer;//机房中有一台电脑 属性 (has a) 聚合 组合 包含

    public Room() {}

    public Room(String name, Computer computer) {
        this.name = name;
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", computer=" + computer +
                '}';
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
}
