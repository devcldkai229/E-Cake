package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.service.impl.CategoryService;
import devcldkai.kaipizzas.service.impl.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/removeCategoriesDashBoard")
public class RemoveCategoriesDashBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
        List<Products> productsList = CategoryService.getInstance().getProductsByCategory(categoryId);
        for(Products x : productsList){
            ProductService.getInstance().setUncategorized(x.getId());
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(!CategoryService.getInstance().delete(categoryId)){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"success\": false, \"message\": \"Cannot remove this category\"}");
            return;
        } else {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            response.getWriter().write(
                    String.format("{\"success\": true}")
            );
        }
    }
}
