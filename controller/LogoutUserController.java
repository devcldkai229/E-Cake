package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.authentication.SecurityContext;
import devcldkai.kaipizzas.authentication.SecurityContextHolder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        SecurityContext context = (SecurityContext) session.getAttribute("SECURITY_CONTEXT");
        if(context != null) {
            session.removeAttribute("SECURITY_CONTEXT");
            session.removeAttribute("user");
            session.removeAttribute("cart");
            session.invalidate();
            SecurityContextHolder.clearContext();
            request.getRequestDispatcher("/home").forward(request, response);
        }
    }
}
