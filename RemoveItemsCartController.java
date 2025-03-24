package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Cart;
import devcldkai.kaipizzas.domain.entities.CartItem;
import devcldkai.kaipizzas.service.impl.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/removeitem")
public class RemoveItemsCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idProduct = Long.parseLong(request.getParameter("idProduct"));
        String currentsize = request.getParameter("currentsize");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        List<CartItem> cartItems = CartService.getInstance().getAllProducts(cart.getCarts());
        cartItems.stream()
                .filter(x -> x.getProducts().getId().equals(idProduct))
                .findFirst()
                .ifPresent(cartItems::remove);
        CartService.getInstance().removeItem(idProduct, currentsize, cart.getCarts());
        HttpSession session = request.getSession();
        session.setAttribute("cart", cart);
        Integer itemQuantity = CartService.getInstance().totalQuantityByCartItem(cartItems);
        Double total = cartItems.stream().map(CartItem::getTotal).mapToDouble(x->x).sum();
        request.setAttribute("cartItemList", cartItems);
        request.setAttribute("itemQuantity", itemQuantity);
        request.getSession().setAttribute("totalQuantity", itemQuantity);
        request.setAttribute("total", total);
        request.getRequestDispatcher("/shoppingcart.jsp").forward(request, response);
    }
}
