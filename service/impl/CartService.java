package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.CartItem;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.ICartService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService implements ICartService {

    public static ICartService getInstance() {
        return new CartService();
    }


    @Override
    public void addItem(Long idProduct, Integer quantity, String size, Map<Long, Map<String, Integer>> cart) {
        if(cart.containsKey(idProduct)){
            Map<String, Integer> map = cart.get(idProduct);
            if(map.containsKey(size)){
                map.put(size, map.get(size)+quantity);
            } else {
                map.put(size, quantity);
            }
            cart.put(idProduct, map);
        } else {
            cart.put(idProduct, new HashMap<String, Integer>());
            Map<String, Integer> map = cart.get(idProduct);
            map.put(size, quantity);
            cart.put(idProduct, map);
        }
    }

    @Override
    public List<CartItem> getAllProducts(Map<Long, Map<String, Integer>> cart) {
        List<CartItem> cartItems = new ArrayList<CartItem>();
        for(Map.Entry<Long, Map<String, Integer>> entry : cart.entrySet()){
            Products products = ProductService.getInstance().getById(entry.getKey()).orElseThrow(
                    () -> new ResourceNotFoundException("No product found with id " + entry.getKey())
            );
            Suppliers suppliers = SupplierService.getInstance().getById(products.getSupplierId()).orElseThrow(
                    () -> new ResourceNotFoundException("No supplier found with id " + products.getSupplierId())
            );
            for (Map.Entry<String, Integer> entrySize : entry.getValue().entrySet()) {
                CartItem itemDifSize = new CartItem(products, suppliers);
                itemDifSize.setSize(entrySize.getKey());
                itemDifSize.setQuantity(entrySize.getValue());
                cartItems.add(itemDifSize);
            }
        }
        for(CartItem item : cartItems){
            item.setTotal(item.getQuantity()*item.getPriceWithExtra());
        }
        return cartItems;
    }

    @Override
    public Integer totalQuantity(Map<Long, Map<String, Integer>> cart) {
        int quantity = 0;
       for(Map.Entry<Long, Map<String, Integer>> entry : cart.entrySet()) {
           quantity += entry.getValue()
                   .values()
                   .stream()
                   .mapToInt(x->x)
                   .sum();
       }
       return quantity;
    }

    @Override
    public Integer totalQuantityByCartItem(List<CartItem> cartItems) {
        return cartItems.stream().map(CartItem::getQuantity).mapToInt(x->x).sum();
    }

    @Override
    public void removeItem(Long idProduct, String size, Map<Long, Map<String, Integer>> cart) {
        if(cart.containsKey(idProduct)){
            if(cart.get(idProduct).containsKey(size)){
                cart.get(idProduct).remove(size);
                if(cart.get(idProduct).values().isEmpty()){
                    cart.remove(idProduct);
                }
            }
        }
    }

    public static void main(String[] args){
        LocalDateTime orderDate = LocalDateTime.now();
        LocalDateTime requiredDate = orderDate;
        System.out.println(orderDate);
        System.out.println(requiredDate);
    }
}
