package devcldkai.kaipizzas.domain.dto;

public class ProductsDashBoardDTO {

    private Long id;

    private String name;

    private String description;

    private Integer supplierId;

    private Integer categoryId;

    private String supplierName;

    private String categoryName;

    private long quantity;

    private double price;

    private String productImgUrl;

    public ProductsDashBoardDTO() {
    }

    public ProductsDashBoardDTO(Integer categoryId, String categoryName, String description,
                                Long id, String name, double price, String productImgUrl,
                                long quantity, Integer supplierId, String supplierName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.id = id;
        this.name = name;
        this.price = price;
        this.productImgUrl = productImgUrl;
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "ProductsDashBoard{" +
                "categoryId=" + categoryId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", productImgUrl='" + productImgUrl + '\'' +
                '}';
    }
}
