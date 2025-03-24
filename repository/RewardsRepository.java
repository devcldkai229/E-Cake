package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.domain.entities.Rewards;

import java.util.List;
import java.util.Optional;

public interface RewardsRepository {

    List<Rewards> selectAllRewards();

    Optional<Rewards> selectRewardById(int id);

    void save(Rewards rewards);

    boolean updateQuantity(int id, int quantity);
}
