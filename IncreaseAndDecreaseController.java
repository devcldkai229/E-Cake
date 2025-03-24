package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Cart;
import devcldkai.kaipizzas.domain.entities.CartItem;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.impl.CartService;
import devcldkai.kaipizzas.service.impl.ProductService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/updatequantity")
public class IncreaseAndDecreaseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            long productId = Long.parseLong(request.getParameter("productId"));
            int currentQuantity = Integer.parseInt(request.getParameter("currentQuantity"));
            String currentSize = request.getParameter("currentSize");
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            Products products = ProductService.getInstance().getById(productId).orElseThrow(
                    () -> new ResourceNotFoundException("Product not found")
            );

            if (cart == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"success\": false, \"message\": \"Cart not exist\"}");
                out.flush();
                out.close();
                return;
            }

            if(currentQuantity>products.getQuantity()){
                out.write("{\"success\": false, \"message\": \"Units of stock not enough\"}");
                out.flush();
                out.close();
                return;
            }

            List<CartItem> cartItemList = CartService.getInstance().getAllProducts(cart.getCarts());
            double updatedItemTotal = 0.0;
            int totalQuantity = 0;
            double finalTotalNotShippingFee = 0.0;

            for (CartItem item : cartItemList) {
                if (item.getProducts().getId().equals(productId) && item.getSize().equalsIgnoreCase(currentSize)) {
                    item.setQuantity(currentQuantity);
                    item.setTotal(item.getQuantity() * item.getPriceWithExtra());
                    updatedItemTotal = item.getTotal();
                }
                totalQuantity += item.getQuantity();
                finalTotalNotShippingFee += item.getTotal();
            }
            cart.setCarts(cartItemList);
            request.getSession().setAttribute("cart", cart);

            request.getSession().setAttribute("totalQuantity", totalQuantity);

            out.write(
                    String.format(
                            "{\"success\": true, \"updatedItemTotal\": %.2f, \"totalQuantity\": %d, \"finalTotalNotShippingFee\": %.2f}",
                            updatedItemTotal, totalQuantity, finalTotalNotShippingFee
                    )
            );
            out.flush();
            out.close();
        } catch (Exception e) {
            out.write("{\"success\": false, \"message\": \"error server\"}");
            out.flush();
            out.close();
        }
    }
}

