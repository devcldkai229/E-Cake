package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Cart;
import devcldkai.kaipizzas.service.impl.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addtocart")
public class AdditionalCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idProduct = Long.parseLong(request.getParameter("idProduct"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String size = request.getParameter("currentsize");

        HttpSession session = request.getSession(false);
        Cart cart = (session != null) ? (Cart) session.getAttribute("cart") : null;

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if (cart == null) {
            out.write("{\"status\": false, \"message\": \"0\"}"); // Trả về "0" thay vì chuỗi thông báo lỗi
            out.flush();
            out.close();
            return;
        }

        CartService.getInstance().addItem(idProduct, quantity, size, cart.getCarts());
        int totalQuantity = CartService.getInstance().totalQuantity(cart.getCarts());

        request.getSession().setAttribute("totalQuantity", totalQuantity);

        out.write("{\"status\": true, \"message\": \"" + totalQuantity + "\"}");
        out.flush();
        out.close();
    }
}
