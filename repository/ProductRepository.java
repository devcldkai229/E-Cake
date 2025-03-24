package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.domain.entities.Products;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Products> selectAllProducts();

    List<Products> selectProductsByName(String name);

    Optional<Products> selectProductById(Long id);

    boolean isExistProductById(Long id);

    void deleteProductById(Long id);

    void insertProduct(Products product);

    List<Products> selectProductsBySupplierId(int supplierId);

    List<Products> selectProductsByCategory(int categoryID);

    boolean updateProductUncategorized(int categoryID, long productId);

    boolean updateName(String name, long productId);

    boolean updateCategory(int categoryId, long productId);

    boolean updateSupplier(int supplierId, long productId);

    boolean updateQuantity(long quantity, long productId);

    boolean updatePrice(double price, long productId);

    boolean updateImage(String image, long productId);

    boolean updateDescription(String description, long productId);
}



