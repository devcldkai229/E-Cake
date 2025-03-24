package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.service.impl.CategoryService;
import devcldkai.kaipizzas.service.impl.ProductService;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ofsuppliers")
public class ProductOfSuppliersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String supplierId = request.getParameter("supplierId");
        List<Products> productsList = ProductService.getInstance().productsOfSupplier(Integer.parseInt(supplierId));
        if (productsList.isEmpty()) {
            request.setAttribute("productEmptyMsg", "No products found");
            request.getRequestDispatcher("/marketplace.jsp").forward(request, response);
        }

        Integer page, size = 8;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e){
            page = 1;
        }

        int sizeProducts = productsList.size();
        int totalPages = (int) Math.ceil((double)sizeProducts/size);
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, sizeProducts);

        List<Products> productsListPage = productsList.subList(startIndex, endIndex);
        List<Suppliers> suppliersList = SupplierService.getInstance().getAll();
        List<Categories> categoriesList = CategoryService.getInstance().getAll();
        request.setAttribute("categoriesList", categoriesList);
        request.setAttribute("suppliersList", suppliersList);
        request.setAttribute("isSupplier", "true");
        request.setAttribute("supplierId", supplierId);
        request.setAttribute("productsListPages", productsListPage);
        request.setAttribute("currentpages", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalProducts", sizeProducts);
        request.getRequestDispatcher("/marketplace.jsp").forward(request, response);
    }
}
