package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.dto.OrderedUserDTO;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.mapper.OrderedUserDTOMappers;
import devcldkai.kaipizzas.service.impl.AccountsService;
import devcldkai.kaipizzas.service.impl.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/ordersHistoryFilter")
public class HistoryFilterOrdersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Accounts sessionAccounts = (Accounts) request.getSession().getAttribute("user");
        if (sessionAccounts == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String status = request.getParameter("status");
        String time = request.getParameter("time");
        status = (status == null) ? "all" : status.toLowerCase();
        time = (time == null) ? "this_year" : time.toLowerCase();

        List<Orders> result = AccountsService.getInstance().getAllHistoryOrders(sessionAccounts.getId());

        if (!status.equals("all")) {
            String finalStatus = status;
            result = result.stream()
                    .filter(order -> order.getStatus().equalsIgnoreCase(finalStatus))
                    .collect(Collectors.toList());
        }
        List<Orders> filteredOrders = switch (time) {
            case "this_week" -> OrderService.getInstance().getOrdersThisWeek();
            case "3_month" -> OrderService.getInstance().getOrdersInLast3Month();
            case "6_month" -> OrderService.getInstance().getOrdersInLast6Month();
            default -> OrderService.getInstance().getOrdersThisYear();
        };

        Set<Long> filteredOrderIds = filteredOrders.stream().map(Orders::getId).collect(Collectors.toSet());
        result = result.stream()
                .filter(order -> filteredOrderIds.contains(order.getId()))
                .collect(Collectors.toList());
        List<OrderedUserDTO> ordersAscId = result.stream()
                .sorted(Comparator.comparingLong(Orders::getId).reversed())
                .map(x -> OrderedUserDTOMappers.mapToOrderedUserDTO(x, sessionAccounts.getId()))
                .collect(Collectors.toList());


        Integer page, size = 5;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e){
            page = 1;
        }

        int sizeProducts = ordersAscId.size();
        int totalPages = (int) Math.ceil((double)sizeProducts/size);
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, sizeProducts);

        List<OrderedUserDTO> ordersDtoList = ordersAscId.subList(startIndex, endIndex);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("isFilteredOrders", true);
        request.setAttribute("ordersDtoList", ordersDtoList);
        request.getRequestDispatcher("/profilehistory.jsp").forward(request, response);
    }
}
