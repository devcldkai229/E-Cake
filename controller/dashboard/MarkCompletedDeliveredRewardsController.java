package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.AccountsRewards;
import devcldkai.kaipizzas.service.impl.AccountsRewardsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/markCompletedOrderRewards")
public class MarkCompletedDeliveredRewardsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rewardId = Integer.parseInt(request.getParameter("rewardId"));
        String accountId = request.getParameter("accountId");
        AccountsRewards accountsRewards = new AccountsRewards();
        accountsRewards.setRewardId(rewardId);
        accountsRewards.setAccountId(accountId);
        AccountsRewardsService.getInstance().markCompletedRewardOrder(accountsRewards, "delivered");
        request.getRequestDispatcher("/adminrewardslist").forward(request, response);
    }
}
