package devcldkai.kaipizzas.repository.impl;

import devcldkai.kaipizzas.constant.OrderStatus;
import devcldkai.kaipizzas.domain.entities.OrderDetails;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.mapper.OrderDetailsMappers;
import devcldkai.kaipizzas.mapper.OrderMappers;
import devcldkai.kaipizzas.repository.OrderRepository;
import devcldkai.kaipizzas.repository.queries.OrderQueries;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public List<Orders> selectAllOrders() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Optional<Orders> selectOrderById(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return Optional.of(OrderMappers.mapToOrders(resultSet));
                }

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void insertOrder(Orders order) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.INSERT_ORDER);
            preparedStatement.setLong(1, order.getCustomerID());
            preparedStatement.setObject(2, order.getOrderDate());
            preparedStatement.setObject(3, order.getRequiredDate());
            preparedStatement.setDouble(4, order.getFreight());
            preparedStatement.setString(5, order.getShipAddress());
            preparedStatement.setDouble(6, order.getTotal());
            preparedStatement.setString(7, order.getStatus());
            preparedStatement.setString(8, order.getNote());
            preparedStatement.setString(9, order.getPaymentMethod());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateShipDateOrder(LocalDateTime newDate, Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.UPDATE_SHIP_DATE);
            preparedStatement.setObject(1, newDate);
            preparedStatement.setLong(2, id);
            return preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateStatusOrder(String newStatus, Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.UPDATE_STATUS);
            preparedStatement.setString(1, newStatus);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.DELETE_ORDER);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItemsFromOrderById(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.DELETE_ALL_LINE_ITEMS_FROM_ORDER);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderDetails> selectOrderDetailsByID(Long id) {
        List<OrderDetails> orderDetails = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDER_DETAILS_BY_ORDER_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderDetails.add(OrderDetailsMappers.mapToOrderDetails(resultSet));
            }
            return orderDetails;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public Optional<Orders> selectNewOrderReturnOrder() {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_NEW_ORDER_RETURN_ID);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return Optional.of(OrderMappers.mapToOrders(resultSet));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Orders> selectOrdersUndelivered() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDERS_UNDELIVERED);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> selectAllOrdersByStatus(String status) {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ALL_ORDERS_BY_STATUS);
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> selectOrdersDelivered() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDERS_DELIVERED);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> findAllOrderedThisWeek() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDERS_BY_RANGE_WEEK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> findAllOrderedInLast3Months() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDERS_BY_RANGE_3MONTH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> findAllOrderedInLast6Months() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDERS_BY_RANGE_6MONTH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> findAllOrderedThisYear() {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDERS_BY_RANGE_YEAR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> findAllOrderedDeliveredByStartAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.SELECT_ORDERS_BY_START_END_DATE);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(startDate));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(endDate));
            preparedStatement.setString(3, OrderStatus.DELIVERED);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(OrderMappers.mapToOrders(resultSet));
            }
            return orders;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean markOrderAsDelivered(Long id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(OrderQueries.MARK_ORDER_COMPLETED);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}
