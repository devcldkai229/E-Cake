package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Cart;
import devcldkai.kaipizzas.domain.entities.CartItem;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.impl.CartService;
import devcldkai.kaipizzas.service.impl.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ordernow")
public class OrderDirectNotAuthenticationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idProduct = Long.parseLong(request.getParameter("idProduct"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String requireSize = request.getParameter("currentsize");
        Double shippingFee = Double.parseDouble(request.getParameter("shippingfee"));

        Cart cart = new Cart();
        Products existingProduct = ProductService.getInstance().getById(idProduct).orElseThrow(
                () -> new ResourceNotFoundException("Product not found!")
        );
        CartService.getInstance().addItem(idProduct, quantity, requireSize, cart.getCarts());
        List<CartItem> cartItemList = CartService.getInstance().getAllProducts(cart.getCarts());
        Double finalTotal = 0.0;
        for (CartItem cartItem : cartItemList) {
            finalTotal+=cartItem.getTotal();
        }
        finalTotal+=shippingFee;
        request.getSession().setAttribute("cart", cart);
        request.setAttribute("cartItemList", cartItemList);
        request.setAttribute("finalTotal", finalTotal);
        request.setAttribute("shippingFee", shippingFee);

        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }
}
