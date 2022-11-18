package model.market;

import model.market.Products;

public class Tea extends Products {
    private String ingredient;

    public Tea(String name, int price, double quantity, String ingredient) {
        super(name, price, quantity);
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
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
}
