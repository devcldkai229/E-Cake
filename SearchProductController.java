package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.impl.CategoryService;
import devcldkai.kaipizzas.service.impl.ProductService;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchproduct")
public class SearchProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameOfProduct = request.getParameter("txtNameProductToSearch");
        List<Products> products = products = ProductService.getInstance().getByName(nameOfProduct);
        request.setAttribute("keysearch", nameOfProduct);

        if (products.isEmpty()) {
            request.setAttribute("productEmptyMsg", "No products found");
            request.getRequestDispatcher("/marketplace.jsp").forward(request, response);
        }

        Integer page, size = 8;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1;
        }

        int sizeProducts = products.size();
        int totalPages = (int)Math.ceil((double)sizeProducts / size);
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, sizeProducts);

        List<Products> productsListPage = products.subList(startIndex, endIndex);
        List<Suppliers> suppliersList = SupplierService.getInstance().getAll();
        List<Categories> categoriesList = CategoryService.getInstance().getAll();
        request.setAttribute("categoriesList", categoriesList);
        request.setAttribute("suppliersList", suppliersList);
        request.setAttribute("isProductSearch", "true");
        request.setAttribute("productsListPages", productsListPage);
        request.setAttribute("currentpages", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalProducts", sizeProducts);
        request.getRequestDispatcher("/marketplace.jsp").forward(request, response);

    }
}
