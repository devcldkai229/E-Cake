package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.OrderDetails;
import devcldkai.kaipizzas.repository.OrderDetailsRepository;
import devcldkai.kaipizzas.repository.impl.OrderDetailsRepositoryImpl;
import devcldkai.kaipizzas.service.IOrderDetailsService;

public class OrderDetailsService implements IOrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepositoryImpl();

    public static IOrderDetailsService getInstance() {
        return new OrderDetailsService();
    }

    @Override
    public void updateQuantity(int quantity, Long orderId, Long productID) {
        orderDetailsRepository.updateQuantity(quantity, orderId, productID);
    }

    @Override
    public void delete(Long orderId, Long productID) {
        orderDetailsRepository.deleteByID(orderId, productID);
    }

    @Override
    public void save(OrderDetails orderDetails) {
        orderDetailsRepository.insert(orderDetails);
    }
}
