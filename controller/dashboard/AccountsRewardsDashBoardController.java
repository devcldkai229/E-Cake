package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.dto.AccountsRewardsDashBoardDTO;
import devcldkai.kaipizzas.service.impl.AccountsRewardsService;
import devcldkai.kaipizzas.service.impl.RewardsOrdersServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;

@WebServlet("/adminrewardslist")
public class AccountsRewardsDashBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AccountsRewardsDashBoardDTO> rewardsList = RewardsOrdersServices.getInstance().mappingAccountsRewardsDTO(AccountsRewardsService.getInstance().getAll());
        request.setAttribute("rewardsList", rewardsList);
        request.getRequestDispatcher("/adminorderrewards.jsp").forward(request, response);
    }

}
