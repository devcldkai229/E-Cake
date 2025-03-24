package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.mapper.ProductMappers;
import devcldkai.kaipizzas.mapper.SupplierMappers;
import devcldkai.kaipizzas.repository.SupplierRepository;
import devcldkai.kaipizzas.repository.queries.SupplierQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SupplierRepositoryImpl implements SupplierRepository {

    @Override
    public List<Suppliers> selectALLSuppliers() {
        List<Suppliers> suppliers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(SupplierQueries.SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                suppliers.add(SupplierMappers.mapToSuppliers(resultSet));
            }
            return suppliers;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public List<Suppliers> selectSuppliersByName(String name) {
        List<Suppliers> suppliers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(SupplierQueries.SELECT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                suppliers.add(SupplierMappers.mapToSuppliers(resultSet));
            }
            return suppliers;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public Optional<Suppliers> selectSuppliersById(int id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(SupplierQueries.SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if((resultSet.next())){
                    return Optional.of(SupplierMappers.mapToSuppliers(resultSet));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Products> selectProductsBySupplierId(int id) {
        List<Products> suppliers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(SupplierQueries.SELECT_PRODUCTS_BY_SUPPLIER_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                suppliers.add(ProductMappers.mapToProducts(resultSet));
            }
            return suppliers;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(SupplierQueries.DELETE_SUPPLIER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(Suppliers suppliers) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(SupplierQueries.INSERT);
            preparedStatement.setString(1, suppliers.getCompanyName());
            preparedStatement.setString(2, suppliers.getAddress());
            preparedStatement.setString(3, suppliers.getPhoneNumber());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
