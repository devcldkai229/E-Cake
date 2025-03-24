package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.dto.OrderReportDTO;
import devcldkai.kaipizzas.domain.entities.OrderDetails;
import devcldkai.kaipizzas.service.impl.OrderReportStatisticService;
import devcldkai.kaipizzas.service.impl.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/orderReport")
public class OrderReportStatisticController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("startDate") == null || request.getParameter("endDate") == null){
            response.sendRedirect("/reportstatistic.jsp");
            return;
        }
        String[] startDateArray =  request.getParameter("startDate").split("/");
        String[] endDateArray = request.getParameter("endDate").split("/");

        String startDateRequired = startDateArray[2] + "-" + startDateArray[0] + "-" + startDateArray[1];
        String endDateRequired = endDateArray[2] + "-" + endDateArray[0] + "-" + endDateArray[1];

        LocalDate startDate = LocalDate.parse(startDateRequired, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(endDateRequired, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23,59,59);

        List<OrderReportDTO> orderReportList = new ArrayList<>();
        try {
            orderReportList = OrderReportStatisticService.getInstance().getAllDeliveredByStartDateAndEndDate(startDateTime, endDateTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        double totalSales = orderReportList.stream().mapToDouble(OrderReportDTO::getTotal).sum();
        int ordersSales = orderReportList.size();
        int totalProductSales = orderReportList.stream().mapToInt(x -> {
            List<OrderDetails> orderDetails = OrderService.getInstance().getOrderDetailsOfOrder(x.getId());
            return orderDetails.stream().mapToInt(OrderDetails::getQuantity).sum();
        }).sum();
        Collections.sort(orderReportList, Comparator.comparingDouble(OrderReportDTO::getTotal).reversed());
        request.setAttribute("orderReportList", orderReportList);
        request.setAttribute("totalSales", totalSales);
        request.setAttribute("totalSales", totalSales);
        request.setAttribute("totalOrders", ordersSales);
        request.setAttribute("totalProductsSales", totalProductSales);

        request.getRequestDispatcher("/reportstatistic.jsp").forward(request, response);
    }
}
