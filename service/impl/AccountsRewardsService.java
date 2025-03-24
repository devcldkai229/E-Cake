package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.entities.AccountsRewards;
import devcldkai.kaipizzas.domain.dto.AccountsRewardsDashBoardDTO;
import devcldkai.kaipizzas.repository.AccountsRewardsRepository;
import devcldkai.kaipizzas.repository.impl.AccountsRewardsRepositoryImpl;
import devcldkai.kaipizzas.service.IAccountsRewardsService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountsRewardsService implements IAccountsRewardsService {

    private AccountsRewardsRepository accountsRewardsRepository = new AccountsRewardsRepositoryImpl();

    public static IAccountsRewardsService getInstance(){
        return new AccountsRewardsService();
    }

    @Override
    public List<AccountsRewards> getAll() {
        return accountsRewardsRepository.selectAll();
    }

    @Override
    public Optional<AccountsRewards> getById(String accountId) {
        return accountsRewardsRepository.selectById(accountId);
    }

    @Override
    public Optional<AccountsRewards> getByUsername(String username) {
        return accountsRewardsRepository.selectByUsername(username);
    }

    @Override
    public void save(AccountsRewards accountsRewards) {
        accountsRewardsRepository.save(accountsRewards);
    }

    @Override
    public boolean isExchangedReward(String username, int rewardId) {
        return accountsRewardsRepository.isExistExchangedReward(username, rewardId);
    }

    @Override
    public boolean markCompletedRewardOrder(AccountsRewards accountsRewards, String status) {
        return accountsRewardsRepository.updateStatus(accountsRewards.getAccountId(), accountsRewards.getRewardId(), status);
    }


    public static void main(String[] args){
        List<AccountsRewardsDashBoardDTO> rewardsList = mappingAccountsRewardsDTO(AccountsRewardsService.getInstance().getAll());
        rewardsList.forEach(System.out::println);
    }

    private static List<AccountsRewardsDashBoardDTO> mappingAccountsRewardsDTO(List<AccountsRewards> rewardsList) {
        List<AccountsRewardsDashBoardDTO> rewardsDashBoardList = new ArrayList<>();
        for (AccountsRewards rewards : rewardsList) {
            Accounts loadedUser = AccountsService.getInstance().getById(rewards.getAccountId()).orElseThrow(
                    () -> new RuntimeException("Account not found")
            );
            String fullName = fullName(loadedUser);
            String exchangeDate = formatDate(rewards.getExchangedDate());
            AccountsRewardsDashBoardDTO rewardsDashBoard = mappingAccountsRewardsDTO(rewards, loadedUser);
            rewardsDashBoard.setFullName(fullName);
            rewardsDashBoard.setExchangeDate(exchangeDate);
            rewardsDashBoardList.add(rewardsDashBoard);
        }
        return rewardsDashBoardList;
    }

    private static String formatDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    private static AccountsRewardsDashBoardDTO mappingAccountsRewardsDTO(AccountsRewards rewards, Accounts accounts) {
        AccountsRewardsDashBoardDTO accountsRewardsDashBoardDTO = new AccountsRewardsDashBoardDTO();
        accountsRewardsDashBoardDTO.setAccountId(rewards.getAccountId());
        accountsRewardsDashBoardDTO.setRewardId(rewards.getRewardId());
        accountsRewardsDashBoardDTO.setAddress(rewards.getAddress());
        accountsRewardsDashBoardDTO.setStatus(rewards.getStatus());
        accountsRewardsDashBoardDTO.setEmail(accounts.getEmail());
        accountsRewardsDashBoardDTO.setUsername(accounts.getUsername());
        return accountsRewardsDashBoardDTO;
    }

    private static String fullName(Accounts accounts){
        return String.format("%s %s", accounts.getFirstName(), accounts.getLastName());
    }
}
