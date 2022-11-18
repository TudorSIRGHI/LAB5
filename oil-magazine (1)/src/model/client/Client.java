package model.client;

public abstract class Client implements ClientInterf {
    private int money;
    private boolean isHappy;

    public Client(int money, boolean isHappy) {
        this.money = money;
        this.isHappy = isHappy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    @Override
    public void show(boolean happy) {
        if (isHappy){
            System.out.println("Client is happy");
        }else {
            System.out.println("Client is sad");
        }
    }
}
