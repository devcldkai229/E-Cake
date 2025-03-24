package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.domain.entities.Rewards;
import devcldkai.kaipizzas.mapper.RewardsMappers;
import devcldkai.kaipizzas.repository.RewardsRepository;
import devcldkai.kaipizzas.repository.queries.RewardQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RewardsRepositoryImpl implements RewardsRepository {
    @Override
    public List<Rewards> selectAllRewards() {
        List<Rewards> rewards = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(RewardQueries.SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                rewards.add(RewardsMappers.mapToRewards(resultSet));
            }
            return rewards;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewards;
    }

    @Override
    public Optional<Rewards> selectRewardById(int id) {
        try{
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(RewardQueries.SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    return Optional.of(RewardsMappers.mapToRewards(rs));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(Rewards rewards) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(RewardQueries.INSERT);
            preparedStatement.setString(1, rewards.getName());
            preparedStatement.setDouble(2, rewards.getPoint());
            preparedStatement.setInt(3, rewards.getLimitExchange());
            preparedStatement.setString(4, rewards.getDescription());
            preparedStatement.setString(5, rewards.getImageUrl());
            preparedStatement.setInt(6, rewards.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateQuantity(int id, int quantity) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(RewardQueries.UPDATE_QUANTITY);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
