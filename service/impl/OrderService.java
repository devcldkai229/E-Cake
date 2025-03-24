package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.OrderDetails;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.repository.OrderRepository;
import devcldkai.kaipizzas.repository.impl.OrderRepositoryImpl;
import devcldkai.kaipizzas.service.IOrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderService implements IOrderService {

    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    public static IOrderService getInstance(){
        return new OrderService();
    }

    @Override
    public List<Orders> getAll() {
        return orderRepository.selectAllOrders();
    }

    @Override
    public Optional<Orders> getById(Long id) {
        return orderRepository.selectOrderById(id);
    }

    @Override
    public void save(Orders order) {
        orderRepository.insertOrder(order);
    }

    @Override
    public boolean updateShippedDate(LocalDateTime newDate, Long id) {
        return orderRepository.updateShipDateOrder(newDate, id);
    }

    @Override
    public void updateStatus(String newStatus, Long id) {
        orderRepository.updateStatusOrder(newStatus, id);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteItemsFromOrderById(id);
        orderRepository.deleteOrderById(id);
    }

    @Override
    public List<Orders> getByStatus(String status) {
        return orderRepository.selectAllOrdersByStatus(status);
    }

    @Override
    public List<OrderDetails> getOrderDetailsOfOrder(Long id) {
        return orderRepository.selectOrderDetailsByID(id);
    }

    @Override
    public Optional<Orders> getNewestOrder() {
        return orderRepository.selectNewOrderReturnOrder();
    }

    @Override
    public List<Orders> getOrdersUnDelivered() {
        return orderRepository.selectOrdersUndelivered();
    }

    @Override
    public List<Orders> getOrdersThisWeek() {
        return orderRepository.findAllOrderedThisWeek();
    }

    @Override
    public List<Orders> getOrdersInLast3Month() {
        return orderRepository.findAllOrderedInLast3Months();
    }

    @Override
    public List<Orders> getOrdersInLast6Month() {
        return orderRepository.findAllOrderedInLast6Months();
    }

    @Override
    public List<Orders> getOrdersThisYear() {
        return orderRepository.findAllOrderedThisYear();
    }

    @Override
    public List<Orders> getOrdersDelivered() {
        return orderRepository.selectOrdersDelivered();
    }

    @Override
    public boolean markOrderAsDelivered(Long id) {
        return orderRepository.markOrderAsDelivered(id);
    }

//    public static void main(String[] args){
//        Orders existingOrder = OrderService.getInstance().getById(1004L).orElseThrow(
//                () -> new ResourceNotFoundException("Order not found")
//        );
//        Customers existingCustomer = CustomerService.getInstance().getById(existingOrder.getCustomerID()).orElseThrow(
//                () -> new ResourceNotFoundException("Customer not found")
//        );
////        System.out.println(existingCustomer);
////        System.out.println(existingOrder);
////        List<OrderDetails> orderDetailsList = OrderService.getInstance().getOrderDetailsOfOrder(existingOrder.getId());
////        List<ProductsOrderDetails> productsOrderDetailsList = getProductsDetailsFromOrderDetails(orderDetailsList);
////
////        for (ProductsOrderDetails productsOrderDetails : productsOrderDetailsList) {
////            System.out.println(productsOrderDetails.getOrderDetails().getPrice() + " " + productsOrderDetails.getOrderDetails().getTotal());
////            System.out.println(productsOrderDetails.getProducts().getName() );
////            System.out.println(productsOrderDetails.getCategories().getName());
////            System.out.println(productsOrderDetails.getSuppliers().getCompanyName());
////        }
//    }
//
////    private static List<ProductsOrderDetails> getProductsDetailsFromOrderDetails(List<OrderDetails> orderDetailsList){
////        List<ProductsOrderDetails> productsOrderDetailsList = new ArrayList<>();
////        for (OrderDetails orderDetails : orderDetailsList) {
////            Products existingProduct = ProductService.getInstance().getById(orderDetails.getProductId()).orElseThrow(
////                    () -> new ResourceNotFoundException("Product not found")
////            );
////            Suppliers existingSupplier = SupplierService.getInstance().getById(existingProduct.getSupplierId()).orElseThrow(
////                    () -> new ResourceNotFoundException("Supplier not found")
////            );
////            Categories existingCategory = CategoryService.getInstance().getById(existingProduct.getCategoryId()).orElseThrow(
////                    () -> new ResourceNotFoundException("Category not found")
////            );
////            ProductsOrderDetails productsOrderDetails = new ProductsOrderDetails(orderDetails,
////                    existingProduct, existingCategory,
////                    existingSupplier);
////            productsOrderDetailsList.add(productsOrderDetails);
////        }
////        return productsOrderDetailsList;
////    }
}
