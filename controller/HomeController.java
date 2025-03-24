package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.service.impl.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> categoriesListHasDefault = CategoryService.getInstance().getAll();
        List<Categories> categoriesList = categoriesListHasDefault.subList(1, categoriesListHasDefault.size());
        request.setAttribute("categoriesList", categoriesList);

        request.getRequestDispatcher("/index.jsp").include(request, response);
    }
}
