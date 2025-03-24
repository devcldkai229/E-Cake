package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.constant.OrderStatus;
import devcldkai.kaipizzas.service.impl.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cancelOrder")
public class CancelOrderHistoryUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long orderId = Long.parseLong(request.getParameter("orderId"));
        OrderService.getInstance().updateStatus(OrderStatus.CANCELLED, orderId);

        request.getRequestDispatcher("/historyOrdered").forward(request, response);
    }
}
