package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.AccountsRewards;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsRewardsMappers {

    private AccountsRewardsMappers() {}

    public static AccountsRewards mapToAccountsRewards(ResultSet rs) throws SQLException {
        AccountsRewards accountsRewards = new AccountsRewards();
        accountsRewards.setAccountId(rs.getString("accountid"));
        accountsRewards.setRewardId(rs.getInt("rewardid"));
        accountsRewards.setExchangedDate(rs.getDate("exchangedDate").toLocalDate());
        accountsRewards.setAddress(rs.getString("address"));
        accountsRewards.setPhoneNumber(rs.getString("phone"));
        accountsRewards.setStatus(rs.getString("status"));
        return accountsRewards;
    }
}
