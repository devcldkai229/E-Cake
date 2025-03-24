package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.repository.ProductRepository;
import devcldkai.kaipizzas.repository.impl.ProductRepositoryImpl;
import devcldkai.kaipizzas.service.IProductService;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {

    private final ProductRepository productRepository = new ProductRepositoryImpl();

    public static IProductService getInstance(){
        return new ProductService();
    }

    @Override
    public List<Products> getAll() {
        return productRepository.selectAllProducts();
    }

    @Override
    public List<Products> getByName(String name) {
        return productRepository.selectProductsByName(name);
    }

    @Override
    public Optional<Products> getById(Long id) {
        return productRepository.selectProductById(id);
    }

    @Override
    public boolean isExist(Long id) {
        return productRepository.isExistProductById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public void save(Products product) {
        productRepository.insertProduct(product);
    }

    @Override
    public List<Products> productsOfSupplier(int supplierId) {
        return productRepository.selectProductsBySupplierId(supplierId);
    }

    @Override
    public List<Products> productsOfCategory(int categoryId) {
        return productRepository.selectProductsByCategory(categoryId);
    }

    @Override
    public boolean setUncategorized(Long productId) {
        return productRepository.updateProductUncategorized(0, productId);
    }

    @Override
    public boolean updateName(String name, long productId) {
        return productRepository.updateName(name, productId);
    }

    @Override
    public boolean updateCategory(int category, long productId) {
        return productRepository.updateCategory(category, productId);
    }

    @Override
    public boolean updateSupplier(int supplier, long productId) {
        return productRepository.updateSupplier(supplier, productId);
    }

    @Override
    public boolean updateQuantity(long quantity, long productId) {
        return productRepository.updateQuantity(quantity, productId);
    }

    @Override
    public boolean updatePrice(double price, long productId) {
        return productRepository.updatePrice(price, productId);
    }

    @Override
    public boolean updateImage(String image, long productId) {
        return productRepository.updateImage(image, productId);
    }

    @Override
    public boolean updateDescription(String description, long productId) {
        return productRepository.updateDescription(description, productId);
    }

}
