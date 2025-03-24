package devcldkai.kaipizzas.repository.queries;

public class SupplierQueries {

    private SupplierQueries() {}

    public static final String SELECT_ALL = "select * from Suppliers";

    public static final String SELECT_BY_NAME = "select * from Suppliers where CompanyName LIKE ?";

    public static final String SELECT_BY_ID = "select * from Suppliers where SupplierID = ?";

    public static final String SELECT_PRODUCTS_BY_SUPPLIER_ID = "select * from Products where SupplierID = ?";

    public static final String DELETE_SUPPLIER_BY_ID = "delete from Suppliers where SupplierID = ?";

    public static final String INSERT = "insert into Suppliers(CompanyName, Address, Phone) VALUES(?,?,?)";

}
