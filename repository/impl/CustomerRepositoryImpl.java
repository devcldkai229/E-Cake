package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.domain.entities.Customers;
import devcldkai.kaipizzas.mapper.CustomerMappers;
import devcldkai.kaipizzas.repository.CustomerRepository;
import devcldkai.kaipizzas.repository.queries.CustomerQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Optional<Customers> selectCustomerById(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CustomerQueries.SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(CustomerMappers.mapToCustomers(resultSet));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Customers> selectCustomerByAccountId(String accountId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CustomerQueries.SELECT_BY_ACCOUNT_ID);
            preparedStatement.setString(1, accountId);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(CustomerMappers.mapToCustomers(resultSet));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(Customers customers) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CustomerQueries.INSERT);
            preparedStatement.setString(1, customers.getContactName());
            preparedStatement.setString(2, customers.getAddress());
            preparedStatement.setString(3, customers.getPhoneNumber());
            preparedStatement.setString(4, customers.getEmail());
            preparedStatement.setString(5, customers.getAccountId()==null?"#NoData":customers.getAccountId());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Customers> selectCustomerByEmailAndPhone(Customers customers) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CustomerQueries.SELECT_BY_EMAIL_PHONE_NAME);
            preparedStatement.setString(1, customers.getEmail());
            preparedStatement.setString(2, customers.getPhoneNumber());
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(CustomerMappers.mapToCustomers(resultSet));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean existsCustomerByEmailAndPhone(Customers customers) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(CustomerQueries.IS_EXIST);
            preparedStatement.setString(1, customers.getEmail());
            preparedStatement.setString(2, customers.getPhoneNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
