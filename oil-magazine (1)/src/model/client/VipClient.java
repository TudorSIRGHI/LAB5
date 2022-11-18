package model.client;

public class VipClient extends Client{
    private int discount;

    public VipClient(int money, boolean isHappy, int discount) {
        super(money, isHappy);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
