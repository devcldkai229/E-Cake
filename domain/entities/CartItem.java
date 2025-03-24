package devcldkai.kaipizzas.domain.entities;

public class CartItem {

    private Products products;

    private Suppliers suppliers;

    private Integer quantity;

    private String size;

    private Double total;

    public CartItem(Products products, Suppliers suppliers){
        this.products = products;
        this.suppliers = suppliers;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getTotal() {
        return Double.parseDouble(String.format("%.2f", quantity*(getPriceWithExtra())));
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getExtraPrice(){
        if(size.equals("M")) return 2.0;
        else if(size.equals("L")) return 2.0 + 2.0;
        else if(size.equals("XL")) return 2.0 + 2.0 + 1.0;
        else return 0.0;
    }

    public Double getPriceWithExtra(){
        return Double.parseDouble(String.format("%.2f",products.getPrice() + getExtraPrice()));
    }
}
