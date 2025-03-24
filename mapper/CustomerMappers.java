package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.Customers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMappers {

    private CustomerMappers() {}

    public static Customers mapToCustomers(ResultSet resultSet) throws SQLException {
        Customers customers = new Customers();
        customers.setId(resultSet.getLong("CustomerID"));
        customers.setContactName(resultSet.getString("ContactName"));
        customers.setEmail(resultSet.getString("Email"));
        customers.setAddress(resultSet.getString("Address"));
        customers.setPhoneNumber(resultSet.getString("Phone"));
        customers.setAccountId(resultSet.getString("AccountID")==null?"":resultSet.getString("AccountID"));
        return customers;
    }

}
