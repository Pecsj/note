package domain;

public class Computer {

    private String name;
    private int size;
    private Float price;
    private boolean status;
    private Logo logo;//聚合一个对象

    public Computer(String name, int size, Float price, boolean status, Logo logo) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.status = status;
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", status=" + status +
                ", logo=" + logo +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Float getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public Logo getLogo() {
        return logo;
    }
}
