package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.dto.OrderReportDTO;
import devcldkai.kaipizzas.domain.entities.Customers;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.mapper.OrderReportMappers;
import devcldkai.kaipizzas.repository.CustomerRepository;
import devcldkai.kaipizzas.repository.OrderRepository;
import devcldkai.kaipizzas.repository.impl.CustomerRepositoryImpl;
import devcldkai.kaipizzas.repository.impl.OrderRepositoryImpl;
import devcldkai.kaipizzas.service.IOrderReportStatisticService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderReportStatisticService implements IOrderReportStatisticService {

    public static IOrderReportStatisticService getInstance(){
        return new OrderReportStatisticService();
    }

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<OrderReportDTO> getAllDeliveredByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) throws SQLException {
        List<OrderReportDTO> orderReportDTOs = new ArrayList<>();

        List<Orders> orders = orderRepository.findAllOrderedDeliveredByStartAndEndDate(startDate, endDate);
        for (Orders order : orders) {
            OrderReportDTO orderReportDTO = OrderReportMappers.mapToOrderReportDTO(order);
            Customers existingCustomer = CustomerService.getInstance().getById(order.getCustomerID()).orElseThrow(
                    () -> new ResourceNotFoundException("Customer not found with id: " + order.getCustomerID())
            );
            orderReportDTO.setCustomerName(existingCustomer.getContactName());
            orderReportDTO.setPhone(existingCustomer.getPhoneNumber());
            orderReportDTOs.add(orderReportDTO);
        }

        return orderReportDTOs;
    }
}
