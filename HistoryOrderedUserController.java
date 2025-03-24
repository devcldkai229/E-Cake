package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.dto.OrderedUserDTO;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.mapper.OrderedUserDTOMappers;
import devcldkai.kaipizzas.service.impl.AccountsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/historyOrdered")
public class HistoryOrderedUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Accounts sessionAccount = (Accounts) request.getSession().getAttribute("user");
        String accountId = sessionAccount.getId();
        List<Orders> orders = AccountsService.getInstance().getAllHistoryOrders(accountId);
        List<OrderedUserDTO> ordersDtoListOrigin = orders.stream()
                .map(x->OrderedUserDTOMappers.mapToOrderedUserDTO(x, accountId)).toList()
                .stream().sorted(Comparator.comparingLong(OrderedUserDTO::getId).reversed()).toList();

        Integer page, size = 5;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e){
            page = 1;
        }

        int sizeProducts = ordersDtoListOrigin.size();
        int totalPages = (int) Math.ceil((double)sizeProducts/size);
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, sizeProducts);

        List<OrderedUserDTO> ordersDtoList = ordersDtoListOrigin.subList(startIndex, endIndex);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("isHistoryOrders", true);
        request.setAttribute("ordersDtoList", ordersDtoList);
        request.getRequestDispatcher("/profilehistory.jsp").forward(request, response);
    }
}
