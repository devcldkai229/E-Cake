package devcldkai.kaipizzas.repository.queries;

public class RewardQueries {

    private RewardQueries(){}

    public static final String SELECT_ALL = "select * from rewards";

    public static final String SELECT_BY_ID = "select * from rewards where id=?";

    public static final String SELECT_BY_NAME = "select * from rewards where name=?";

    public static final String INSERT ="insert into rewards (name, point, limitExchange, description, ImageUrl, quantity) values (?,?,?,?,?,?)";

    public static final String UPDATE_POINT = "update rewards set point=? where id=?";

    public static final String UPDATE_LIMITEXCHANGE = "update rewards set limitExchange=? where id=?";

    public static final String UPDATE_QUANTITY = "update rewards set quantity=? where id=?";

    public static final String UPDATE_NAME = "update rewards set name=? where id=?";

    public static final String UPDATE_IMAGE_URL = "update rewards set ImageUrl=? where id=?";
}
