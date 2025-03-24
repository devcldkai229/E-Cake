package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Customers;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.domain.dto.OrdersDashBoardDTO;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.IOrdersDashBoardAdminService;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrdersDashBoardAdminService implements IOrdersDashBoardAdminService {

    public static IOrdersDashBoardAdminService getInstance(){
        return new OrdersDashBoardAdminService();
    }

    @Override
    public List<OrdersDashBoardDTO> getAllOrdersDashBoard() {
        List<Orders> ordersList = OrderService.getInstance().getAll();
        List<OrdersDashBoardDTO> ordersDashBoardDTOList = new ArrayList<OrdersDashBoardDTO>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ordersList.stream().forEach(
                order -> {
                    Customers inappropriateCustomer = CustomerService.getInstance()
                            .getById(order.getCustomerID())
                            .orElseThrow(
                            () -> new ResourceNotFoundException("Customer not found")
                    );
                    OrdersDashBoardDTO ordersDashBoardDTO = new OrdersDashBoardDTO(
                            order.getCustomerID(), inappropriateCustomer.getContactName(), order.getFreight(),
                            order.getId(), order.getNote(), order.getOrderDate().format(formatter),
                            order.getPaymentMethod(), inappropriateCustomer.getPhoneNumber(),
                            order.getRequiredDate().format(formatter), order.getShipAddress(),
                            order.getShippedDate()!=null?order.getShippedDate().format(formatter):"#NoData",
                            order.getStatus(), order.getTotal()
                    );
                    ordersDashBoardDTOList.add(ordersDashBoardDTO);
                }
        );
        return ordersDashBoardDTOList;
    }

    @Override
    public int totalProductsDashBoard() {
        return ProductService.getInstance().getAll().size();
    }

    @Override
    public int totalOrdersUndeliveredDashBoard() {
        return OrderService.getInstance().getOrdersUnDelivered().size();
    }

    @Override
    public int totalOrdersDeliveredDashBoard() {
        return OrderService.getInstance().getOrdersDelivered().size();
    }

    @Override
    public int totalOrdersDashBoard() {
        return OrderService.getInstance().getAll().size();
    }

    @Override
    public double totalSalesDashBoard() {
        return OrderService.getInstance().getAll().stream().mapToDouble(Orders::getTotal).sum();
    }

    public static void main(String[] args){
        List<OrdersDashBoardDTO> ordersDashBoardDTOS = OrdersDashBoardAdminService.getInstance().getAllOrdersDashBoard();
        ordersDashBoardDTOS.forEach(System.out::println);
    }
}
