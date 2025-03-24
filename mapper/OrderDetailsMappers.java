package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsMappers {

    private OrderDetailsMappers(){}

    public static OrderDetails mapToOrderDetails(ResultSet resultSet) throws SQLException {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(resultSet.getLong("OrderID"));
        orderDetails.setProductId(resultSet.getLong("ProductID"));
        orderDetails.setQuantity(resultSet.getInt("Quantity"));
        orderDetails.setPrice(resultSet.getDouble("UnitPrice"));
        orderDetails.setSize(resultSet.getString("Size"));
        orderDetails.setTotal(resultSet.getDouble("Total"));
        return orderDetails;
    }

}
