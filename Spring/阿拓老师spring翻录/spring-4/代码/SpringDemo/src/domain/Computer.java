package domain;

public class Computer {

    private String brand;//电脑品牌   ThinkPad
    private String name;//电脑型号    S5
    private Float price;//电脑价格    8000

    public Computer() {
    }

    public Computer(String brand, String name, Float price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    public String getName() {
        return name;
    }
    public Float getPrice() {
        return price;
    }
}
