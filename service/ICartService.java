package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.CartItem;

import java.util.List;
import java.util.Map;

public interface ICartService {

    void addItem(Long idProduct, Integer quantity, String size, Map<Long, Map<String, Integer>> cart);

    List<CartItem> getAllProducts(Map<Long, Map<String, Integer>> cart);

    Integer totalQuantity(Map<Long, Map<String, Integer>> cart);

    Integer totalQuantityByCartItem(List<CartItem> cartItems);

    void removeItem(Long idProduct, String size, Map<Long, Map<String, Integer>> cart);
}
