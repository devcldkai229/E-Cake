package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.AccountsRewards;

import java.util.List;
import java.util.Optional;

public interface IAccountsRewardsService {

    List<AccountsRewards> getAll();

    Optional<AccountsRewards> getById(String accountId);

    Optional<AccountsRewards> getByUsername(String username);

    void save(AccountsRewards accountsRewards);

    boolean isExchangedReward(String username, int rewardId);

    boolean markCompletedRewardOrder(AccountsRewards accountsRewards, String status);
}
