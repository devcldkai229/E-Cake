package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.mapper.CategoryMappers;
import devcldkai.kaipizzas.mapper.ProductMappers;
import devcldkai.kaipizzas.repository.CategoryRepository;
import devcldkai.kaipizzas.repository.queries.CategoryQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public List<Categories> selectAllCategories() {
        List<Categories> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CategoryQueries.SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(CategoryMappers.mapToCategory(resultSet));
            }
            return categories;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Categories> selectCategoriesByName(String name) {
        List<Categories> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CategoryQueries.SELECT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(CategoryMappers.mapToCategory(resultSet));
            }
            return categories;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Optional<Categories> selectCategoriesById(Integer id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CategoryQueries.SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return Optional.of(CategoryMappers.mapToCategory(resultSet));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Products> selectAllProductsFromCategoryId(int categoryId) {
        List<Products> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CategoryQueries.SELECT_ALL_PRODUCTS_BY_CATEGORY_ID);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(ProductMappers.mapToProducts(resultSet));
            }
            return products;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteCategoryById(Integer id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CategoryQueries.DELETE_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void save(Categories category) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CategoryQueries.INSERT);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
