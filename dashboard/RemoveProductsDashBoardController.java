package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.service.impl.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/removeProductsDashBoard")
public class RemoveProductsDashBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("productId"));
        ProductService.getInstance().delete(productId);

        response.sendRedirect("/adminproductslist");
    }
}
