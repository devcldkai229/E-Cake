package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.entities.AccountsRewards;
import devcldkai.kaipizzas.domain.dto.AccountsRewardsDashBoardDTO;
import devcldkai.kaipizzas.domain.entities.Rewards;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RewardsOrdersServices {

    public static RewardsOrdersServices getInstance(){
        return new RewardsOrdersServices();
    }

    public List<AccountsRewardsDashBoardDTO> mappingAccountsRewardsDTO(List<AccountsRewards> rewardsList) {
        List<AccountsRewardsDashBoardDTO> rewardsDashBoardList = new ArrayList<>();
        for (AccountsRewards rewards : rewardsList) {
            Rewards rewards1 = RewardsService.getInstance().getById(rewards.getRewardId()).orElseThrow(
                    () -> new ResourceNotFoundException("Invalid reward id: " + rewards.getRewardId())
            );
            Accounts loadedUser = AccountsService.getInstance().getById(rewards.getAccountId()).orElseThrow(
                    () -> new UsernameNotFoundException("Account not found")
            );
            String fullName = fullName(loadedUser);
            String exchangeDate = formatDate(rewards.getExchangedDate());
            AccountsRewardsDashBoardDTO rewardsDashBoard = mappingAccountsRewardsDTO(rewards, loadedUser);
            rewardsDashBoard.setFullName(fullName);
            rewardsDashBoard.setExchangeDate(exchangeDate);
            rewardsDashBoard.setGiftName(rewards1.getName());
            rewardsDashBoard.setImage(rewards1.getImageUrl());
            rewardsDashBoardList.add(rewardsDashBoard);
        }
        return rewardsDashBoardList;
    }

    public String formatDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public AccountsRewardsDashBoardDTO mappingAccountsRewardsDTO(AccountsRewards rewards, Accounts accounts) {
        AccountsRewardsDashBoardDTO accountsRewardsDashBoardDTO = new AccountsRewardsDashBoardDTO();
        accountsRewardsDashBoardDTO.setAccountId(rewards.getAccountId());
        accountsRewardsDashBoardDTO.setRewardId(rewards.getRewardId());
        accountsRewardsDashBoardDTO.setAddress(rewards.getAddress());
        accountsRewardsDashBoardDTO.setStatus(rewards.getStatus());
        accountsRewardsDashBoardDTO.setEmail(accounts.getEmail());
        accountsRewardsDashBoardDTO.setPhone(accounts.getPhone());
        accountsRewardsDashBoardDTO.setUsername(accounts.getUsername());
        return accountsRewardsDashBoardDTO;
    }

    public String fullName(Accounts accounts){
        return String.format("%s %s", accounts.getFirstName(), accounts.getLastName());
    }

}
