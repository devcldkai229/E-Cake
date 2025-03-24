package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.mapper.ProductMappers;
import devcldkai.kaipizzas.repository.ProductRepository;
import devcldkai.kaipizzas.repository.queries.ProductQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Products> selectAllProducts() {
        List<Products> products = new ArrayList<Products>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(ProductMappers.mapToProducts(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Products> selectProductsByName(String name) {
        List<Products> products = new ArrayList<Products>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.SELECT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(ProductMappers.mapToProducts(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Optional<Products> selectProductById(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(ProductMappers.mapToProducts(resultSet));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean isExistProductById(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.EXIST_BY_ID);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteProductById(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertProduct(Products product) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getSupplierId());
            preparedStatement.setInt(3, product.getCategoryId());
            preparedStatement.setLong(4, product.getQuantity());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.setString(6, product.getProductImgUrl());
            preparedStatement.setString(7, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Products> selectProductsBySupplierId(int supplierId) {
        List<Products> products = new ArrayList<Products>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.PRODUCTS_OF_SUPPLIER);
            preparedStatement.setInt(1, supplierId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(ProductMappers.mapToProducts(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Products> selectProductsByCategory(int categoryID) {
        List<Products> products = new ArrayList<Products>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.PRODUCTS_OF_CATEGORY);
            preparedStatement.setInt(1, categoryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(ProductMappers.mapToProducts(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean updateProductUncategorized(int categoryID, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_PRODUCTS_CATEGORY);
            preparedStatement.setInt(1, categoryID);
            preparedStatement.setLong(2, productId);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateName(String name, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_NAME_PRODUCT);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, productId);

            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCategory(int categoryId, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_CATEGORY_ID);
            preparedStatement.setInt(1, categoryId);
            preparedStatement.setLong(2, productId);

            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSupplier(int supplierId, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_SUPPLIER_ID);
            preparedStatement.setInt(1, supplierId);
            preparedStatement.setLong(2, productId);

            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateQuantity(long quantity, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_QUANTITY);
            preparedStatement.setLong(1, quantity);
            preparedStatement.setLong(2, productId);

            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePrice(double price, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_UNIT_PRICE);
            preparedStatement.setDouble(1, price);
            preparedStatement.setLong(2, productId);

            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateImage(String image, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_PRODUCT_IMAGE);
            preparedStatement.setString(1, image);
            preparedStatement.setLong(2, productId);

            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDescription(String description, long productId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(ProductQueries.UPDATE_DESCRIPTION);
            preparedStatement.setString(1, description);
            preparedStatement.setLong(2, productId);

            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
