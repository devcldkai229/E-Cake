package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.repository.CategoryRepository;
import devcldkai.kaipizzas.repository.impl.CategoryRepositoryImpl;
import devcldkai.kaipizzas.service.ICategoryService;

import java.util.List;
import java.util.Optional;

public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    public static ICategoryService getInstance(){
        return new CategoryService();
    }

    @Override
    public List<Categories> getAll() {
        return categoryRepository.selectAllCategories();
    }

    @Override
    public List<Categories> getByName(String name) {
        return categoryRepository.selectCategoriesByName(name);
    }

    @Override
    public Optional<Categories> getById(Integer id) {
        return categoryRepository.selectCategoriesById(id);
    }

    @Override
    public List<Products> getProductsByCategory(Integer id) {
        return categoryRepository.selectAllProductsFromCategoryId(id);
    }

    @Override
    public boolean delete(Integer id) {
        return categoryRepository.deleteCategoryById(id);
    }

    @Override
    public void save(Categories category) {
        categoryRepository.save(category);
    }

    public static void main(String[] args){
        List<Categories> categoriesListHasDefault = CategoryService.getInstance().getAll();
        List<Categories> categoriesList = categoriesListHasDefault;
        categoriesList.forEach(System.out::println);
    }
}
