package devcldkai.kaipizzas.domain.dto;

public class OrderReportDTO {

    private String customerName;

    private String phone;

    private Long id;

    private Long customerID;

    private String orderDate;

    private String requiredDate;

    private String shippedDate;

    private double freight;

    private String note;

    private double total;

    private String shipAddress;

    private String status;

    private String paymentMethod;

    public OrderReportDTO() {
    }

    public OrderReportDTO(Long id, Long customerID, String customerName, String phone, String orderDate, String requiredDate, String shippedDate, double freight, String shipAddress, double total, String note, String status, String paymentMethod) {
        this.id = id;
        this.customerID = customerID;
        this.customerName = customerName;
        this.phone = phone;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.freight = freight;
        this.shipAddress = shipAddress;
        this.total = total;
        this.note = note;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
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

    @Override
    public String toString() {
        return "OrderReportDTO{" +
                "customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", customerID=" + customerID +
                ", orderDate='" + orderDate + '\'' +
                ", requiredDate='" + requiredDate + '\'' +
                ", shippedDate='" + shippedDate + '\'' +
                ", freight=" + freight +
                ", note='" + note + '\'' +
                ", total=" + total +
                ", shipAddress='" + shipAddress + '\'' +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
