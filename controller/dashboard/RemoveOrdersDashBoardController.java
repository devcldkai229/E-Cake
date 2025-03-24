package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.service.impl.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/removeOrderDashBoard")
public class RemoveOrdersDashBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long orderId = Long.parseLong(request.getParameter("orderId"));
        OrderService.getInstance().delete(orderId);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (OrderService.getInstance().getById(orderId).isPresent()) { // Kiểm tra nếu vẫn tồn tại
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"success\": false, \"message\": \"Cannot remove this order\"}"); // Fix JSON format
            return;
        } else {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            response.getWriter().write("{\"success\": true}"); // Fix JSON format
        }
    }
}
