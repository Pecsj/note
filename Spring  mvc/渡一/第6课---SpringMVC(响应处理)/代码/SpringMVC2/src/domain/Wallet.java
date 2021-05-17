package domain;

//钱包类
public class Wallet {

    private String color;
    private Float money;

    public Wallet() {
    }

    public Wallet(String color, Float money) {
        this.color = color;
        this.money = money;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "color='" + color + '\'' +
                ", money=" + money +
                '}';
    }
}
