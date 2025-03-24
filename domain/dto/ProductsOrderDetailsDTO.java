package devcldkai.kaipizzas.domain.dto;

public class ProductsOrderDetailsDTO {

    private String name;

    private String categoryName;

    private String supplierName;

    private String size;

    private double unitPrice;

    private int quantity;

    private double total;

    private String imgUrl;

    public ProductsOrderDetailsDTO() {}

    public ProductsOrderDetailsDTO(String name, String categoryName, String supplierName, String size, double unitPrice, int quantity, double total, String imgUrl) {
        this.name = name;
        this.categoryName = categoryName;
        this.supplierName = supplierName;
        this.size = size;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ProductsOrderDetails{" +
                "name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", size='" + size + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}



//
//package devcldkai.kaipizzas.domain;
//
//public class ProductsOrderDetails {
//
//    private OrderDetails orderDetails;
//
//    private Products products;
//
//    private Categories category;
//
//    private Suppliers supplier;
//
//    private String name;
//
//    private String categoryName;
//
//    private String supplierName;
//
//    private String size;
//
//    private double unitPrice;
//
//    private int quantity;
//
//    private double total;
//
//    public ProductsOrderDetails() {}
//
//    public ProductsOrderDetails(OrderDetails orderDetails, Products products, Categories category, Suppliers supplier) {
//        this.orderDetails = orderDetails;
//        this.products = products;
//        this.category = category;
//        this.supplier = supplier;
//    }
//
//    public OrderDetails getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(OrderDetails orderDetails) {
//        this.orderDetails = orderDetails;
//    }
//
//    public Products getProducts() {
//        return products;
//    }
//
//    public void setProducts(Products products) {
//        this.products = products;
//    }
//
//    public Categories getCategories() {
//        return category;
//    }
//
//    public void setCategories(Categories category) {
//        this.category = category;
//    }
//
//    public Suppliers getSuppliers() {
//        return supplier;
//    }
//
//    public void setSuppliers(Suppliers supplier) {
//        this.supplier = supplier;
//    }
//}

