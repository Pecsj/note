package domain;

public class IDCard {

    //自有属性
    private String cardid;
    private String address;
    //为了根据身份证号查询 身份证和人的信息
    //多添加一个关联属性
    private Person person;

    public IDCard() {}
    public IDCard(String cardid, String address, Person person) {
        this.cardid = cardid;
        this.address = address;
        this.person = person;
    }

    @Override
    public String toString() {
        return "IDCard{" +
                "cardid='" + cardid + '\'' +
                ", address='" + address + '\'' +
                ", person=" + person +
                '}';
    }

    public String getCardid() {
        return cardid;
    }
    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

}
