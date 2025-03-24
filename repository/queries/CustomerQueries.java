package devcldkai.kaipizzas.repository.queries;

public class CustomerQueries {

    private CustomerQueries(){}

    public static final String SELECT_BY_ID = "select * from Customers WHERE CustomerID = ?";

    public static final String SELECT_BY_ACCOUNT_ID = "select * from Customers WHERE AccountID = ?";

    public static final String SELECT_BY_EMAIL_PHONE_NAME = "select * from Customers WHERE Email = ? AND Phone = ?";

    public static final String INSERT = "insert into Customers(ContactName, Address, Phone, Email, AccountID) values (?,?,?,?,?)";

    public static final String IS_EXIST = "select * from Customers where Email = ? AND Phone = ?";
}
