package devcldkai.kaipizzas.domain.dto;

public class OrderedUserDTO {

    private Long id;

    private String orderedDate;

    private String requiredDate;

    private String shippedDate;

    private Double total;

    private String status;

    private String accountId;

    public OrderedUserDTO() {}

    public OrderedUserDTO(long id, String orderedDate, String requiredDate, String shippedDate, Double total, String status, String accountId) {
        this.id = id;
        this.orderedDate = orderedDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.total = total;
        this.status = status;
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderedUser{" +
                "accountId='" + accountId + '\'' +
                ", id=" + id +
                ", orderedDate='" + orderedDate + '\'' +
                ", requiredDate='" + requiredDate + '\'' +
                ", shippedDate='" + shippedDate + '\'' +
                ", total=" + total +
                ", status='" + status + '\'' +
                '}';
    }
}
