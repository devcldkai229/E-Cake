package devcldkai.kaipizzas.repository.queries;

public class AccountRewardQueries {

    private AccountRewardQueries() {}

    public static final String SELECT_BY_ACCOUNT_ID = "select * from Account_Rewards where AccountId = ?";

    public static final String SELECT_BY_ACCOUNT_USERNAME = "select * from Account_Rewards where AccountId = (SELECT AccountId where Username = ?)";

    public static final String SELECT = "select * from Account_Rewards";

    public static final String INSERT ="insert into Account_Rewards (AccountId, RewardId, exchangedDate, address, phone, status) values (?,?,?,?,?,?)";

    public static final String IS_EXIST_EXCHANGED = "select * from Account_Rewards where AccountId = (SELECT AccountId FROM Accounts where Username = ?) AND rewardid = ?";

    public static final String UPDATE_STATUS = "update Account_Rewards set status = ? where accountId = ? and rewardId = ?";

}
