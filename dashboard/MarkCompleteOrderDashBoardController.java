package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.service.impl.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/markcompleteorder")
public class MarkCompleteOrderDashBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long orderId = Long.parseLong(request.getParameter("orderId"));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(!OrderService.getInstance().markOrderAsDelivered(orderId)){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write(
                    String.format("{\"success\": true, \"message\": \"Can not mark order as delivered\"}")
            );
            return;
        }
        LocalDateTime shippedDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        if(!OrderService.getInstance().updateShippedDate(shippedDate, orderId)){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write(
                    String.format("{\"success\": true, \"message\": \"Can not mark order as delivered\"}")
            );
            return;
        }
        System.out.println(String.format("{\"success\": true, \"shippedDate\": \"%s\", \"statusOrder\": \"%s\"}",
                shippedDate.format(formatter), "delivered"));
        response.getWriter().write(
                String.format("{\"success\": true, \"shippedDate\": \"%s\", \"statusOrder\": \"%s\"}",
                        shippedDate.format(formatter), "delivered")
        );

    }
}
