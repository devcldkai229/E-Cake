package devcldkai.kaipizzas.repository.queries;

public class OrderDetailsQueries {

    private OrderDetailsQueries(){}

    public static final String UPDATE_QUANTITY = "update OrderDetails set Quantity = ? where OrderId = ? AND ProductID = ?";

    public static final String DELETE_BY_ID = "delete from OrderDetails where OrderId = ? AND ProductID = ?";

    public static final String INSERT_ORDER_DETAILS = "insert into OrderDetails(OrderId, ProductId, Size, UnitPrice, Quantity, Total) values(?,?,?,?,?,?)";
}
