package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.mapper.AccountsMappers;
import devcldkai.kaipizzas.mapper.OrderMappers;
import devcldkai.kaipizzas.repository.UserRepository;
import devcldkai.kaipizzas.repository.queries.UserQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {


    @Override
    public void save(Accounts accounts) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_CREATE_USER_SQL);
            preparedStatement.setString(1, accounts.getId());
            preparedStatement.setString(2, accounts.getUsername());
            preparedStatement.setString(3, accounts.getPassword());
            preparedStatement.setString(4, accounts.getEmail());
            preparedStatement.setString(5, accounts.getFirstName());
            preparedStatement.setString(6, accounts.getLastName());
            preparedStatement.setDouble(7, accounts.getPointRewards());
            preparedStatement.setDate(8, accounts.getDateOfBirth());
            preparedStatement.setString(9, accounts.getPhone());
            preparedStatement.setString(10, accounts.getImageUrl());
            preparedStatement.setInt(11, accounts.getRoleId());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePatch(Accounts accounts) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_CREATE_USER_SIGN_UP_SQL);
            preparedStatement.setString(1, accounts.getId());
            preparedStatement.setString(2, accounts.getUsername());
            preparedStatement.setString(3, accounts.getEmail());
            preparedStatement.setString(4, accounts.getPassword());
            preparedStatement.setDouble(5, accounts.getPointRewards());
            preparedStatement.setInt(6, accounts.getRoleId());
            preparedStatement.setString(7, accounts.getImageUrl());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Accounts accounts) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_DELETE_USER_SQL);
            preparedStatement.setString(1, accounts.getUsername());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Accounts> findAll() {
        List<Accounts> accounts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_GET_ALL_USER_SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                accounts.add(AccountsMappers.mapToAccounts(rs));
            }
            return accounts;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Optional<Accounts> findById(String id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_FIND_USER_SQL_BY_ID);
            preparedStatement.setString(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    return Optional.of(AccountsMappers.mapToAccounts(resultSet));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Accounts> findByUsername(String username) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_FIND_USER_SQL);
            preparedStatement.setString(1, username);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    return Optional.of(AccountsMappers.mapToAccounts(resultSet));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Orders> findAllOrderedOfAccount(String accountID) {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_GET_ORDERS_USER_BY_ID_SQL);
            preparedStatement.setString(1, accountID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
            return orders;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_PASSWORD_SQL);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmail(String username, String newEmail) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_EMAIL_SQL);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateFirstName(String username, String newFirstName) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_FIRST_NAME_SQL);
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateLastName(String username, String newLastName) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_LAST_NAME_SQL);
            preparedStatement.setString(1, newLastName);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePhone(String username, String newPhone) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_PHONE_SQL);
            preparedStatement.setString(1, newPhone);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDateOfBirth(String username, Date newDateOfBirth) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_DOB_SQL);
            preparedStatement.setDate(1, newDateOfBirth);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateImageUrl(String username, String newImageUrl) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_IMAGE_SQL);
            preparedStatement.setString(1, newImageUrl);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePointRewards(String username, double pointRewards) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_POINT_REWARDS_SQL);
            preparedStatement.setDouble(1, pointRewards);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStatus(String accountID, String newStatus) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_STATUS_SQL);
            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, accountID);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean userWithEmailExists(String email) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_USER_EXISTS_BY_EMAIL_SQL);
            preparedStatement.setString(1, email);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()) {
                    return true;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAbout(String about, String username) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(UserQueries.DEF_PATCH_UPDATE_USER_ABOUT_SQL);
            preparedStatement.setString(1, about);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
