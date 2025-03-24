package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.service.impl.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admincategorieslist")
public class CategoriesDashBoardAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> categoriesListHasDefault = CategoryService.getInstance().getAll();
        List<Categories> categoriesList = categoriesListHasDefault;
        request.setAttribute("categoriesList", categoriesList);
        request.setAttribute("totalCategories", categoriesListHasDefault.size()-1);

        request.getRequestDispatcher("/admincategory.jsp").forward(request, response);
    }
}
