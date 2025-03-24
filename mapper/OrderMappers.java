package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMappers {

    private OrderMappers() {
    }
    
    public static Orders mapToOrders(ResultSet resultSet) throws SQLException {
            Orders orders = new Orders();
            orders.setId(resultSet.getLong("OrderID"));
            orders.setCustomerID(resultSet.getLong("CustomerID"));

            // Chuyển đổi các cột DATETIME sang LocalDateTime
            orders.setOrderDate(
                    resultSet.getTimestamp("OrderDate") != null
                            ? resultSet.getTimestamp("OrderDate").toLocalDateTime()
                            : null
            );
            orders.setRequiredDate(
                    resultSet.getTimestamp("RequiredDate") != null
                            ? resultSet.getTimestamp("RequiredDate").toLocalDateTime()
                            : null
            );
            orders.setShippedDate(
                    resultSet.getTimestamp("ShippedDate") != null
                            ? resultSet.getTimestamp("ShippedDate").toLocalDateTime()
                            : null
            );

            // Map các cột còn lại
            orders.setFreight(resultSet.getDouble("Freight"));
            orders.setTotal(resultSet.getDouble("Total"));
            orders.setShipAddress(resultSet.getString("ShipAddress"));
            orders.setStatus(resultSet.getString("Status"));
            orders.setNote(resultSet.getString("Note"));
            orders.setPaymentMethod(resultSet.getString("PaymentMethod"));
            return orders;
        }
}

