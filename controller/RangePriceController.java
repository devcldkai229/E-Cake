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

@WebServlet("/range")
public class RangePriceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double priceFrom = Double.parseDouble(request.getParameter("txtPriceFrom"));
        Double priceTo = Double.parseDouble(request.getParameter("txtPriceTo"));

        List<Products> productsList = ProductService.getInstance().getAll();
        List<Products> productsListByRange = productsList.stream().filter(
                x->isInsideRange(priceFrom, priceTo, x)
        ).toList();

        if (productsListByRange.isEmpty()) {
            request.setAttribute("productEmptyMsg", "No products found");
            request.getRequestDispatcher("/marketplace.jsp").forward(request, response);
        }

        Integer page, size = 8;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e){
            page = 1;
        }

        int sizeProducts = productsListByRange.size();
        int totalPages = (int) Math.ceil((double)sizeProducts/size);
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, sizeProducts);

        List<Products> productsListPage = productsListByRange.subList(startIndex, endIndex);
        List<Suppliers> suppliersList = SupplierService.getInstance().getAll();
        List<Categories> categoriesList = CategoryService.getInstance().getAll();
        request.setAttribute("categoriesList", categoriesList);
        request.setAttribute("suppliersList", suppliersList);
        request.setAttribute("isRange", "true");
        request.setAttribute("txtPriceFrom", priceFrom.toString());
        request.setAttribute("txtPriceTo", priceTo.toString());
        request.setAttribute("productsListPages", productsListPage);
        request.setAttribute("currentpages", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalProducts", sizeProducts);
        request.getRequestDispatcher("/marketplace.jsp").forward(request, response);
    }

    private boolean isInsideRange(Double priceFrom, Double priceTo, Products products) {
        return products.getPrice() >= priceFrom && products.getPrice() <= priceTo;
    }
}
