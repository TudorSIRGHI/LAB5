package model.market;

import model.market.Products;

public class EssentialOil extends Products {
    private String plant;

    public EssentialOil(String name, int price, double quantity, String plant) {
        super(name, price, quantity);
        this.plant = plant;
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

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }
}
