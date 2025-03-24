package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.dto.ProductsDashBoardDTO;
import devcldkai.kaipizzas.service.impl.ProductsDashBoardAdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminproductslist")
public class ProductsDashBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductsDashBoardDTO> productsDashBoardDTOList = ProductsDashBoardAdminService.getInstance().getAllProductsDashBoard();
        request.setAttribute("productsDashBoardDTOList", productsDashBoardDTOList);
        request.setAttribute("totalProducts", productsDashBoardDTOList.size());

        request.getRequestDispatcher("/adminproducts.jsp").forward(request, response);
    }
}
