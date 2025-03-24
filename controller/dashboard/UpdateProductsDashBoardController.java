package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.dto.ProductsDashBoardDTO;
import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.impl.CategoryService;
import devcldkai.kaipizzas.service.impl.ProductsDashBoardAdminService;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/updateProductDashBoard")
public class UpdateProductsDashBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("productId"));
        ProductsDashBoardDTO existingProduct = ProductsDashBoardAdminService.getInstance()
                .getAllProductsDashBoard().stream().filter(x->x.getId()==productId)
                .findFirst()
                .orElseThrow(
                        () -> new ResourceNotFoundException("Product with id "+productId+" not found")
                );
        List<Suppliers> suppliers = SupplierService.getInstance().getAll();
        List<Categories> categories = CategoryService.getInstance().getAll();
        request.setAttribute("productEdition", existingProduct);
        request.setAttribute("suppliers", suppliers);
        request.setAttribute("categories", categories.subList(1, categories.size()));
        request.getRequestDispatcher("/productedition.jsp").forward(request, response);
    }

}
