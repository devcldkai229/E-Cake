package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.OrderDetails;

public interface IOrderDetailsService {

    void updateQuantity(int quantity, Long orderId, Long productID);

    void delete(Long orderId, Long productID);

    void save(OrderDetails orderDetails);

}
