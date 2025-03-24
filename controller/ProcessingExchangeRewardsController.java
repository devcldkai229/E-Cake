package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.entities.AccountsRewards;
import devcldkai.kaipizzas.domain.entities.Rewards;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;
import devcldkai.kaipizzas.service.impl.AccountsRewardsService;
import devcldkai.kaipizzas.service.impl.AccountsService;
import devcldkai.kaipizzas.service.impl.RewardsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/exchangeRewards")
public class ProcessingExchangeRewardsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer rewardId = Integer.parseInt(request.getParameter("rewardId"));
        String address = request.getParameter("address");
        Accounts accounts = (Accounts) request.getSession().getAttribute("user");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            if (address == null || address.trim().isEmpty()) {
                out.write("{\"status\": false, \"message\": \"Address is required.\"}");
                out.flush();
                out.close();
                return;
            }
            if(AccountsRewardsService.getInstance().isExchangedReward(accounts.getUsername(), rewardId)){
                out.write("{\"status\": false, \"message\": \"Account has already been exchanged.\"}");
                out.flush();
                out.close();
                return;
            }
            if(accounts.getPhone()==null || accounts.getPhone().isEmpty()){
                out.write("{\"status\": false, \"message\": \"Please, updating your phone number in profile.\"}");
                out.flush();
                out.close();
                return;
            }
            Rewards rewards = RewardsService.getInstance().getById(rewardId).orElseThrow(
                    () -> new RuntimeException("Reward not found")
            );
            if(accounts.getPointRewards()<rewards.getPoint()){
                out.write("{\"status\": false, \"message\": \"Your points are not enough.\"}");
                out.flush();
                out.close();
                return;
            }
            double stillPointsAccount = accounts.getPointRewards()-rewards.getPoint();
            AccountsRewards accountsRewards = new AccountsRewards();
            accountsRewards.setRewardId(rewards.getId());
            accountsRewards.setAccountId(accounts.getId());
            accountsRewards.setExchangedDate(LocalDate.now());
            accountsRewards.setAddress(address);
            accountsRewards.setPhoneNumber(accounts.getPhone());
            AccountsRewardsService.getInstance().save(accountsRewards);
            RewardsService.getInstance().updateUnitsOfStock(rewardId, rewards.getQuantity()-1);
            AccountsService.getInstance().updatePointRewards(accounts.getUsername(), stillPointsAccount);

            Accounts accountsAfterUpdated = AccountsService.getInstance().getByUsername(accounts.getUsername()).orElseThrow(
                    () -> new UsernameNotFoundException("Account not found")
            );
            request.getSession().setAttribute("user", accountsAfterUpdated);
            out.write("{\"status\": true, \"stillPointsAccount\": \"" + String.format("%.2f", stillPointsAccount) + "\"}");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.write("{\"status\": false, \"message\": \"Internal Server Error. Please try again later.\"}");
            out.flush();
            out.close();
        }
    }
}
