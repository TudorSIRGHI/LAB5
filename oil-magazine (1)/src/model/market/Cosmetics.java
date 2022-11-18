package model.market;

import model.market.Products;

public class Cosmetics extends Products {
    private String smell;

    public Cosmetics(String name, int price, double quantity, String smell) {
        super(name, price, quantity);
        this.smell = smell;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public double getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(double quantity) {
        super.setQuantity(quantity);
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }
}
