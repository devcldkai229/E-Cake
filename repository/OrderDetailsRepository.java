package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.domain.entities.OrderDetails;

public interface OrderDetailsRepository {

    void updateQuantity(int quantity, Long orderId, Long productID);

    void deleteByID(Long orderId, Long productID);

    void insert(OrderDetails orderDetails);
}
