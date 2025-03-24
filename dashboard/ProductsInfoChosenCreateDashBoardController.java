package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.service.impl.CategoryService;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/createProductsInfo")
public class ProductsInfoChosenCreateDashBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Suppliers> suppliers = SupplierService.getInstance().getAll();
        List<Categories> categories = CategoryService.getInstance().getAll();

        request.setAttribute("suppliers", suppliers);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/productcreate.jsp").forward(request, response);
    }
}
