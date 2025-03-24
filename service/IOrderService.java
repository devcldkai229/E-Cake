package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.OrderDetails;
import devcldkai.kaipizzas.domain.entities.Orders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<Orders> getAll();

    Optional<Orders> getById(Long id);

    void save(Orders order);

    boolean updateShippedDate(LocalDateTime newDate, Long id);

    void updateStatus(String newStatus, Long id);

    void delete(Long id);

    List<Orders> getByStatus(String status);

    List<OrderDetails> getOrderDetailsOfOrder(Long id);

    Optional<Orders> getNewestOrder();

    List<Orders> getOrdersUnDelivered();

    List<Orders> getOrdersThisWeek();

    List<Orders> getOrdersInLast3Month();

    List<Orders> getOrdersInLast6Month();

    List<Orders> getOrdersThisYear();

    List<Orders> getOrdersDelivered();

    boolean markOrderAsDelivered(Long id);
}
