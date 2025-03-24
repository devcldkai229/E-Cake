package devcldkai.kaipizzas.repository.queries;

public class OrderQueries {

    private OrderQueries(){}

    public static final String SELECT_ALL = "select * from orders";

    public static final String SELECT_BY_ID = "select * from orders where OrderID = ?";

    public static final String INSERT_ORDER = "insert into orders(CustomerID, OrderDate, RequiredDate, Freight, ShipAddress, Total, Status, Note, PaymentMethod) VALUES(?,?,?,?,?,?,?,?,?)";

    public static final String UPDATE_SHIP_DATE = "update orders set ShippedDate = ? where OrderID = ?";

    public static final String UPDATE_STATUS = "update orders set Status = ? where OrderID = ?";

    public static final String DELETE_ORDER = "delete from orders where OrderID = ?";

    public static final String SELECT_ORDER_DETAILS_BY_ORDER_ID = "select * from OrderDetails where OrderID = ?";

    public static final String SELECT_NEW_ORDER_RETURN_ID = "select * from Orders where OrderID = IDENT_CURRENT('Orders')";

    public static final String SELECT_ORDERS_UNDELIVERED = "select * from orders where Status = 'pending'";

    public static final String SELECT_ORDERS_DELIVERED = "select * from orders where Status = 'delivered'";

    public static final String DELETE_ALL_LINE_ITEMS_FROM_ORDER = "delete from OrderDetails where OrderID = ?";

    public static final String MARK_ORDER_COMPLETED = "update orders set Status = 'delivered' where OrderID = ?";

    public static final String SELECT_ALL_ORDERS_BY_STATUS = "select * from orders where status = ?";

    public static final String SELECT_ORDERS_BY_RANGE_3MONTH = "select * from orders where OrderDate >= DATEADD(MONTH, -3, GETDATE())";

    public static final String SELECT_ORDERS_BY_RANGE_6MONTH = "select * from orders where OrderDate >= DATEADD(MONTH, -6, GETDATE())";

    public static final String SELECT_ORDERS_BY_RANGE_WEEK = "select * from orders where OrderDate >= DATEADD(WEEK, -1, GETDATE())";

    public static final String SELECT_ORDERS_BY_RANGE_YEAR = "select * from orders where OrderDate >= DATEADD(YEAR, -1, GETDATE())";

    public static final String SELECT_ORDERS_BY_START_END_DATE = "SELECT * FROM Orders WHERE ShippedDate BETWEEN ? AND ? AND Status = ?";

}
