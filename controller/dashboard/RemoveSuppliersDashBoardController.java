package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.service.impl.ProductService;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/removeSupplierDashBoard")
public class RemoveSuppliersDashBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer supplierId = Integer.parseInt(request.getParameter("supplierId"));
        List<Products> productsList = SupplierService.getInstance().getProductsBySupplier(supplierId);
        for (Products products : productsList) {
            ProductService.getInstance().delete(products.getId());
        }
        SupplierService.getInstance().delete(supplierId);
        request.getRequestDispatcher("/adminsupplier.jsp").forward(request, response);
    }
}
