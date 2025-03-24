package devcldkai.kaipizzas.domain.dto;


public class OrdersDashBoardDTO {
    private String customerName;

    private String phone;

    private Long id;

    private Long CustomerID;

    private String orderDate;

    private String requiredDate;

    private String shippedDate;

    private double freight;

    private String note;

    private double total;

    private String shipAddress;

    private String status;

    private String paymentMethod;

    public OrdersDashBoardDTO() {}

    public OrdersDashBoardDTO(Long customerID, String customerName, double freight, Long id, String note, String orderDate, String paymentMethod, String phone, String requiredDate, String shipAddress, String shippedDate, String status, double total) {
        CustomerID = customerID;
        this.customerName = customerName;
        this.freight = freight;
        this.id = id;
        this.note = note;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.phone = phone;
        this.requiredDate = requiredDate;
        this.shipAddress = shipAddress;
        this.shippedDate = shippedDate;
        this.status = status;
        this.total = total;
    }

    public Long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Long customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrdersDashBoard{" +
                "CustomerID=" + CustomerID +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
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
