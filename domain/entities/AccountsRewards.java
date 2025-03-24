package devcldkai.kaipizzas.domain.entities;

import devcldkai.kaipizzas.constant.RewardsStatus;

import java.time.LocalDate;

public class AccountsRewards {

    private String accountId;

    private Integer rewardId;

    private LocalDate exchangedDate;

    private String address;

    private String phoneNumber;

    private String status;

    public AccountsRewards() {
        this.status = RewardsStatus.PROCESSING;
    }

    public AccountsRewards(String accountId, Integer rewardId, LocalDate exchangedDate, String address, String phoneNumber) {
        this.accountId = accountId;
        this.rewardId = rewardId;
        this.exchangedDate = exchangedDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = RewardsStatus.PROCESSING;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDate getExchangedDate() {
        return exchangedDate;
    }

    public void setExchangedDate(LocalDate exchangedDate) {
        this.exchangedDate = exchangedDate;
    }

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
