package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.domain.entities.AccountsRewards;

import java.util.List;
import java.util.Optional;

public interface AccountsRewardsRepository {

    List<AccountsRewards> selectAll();

    Optional<AccountsRewards> selectById(String accountId);

    Optional<AccountsRewards> selectByUsername(String username);

    void save(AccountsRewards accountsRewards);

    boolean isExistExchangedReward(String username, int rewardId);

    boolean updateStatus(String accountId, int rewardId, String status);


}
