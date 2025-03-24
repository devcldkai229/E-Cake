package devcldkai.kaipizzas.repository.impl;


import devcldkai.kaipizzas.domain.entities.OrderDetails;
import devcldkai.kaipizzas.repository.OrderDetailsRepository;
import devcldkai.kaipizzas.repository.queries.OrderDetailsQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    @Override
    public void updateQuantity(int quantity, Long orderId, Long productID) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderDetailsQueries.UPDATE_QUANTITY);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setLong(2, orderId);
            preparedStatement.setLong(3, productID);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByID(Long orderId, Long productID) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderDetailsQueries.DELETE_BY_ID);
            preparedStatement.setLong(1, orderId);
            preparedStatement.setLong(2, productID);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(OrderDetails orderDetails) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderDetailsQueries.INSERT_ORDER_DETAILS);
            preparedStatement.setLong(1, orderDetails.getOrderId());
            preparedStatement.setLong(2, orderDetails.getProductId());
            preparedStatement.setString(3, orderDetails.getSize());
            preparedStatement.setDouble(4, orderDetails.getPrice());
            preparedStatement.setInt(5, orderDetails.getQuantity());
            preparedStatement.setDouble(6, orderDetails.getTotal());

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
