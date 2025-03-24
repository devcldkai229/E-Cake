package devcldkai.kaipizzas.domain.dto;

public class AccountsRewardsDashBoardDTO {

    private String accountId;

    private int rewardId;

    private String giftName;

    private String exchangeDate;

    private String address;

    private String username;

    private String fullName;

    private String phone;

    private String email;

    private String status;

    private String image;

    public AccountsRewardsDashBoardDTO() {}

    public AccountsRewardsDashBoardDTO(String accountId, int rewardId, String username, String fullName, String phone, String exchangeDate, String address, String email) {
        this.accountId = accountId;
        this.rewardId = rewardId;
        this.username = username;
        this.fullName = fullName;
        this.phone = phone;
        this.exchangeDate = exchangeDate;
        this.address = address;
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AccountsRewardsDashBoard{" +
                "accountId='" + accountId + '\'' +
                ", rewardId=" + rewardId +
                ", exchangeDate='" + exchangeDate + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
