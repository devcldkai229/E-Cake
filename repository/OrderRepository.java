package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.constant.OrderStatus;
import devcldkai.kaipizzas.domain.entities.OrderDetails;
import devcldkai.kaipizzas.domain.entities.Orders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Orders> selectAllOrders();

    Optional<Orders> selectOrderById(Long id);

    void insertOrder(Orders order);

    boolean updateShipDateOrder(LocalDateTime newDate, Long id);

    void updateStatusOrder(String newStatus, Long id);

    void deleteOrderById(Long id);

    void deleteItemsFromOrderById(Long id);

    List<OrderDetails> selectOrderDetailsByID(Long id);

    Optional<Orders> selectNewOrderReturnOrder();

    List<Orders> selectOrdersUndelivered();

    List<Orders> selectAllOrdersByStatus(String status);

    List<Orders> selectOrdersDelivered();

    List<Orders> findAllOrderedThisWeek();

    List<Orders> findAllOrderedInLast3Months();

    List<Orders> findAllOrderedInLast6Months();

    List<Orders> findAllOrderedThisYear();

    List<Orders> findAllOrderedDeliveredByStartAndEndDate(LocalDateTime startDate, LocalDateTime endDate);

    boolean markOrderAsDelivered(Long id);
}
