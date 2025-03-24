package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Cart;
import devcldkai.kaipizzas.domain.entities.CartItem;
import devcldkai.kaipizzas.service.impl.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/forwardcart")
public class ShoppingCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        List<CartItem> cartItemList = CartService.getInstance().getAllProducts(cart.getCarts());
        //Integer totalQuantity = CartService.getInstance().totalQuantity(cart.getCarts());
        Double total = cartItemList.stream().map(CartItem::getTotal).mapToDouble(x->x).sum();
        request.setAttribute("cartItemList", cartItemList);
        request.setAttribute("itemQuantity", cartItemList.size());
        //request.setAttribute("totalQuantity", totalQuantity);
        request.setAttribute("total", total);
        request.getRequestDispatcher("/shoppingcart.jsp").forward(request, response);
    }
}
