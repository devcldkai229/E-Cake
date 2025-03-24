package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminsupplierlist")
public class SuppliersDashBoardAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Suppliers> suppliersList = SupplierService.getInstance().getAll();
        request.setAttribute("suppliersList", suppliersList);
        request.setAttribute("totalSuppliers", suppliersList.size());

        request.getRequestDispatcher("/adminsupplier.jsp").forward(request, response);
    }
}
