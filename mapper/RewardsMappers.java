package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.Rewards;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RewardsMappers {

    private RewardsMappers() {}

    public static Rewards mapToRewards(ResultSet rs) throws SQLException {
        Rewards rewards = new Rewards();
        rewards.setId(rs.getInt("id"));
        rewards.setName(rs.getString("name"));
        rewards.setDescription(rs.getString("description"));
        rewards.setPoint(rs.getDouble("point"));
        rewards.setLimitExchange(rs.getInt("limitExchange"));
        rewards.setQuantity(rs.getInt("quantity"));
        rewards.setImageUrl(rs.getString("ImageUrl"));
        return rewards;
    }


}
