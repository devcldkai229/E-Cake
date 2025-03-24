package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createSuppliersDashBoard")
public class CreateSuppliersDashBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String name = request.getParameter("nameSuppliers");
          String address = request.getParameter("addressSuppliers");
          String phone = request.getParameter("phoneSuppliers");

        SupplierService.getInstance().save(new Suppliers(name, address, phone));
    }
}
