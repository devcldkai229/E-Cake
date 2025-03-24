package devcldkai.kaipizzas.domain.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Long, Map<String, Integer>> carts;

    public Cart() {
        this.carts = new HashMap<Long, Map<String, Integer>>();
    }

    public Map<Long, Map<String, Integer>> getCarts() {
        return carts;
    }

    public void setCarts(Map<Long, Map<String, Integer>> carts) {
        this.carts = carts;
    }

    public void setCarts(List<CartItem> carts) {
        for (CartItem items : carts) {
            if(this.carts.containsKey(items.getProducts().getId())){
                if(this.carts.get(items.getProducts().getId()).containsKey(items.getSize())){
                    this.carts.get(items.getProducts().getId()).put(items.getSize(), items.getQuantity());
                }
            } else {
                Map<String, Integer> map = new HashMap<>();
                map.put(items.getSize(), items.getQuantity());
                this.carts.put(items.getProducts().getId(), map);
            }
        }
    }

    public Map<String, Integer> getQuantityAndSize(Long productId){
        return carts.get(productId);
    }
}
