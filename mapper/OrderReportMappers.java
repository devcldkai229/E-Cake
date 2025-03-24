package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.dto.OrderReportDTO;
import devcldkai.kaipizzas.domain.entities.Orders;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class OrderReportMappers {

    private OrderReportMappers() {}

    public static OrderReportDTO mapToOrderReportDTO(Orders orders) throws SQLException {
        OrderReportDTO orderReportDTO = new OrderReportDTO();
        orderReportDTO.setId(orders.getId());
        orderReportDTO.setFreight(orders.getFreight());
        orderReportDTO.setTotal(orders.getTotal());
        orderReportDTO.setShipAddress(orders.getShipAddress());
        orderReportDTO.setNote(orders.getNote());
        orderReportDTO.setStatus(orders.getStatus());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String orderedDate = orders.getOrderDate().format(formatter);
        String requiredDate = orders.getRequiredDate().format(formatter);
        String shippedDate = orders.getShippedDate().format(formatter);
        orderReportDTO.setOrderDate(orderedDate);
        orderReportDTO.setRequiredDate(requiredDate);
        orderReportDTO.setShippedDate(shippedDate);
        orderReportDTO.setPaymentMethod(orders.getPaymentMethod());

        return orderReportDTO;
    }
}
