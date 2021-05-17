package domain;

public class Logo {

    private String name;
    private String color;

    public Logo(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Logo{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String test(){
        System.out.println("logo对象中的测试方法");
        return "testLogo";
    }

    public String getName() {
        return name;
    }
}
