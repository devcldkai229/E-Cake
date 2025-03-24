package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Products;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Categories> getAll();

    List<Categories> getByName(String name);

    Optional<Categories> getById(Integer id);

    List<Products> getProductsByCategory(Integer id);

    boolean delete(Integer id);

    void save(Categories category);
}
