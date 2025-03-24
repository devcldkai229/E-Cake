package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.Products;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Products> getAll();

    List<Products> getByName(String name);

    Optional<Products> getById(Long id);

    boolean isExist(Long id);

    void delete(Long id);

    void save(Products product);

    List<Products> productsOfSupplier(int supplierId);

    List<Products> productsOfCategory(int categoryId);

    boolean setUncategorized(Long productId);

    boolean updateName(String name, long productId);

    boolean updateCategory(int category, long productId);

    boolean updateSupplier(int supplier, long productId);

    boolean updateQuantity(long quantity, long productId);

    boolean updatePrice(double price, long productId);

    boolean updateImage(String image, long productId);

    boolean updateDescription(String description, long productId);
}
