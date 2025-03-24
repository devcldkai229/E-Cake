package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.service.impl.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createCategoryDashBoard")
public class CreateCategoriesDashBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("categoryName");
        String description = request.getParameter("categoryDescription");
        CategoryService.getInstance().save(new Categories(name, description));
    }
}
