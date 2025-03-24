package devcldkai.kaipizzas.repository.queries;

public class ProductQueries {

    private ProductQueries() {}

    public static final String SELECT_ALL = "select * from Products";

    public static final String SELECT_BY_NAME = "select * from Products where ProductName like ?";

    public static final String SELECT_BY_ID = "select * from Products where ProductID = ?";

    public static final String EXIST_BY_ID = "select 1 from Products where ProductID = ?";

    public static final String DELETE_BY_ID = "delete from Products where ProductID = ?";

    public static final String INSERT_PRODUCT = "insert into Products (ProductName, SupplierID, CategoryID, Quantity, UnitPrice, ProductImage, Description) VALUES(?, ?, ?, ?, ?, ?, ?)";

    public static final String PRODUCTS_OF_SUPPLIER = "select * from Products where SupplierID = ?";

    public static final String PRODUCTS_OF_CATEGORY= "select * from Products where CategoryID = ?";

    public static final String UPDATE_PRODUCTS_CATEGORY = "update Products set CategoryID = ? where ProductID = ?";

    public static final String UPDATE_NAME_PRODUCT = "update Products set ProductName = ? where ProductID = ?";

    public static final String UPDATE_SUPPLIER_ID = "update Products set SupplierID = ? where ProductID = ?";

    public static final String UPDATE_CATEGORY_ID = "update Products set CategoryID = ? where ProductID = ?";

    public static final String UPDATE_QUANTITY = "update Products set Quantity = ? where ProductID = ?";

    public static final String UPDATE_UNIT_PRICE = "update Products set UnitPrice = ? where ProductID = ?";

    public static final String UPDATE_PRODUCT_IMAGE = "update Products set ProductImage = ? where ProductID = ?";

    public static final String UPDATE_DESCRIPTION = "update Products set Description = ? where ProductID = ?";

}
