package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.domain.entities.AccountsRewards;
import devcldkai.kaipizzas.mapper.AccountsRewardsMappers;
import devcldkai.kaipizzas.repository.AccountsRewardsRepository;
import devcldkai.kaipizzas.repository.queries.AccountRewardQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountsRewardsRepositoryImpl implements AccountsRewardsRepository {
    @Override
    public List<AccountsRewards> selectAll() {
        List<AccountsRewards> accountsRewards = new ArrayList<AccountsRewards>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(AccountRewardQueries.SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                accountsRewards.add(AccountsRewardsMappers.mapToAccountsRewards(resultSet));
            }
            return accountsRewards;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return accountsRewards;
    }

    @Override
    public Optional<AccountsRewards> selectById(String accountId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(AccountRewardQueries.SELECT_BY_ACCOUNT_ID);
            preparedStatement.setString(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    return Optional.of(AccountsRewardsMappers.mapToAccountsRewards(resultSet));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<AccountsRewards> selectByUsername(String username) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(AccountRewardQueries.SELECT_BY_ACCOUNT_USERNAME);
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    return Optional.of(AccountsRewardsMappers.mapToAccountsRewards(resultSet));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(AccountsRewards accountsRewards) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(AccountRewardQueries.INSERT);
            preparedStatement.setString(1, accountsRewards.getAccountId());
            preparedStatement.setInt(2, accountsRewards.getRewardId());
            preparedStatement.setDate(3, Date.valueOf(accountsRewards.getExchangedDate()));
            preparedStatement.setString(4, accountsRewards.getAddress());
            preparedStatement.setString(5, accountsRewards.getPhoneNumber());
            preparedStatement.setString(6, accountsRewards.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExistExchangedReward(String username, int rewardId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(AccountRewardQueries.IS_EXIST_EXCHANGED);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, rewardId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStatus(String accountId, int rewardId, String status) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(AccountRewardQueries.UPDATE_STATUS);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, accountId);
            preparedStatement.setInt(3, rewardId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
