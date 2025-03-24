package devcldkai.kaipizzas.controller.dashboard;


import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.service.impl.AccountsService;
import devcldkai.kaipizzas.service.impl.RoleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminaccount")
public class AccountDashBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Accounts> accountsList = AccountsService.getInstance().getAll();
        accountsList.removeIf(x -> RoleService.getInstance().getRole(x.getRoleId()).get().equalsIgnoreCase("AMIN"));
        request.setAttribute("accountsList", accountsList);
        request.getRequestDispatcher("/adminaccount.jsp").forward(request, response);
    }
}
