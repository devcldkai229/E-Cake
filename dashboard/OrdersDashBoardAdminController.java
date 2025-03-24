package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.dto.OrdersDashBoardDTO;
import devcldkai.kaipizzas.service.impl.OrdersDashBoardAdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminorderlist")
public class OrdersDashBoardAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrdersDashBoardDTO> ordersDashBoardDTOList = OrdersDashBoardAdminService.getInstance().getAllOrdersDashBoard();
        int totalOrders = OrdersDashBoardAdminService.getInstance().totalOrdersDashBoard();
        double totalSales = OrdersDashBoardAdminService.getInstance().totalSalesDashBoard();
        int totalProducts = OrdersDashBoardAdminService.getInstance().totalProductsDashBoard();
        int totalOrdersUndelivered = OrdersDashBoardAdminService.getInstance().totalOrdersUndeliveredDashBoard();
        request.setAttribute("ordersDashBoardDTOList", ordersDashBoardDTOList);
        request.setAttribute("totalOrders", totalOrders);
        request.setAttribute("totalSales", String.format("%.2f", totalSales));
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalOrdersUndelivered", totalOrdersUndelivered);

        request.getRequestDispatcher("/adminorder.jsp").forward(request, response);
    }


}
