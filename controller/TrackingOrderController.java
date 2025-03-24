package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.dto.ProductsOrderDetailsDTO;
import devcldkai.kaipizzas.domain.entities.*;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/trackingorder")
public class TrackingOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long orderId = 0L;
        try {
            orderId = Long.parseLong(request.getParameter("orderId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (orderId == null || orderId <= 999) {
            throw new ResourceNotFoundException("Order not found");
        }

        Orders existingOrder;
        try {
            existingOrder = OrderService.getInstance().getById(orderId).orElseThrow(
                    () -> new ResourceNotFoundException("Order not found")
            );
        } catch (ResourceNotFoundException e) {
            response.sendRedirect("/error404.jsp");
            return;
        }
        Customers existingCustomer = CustomerService.getInstance().getById(existingOrder.getCustomerID()).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found")
        );
        List<OrderDetails> orderDetailsList = OrderService.getInstance().getOrderDetailsOfOrder(existingOrder.getId());
        List<ProductsOrderDetailsDTO> productsOrderDetailsDTOList = getProductsDetailsFromOrderDetails(orderDetailsList);

        Double subTotal = existingOrder.getTotal() - existingOrder.getFreight();
        request.setAttribute("order", existingOrder);
        request.setAttribute("customer", existingCustomer);
        request.setAttribute("subTotal", subTotal);
        request.setAttribute("shippingFee", existingOrder.getFreight());
        request.setAttribute("total", existingOrder.getTotal());
        request.setAttribute("deliveryFormal", existingOrder.getFreight()==4.0?"Express Delivery":"Standard Delivery");
        request.setAttribute("deliveryTimer", existingOrder.getFreight()==4.0?1:4);
        request.setAttribute("productsOrderDetailsDTOList", productsOrderDetailsDTOList);
        request.setAttribute("isFound", true);

        request.getRequestDispatcher("/trackingOrderFound.jsp").forward(request, response);
    }

    private List<ProductsOrderDetailsDTO> getProductsDetailsFromOrderDetails(List<OrderDetails> orderDetailsList){
        List<ProductsOrderDetailsDTO> productsOrderDetailsDTOList = new ArrayList<>();
        for (OrderDetails orderDetails : orderDetailsList) {
            Products existingProduct = ProductService.getInstance().getById(orderDetails.getProductId()).orElseThrow(
                    () -> new ResourceNotFoundException("Product not found")
            );
            Suppliers existingSupplier = SupplierService.getInstance().getById(existingProduct.getSupplierId()).orElseThrow(
                    () -> new ResourceNotFoundException("Supplier not found")
            );
            Categories existingCategory = CategoryService.getInstance().getById(existingProduct.getCategoryId()).orElseThrow(
                    () -> new ResourceNotFoundException("Category not found")
            );
            ProductsOrderDetailsDTO productsOrderDetailsDTO = new ProductsOrderDetailsDTO(
                    existingProduct.getName(),
                    existingCategory.getName(),
                    existingSupplier.getCompanyName(),
                    orderDetails.getSize(),
                    orderDetails.getPrice(),
                    orderDetails.getQuantity(),
                    orderDetails.getTotal(),
                    existingProduct.getProductImgUrl()
            );
            productsOrderDetailsDTOList.add(productsOrderDetailsDTO);
        }
        return productsOrderDetailsDTOList;
    }
}
