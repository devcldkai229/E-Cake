package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Cart;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.impl.CartService;
import devcldkai.kaipizzas.service.impl.ProductService;
import devcldkai.kaipizzas.service.impl.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/productoverview")
public class ProductOverviewController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            response.sendRedirect("/error404.jsp");
        }
        try {
            Products existingProduct = ProductService.getInstance().getById(Long.parseLong(id)).orElseThrow(
                    () -> new ResourceNotFoundException("No product found with id " + id)
            );
            Suppliers supplier = SupplierService.getInstance().getById(existingProduct.getSupplierId()).orElseThrow(
                    () -> new ResourceNotFoundException("No supplier found with id " + existingProduct.getSupplierId())
            );
            String sizePizza = request.getParameter("currentsize");
            if (sizePizza != null && !sizePizza.equals("")) {
                if(sizePizza.equals("S")) {
                    request.setAttribute("priceProductBySize", String.format("%.2f", existingProduct.getPrice()));
                    request.setAttribute("currentsize",sizePizza);
                }
                else if(sizePizza.equals("M")) {
                    request.setAttribute("priceProductBySize",String.format("%.2f", existingProduct.getPrice() + 2.0));
                    request.setAttribute("currentsize",sizePizza);
                }
                else if(sizePizza.equals("L")) {
                    request.setAttribute("priceProductBySize",String.format("%.2f", existingProduct.getPrice() + 2.0 + 2.0));
                    request.setAttribute("currentsize",sizePizza);
                }
                else if(sizePizza.equals("XL")) {
                    request.setAttribute("priceProductBySize",String.format("%.2f", existingProduct.getPrice() + 2.0 + 2.0 + 1.0));
                    request.setAttribute("currentsize",sizePizza);
                }
            } else {
                request.setAttribute("priceProductBySize",existingProduct.getPrice());
                request.setAttribute("currentsize","S");
            }
            HttpSession session = request.getSession(false);
            Cart cart = (session != null) ? (Cart) session.getAttribute("cart") : null;

            if (cart != null) {
                Integer quantityItems = CartService.getInstance().totalQuantity(cart.getCarts());
                request.getSession().setAttribute("totalQuantity", quantityItems);
            }
            request.setAttribute("product", existingProduct);
            request.setAttribute("supplier", supplier);
            request.getRequestDispatcher("/productdetails.jsp").forward(request, response);
        } catch(ResourceNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("/error404.jsp");
        }
    }
}
