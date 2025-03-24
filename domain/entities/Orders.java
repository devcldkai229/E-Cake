package devcldkai.kaipizzas.domain.entities;

import java.time.LocalDateTime;

public class Orders {

    private Long id;

    private Long CustomerID;

    private LocalDateTime orderDate;

    private LocalDateTime requiredDate;

    private LocalDateTime shippedDate;

    private double freight;

    private String note;

    private double total;

    private String shipAddress;

    private String status;

    private String paymentMethod;

    public Orders(){}

    public Orders(LocalDateTime orderDate, LocalDateTime requiredDate, double freight, String note, double total, String shipAddress, String status, String paymentMethod) {
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.freight = freight;
        this.note = note;
        this.total = total;
        this.shipAddress = shipAddress;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Long customerID) {
        CustomerID = customerID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDateTime requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", CustomerID=" + CustomerID +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", freight=" + freight +
                ", note='" + note + '\'' +
                ", total=" + total +
                ", shipAddress='" + shipAddress + '\'' +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
