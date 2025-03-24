package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.authentication.Authentication;
import devcldkai.kaipizzas.authentication.SecurityContext;
import devcldkai.kaipizzas.constant.FormAnnouncementEmailForOrder;
import devcldkai.kaipizzas.constant.OrderStatus;
import devcldkai.kaipizzas.domain.entities.*;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;
import devcldkai.kaipizzas.service.impl.*;
import devcldkai.kaipizzas.util.EmailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@WebServlet("/orders")
public class ProcessingOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double shippingFee = Double.parseDouble(request.getParameter("shippingFee"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        List<CartItem> cartItemList = CartService.getInstance().getAllProducts(cart.getCarts());

        if(cartItemList.isEmpty() || cartItemList == null) {
            request.getRequestDispatcher("/notpizza.jsp").forward(request, response);
            return;
        }
        if(shippingFee == 0.0){
            request.getRequestDispatcher("/notformalshipping.jsp").forward(request, response);
            return;
        }

        Double finalTotal = 0.0;
        for (CartItem cartItem : cartItemList) {
            finalTotal+=cartItem.getTotal();
        }
        finalTotal+=shippingFee;
        request.setAttribute("cartItemList", cartItemList);
        request.setAttribute("finalTotal", finalTotal);
        request.setAttribute("shippingFee", shippingFee);
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactName = request.getParameter("txtContactName");
        String phoneNumber = request.getParameter("txtPhoneNumber");
        String email = request.getParameter("txtEmail");
        String address = request.getParameter("txtAddress");
        String note = request.getParameter("txtNote");
        String method = request.getParameter("paymentMethod");
        Double finalTotal = Double.parseDouble(request.getParameter("finalTotal"));
        Double shippingFee = Double.parseDouble(request.getParameter("shippingFee"));
        String username = null;

        Customers customer = new Customers(contactName, email, address, phoneNumber);
        LocalDateTime orderDate = LocalDateTime.now();
        LocalDateTime requiredDate = orderDate;
        if(shippingFee==4.0) requiredDate = orderDate.plusHours(1);
        else if(shippingFee==2.0) requiredDate = orderDate.plusHours(4);

        Orders orders = new Orders(orderDate, requiredDate, shippingFee, note, finalTotal, address, OrderStatus.PENDING, method);
        SecurityContext context = (SecurityContext) request.getSession().getAttribute("SECURITY_CONTEXT");
        if(context!=null){
            Authentication authentication = context.getAuthentication();
            username = authentication.getPrincipal();
            Accounts accountOrdered = AccountsService.getInstance().getByUsername(username).orElseThrow(
                    () -> new UsernameNotFoundException("Username not found")
            );
            customer.setAccountId(accountOrdered.getId());
        }
        if(!CustomerService.getInstance().isExist(customer)) {
            CustomerService.getInstance().save(customer);
        }
        Customers existingCustomer = CustomerService.getInstance().getByEmailAndPhone(customer).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found")
        );
        orders.setCustomerID(existingCustomer.getId());
        OrderService.getInstance().save(orders);
        Orders newestOrder = OrderService.getInstance().getNewestOrder().orElseThrow(
                () -> new ResourceNotFoundException("Newest order not found")
        );
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        List<CartItem> cartItemList = CartService.getInstance().getAllProducts(cart.getCarts());
        for (CartItem cartItem : cartItemList) {
            OrderDetails orderDetails = new OrderDetails(newestOrder.getId(), cartItem.getProducts().getId(),
                    cartItem.getSize(), cartItem.getPriceWithExtra(), cartItem.getQuantity(), cartItem.getTotal());
            OrderDetailsService.getInstance().save(orderDetails);
            long trueQuantityStill;
            if(cartItem.getQuantity() > cartItem.getProducts().getQuantity()) {
                trueQuantityStill = 0L;
            } else {
                trueQuantityStill = cartItem.getProducts().getQuantity() - cartItem.getQuantity();
            }
            ProductService.getInstance().updateQuantity(trueQuantityStill, cartItem.getProducts().getId());
        }
        double totalPointRewards = cartItemList.stream().mapToDouble(x->x.getTotal()/10).sum();
        if(username!=null){
            AccountsService.getInstance().updatePointRewards(username, totalPointRewards);
        }

        String sendTo = existingCustomer.getEmail();
        String subject = "Thanks your order!";
        String content = FormAnnouncementEmailForOrder.getForm().SendOrder(newestOrder.getId(), existingCustomer.getContactName(), cartItemList);
        EmailUtil.sendEmail(sendTo, subject, content);
        request.getSession().removeAttribute("cart");
        request.getSession().removeAttribute("totalQuantity");
        Cart newCart = new Cart();
        request.getSession().setAttribute("cart", newCart);
        request.getSession().setAttribute("totalQuantity", 0);
        response.sendRedirect("/ordersuccess.jsp");
    }

}
