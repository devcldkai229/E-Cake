package devcldkai.kaipizzas.domain.entities;

public class OrderDetails {

    private Long orderId;

    private Long productId;

    private Double price;

    private String size;

    private int quantity;

    private Double total;

    public OrderDetails() {
    }

    public OrderDetails(Long orderId, Long productId, String size, double price, int quantity, double total) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
