package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Rewards;
import devcldkai.kaipizzas.service.impl.RewardsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/rewards")
public class RewardsForUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Rewards> rewardsList = RewardsService.getInstance().getAll();
        request.setAttribute("rewardsList", rewardsList);
        request.getRequestDispatcher("/profilerewards.jsp").forward(request, response);
    }
}

