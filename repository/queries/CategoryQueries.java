package devcldkai.kaipizzas.repository.queries;

public class CategoryQueries {

    private CategoryQueries() {}

    public static final String SELECT_ALL = "select * from Categories";

    public static final String SELECT_BY_ID = "select * from Categories where CategoryID = ?";

    public static final String SELECT_BY_NAME = "select * from Categories where CategoryName like ?";

    public static final String DELETE_PRODUCTS_BY_CATEGORY_ID = "delete from Products where CategoryID = ?";

    public static final String SELECT_ALL_PRODUCTS_BY_CATEGORY_ID = "select * from Products where CategoryID = ?";

    public static final String DELETE_CATEGORY_BY_ID = "delete from Categories where CategoryID = ?";

    public static final String INSERT = "insert into Categories (CategoryName, Description) values (?, ?)";
}
