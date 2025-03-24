package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Products;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Categories> selectAllCategories();

    List<Categories> selectCategoriesByName(String name);

    Optional<Categories> selectCategoriesById(Integer id);

    List<Products> selectAllProductsFromCategoryId(int categoryId);

    boolean deleteCategoryById(Integer id);

    void save(Categories category);
}
