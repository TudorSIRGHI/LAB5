package model.client;

public class CompanyClient extends Client{
    private boolean firstFreeProduct;

    public CompanyClient(int money, boolean isHappy, boolean firstFreeProduct) {
        super(money, isHappy);
        this.firstFreeProduct = firstFreeProduct;
    }

    public boolean isFirstFreeProduct() {
        return firstFreeProduct;
    }

    public void setFirstFreeProduct(boolean firstFreeProduct) {
        this.firstFreeProduct = firstFreeProduct;
    }
}
