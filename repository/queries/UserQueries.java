package devcldkai.kaipizzas.repository.queries;

public class UserQueries {

    private UserQueries(){}

    public static final String DEF_GET_ALL_USER_SQL = "SELECT * FROM Accounts";

    public static final String DEF_CREATE_USER_SQL = "INSERT INTO Accounts(AccountID, UserName, Password, Email, FirstName, LastName, PointRewards, DateOfBirth, Phone, imageUrl, RoleID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    public static final String DEF_CREATE_USER_SIGN_UP_SQL = "INSERT INTO Accounts(AccountID, UserName, Email, Password, PointRewards, RoleID, imageUrl) VALUES(?,?,?,?,?,?,?)";

    public static final String DEF_DELETE_USER_BY_ID_SQL = "DELETE FROM Accounts WHERE AccountID=?";

    public static final String DEF_GET_ORDERS_USER_BY_ID_SQL = "SELECT * FROM Orders WHERE CustomerID IN (SELECT CustomerID FROM Customers WHERE AccountId = ?)";

    public static final String DEF_PATCH_UPDATE_USER_STATUS_SQL = "UPDATE Accounts SET status=? WHERE AccountID=?";

    public static final String DEF_DELETE_USER_SQL = "DELETE FROM Accounts WHERE UserName=?";

    public static final String DEF_FIND_USER_SQL = "SELECT * FROM Accounts WHERE UserName=?";

    public static final String DEF_FIND_USER_SQL_BY_ID = "SELECT * FROM Accounts WHERE AccountId=?";

    public static final String DEF_USER_EXISTS_BY_EMAIL_SQL = "SELECT * FROM Accounts WHERE Email=?";

    public static final String DEF_PATCH_UPDATE_USER_PASSWORD_SQL = "UPDATE Accounts SET Password=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_EMAIL_SQL = "UPDATE Accounts SET Email=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_PHONE_SQL = "UPDATE Accounts SET Phone=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_IMAGE_SQL = "UPDATE Accounts SET imageUrl=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_POINT_REWARDS_SQL = "UPDATE Accounts SET PointRewards=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_FIRST_NAME_SQL = "UPDATE Accounts SET FirstName=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_LAST_NAME_SQL = "UPDATE Accounts SET LastName=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_DOB_SQL = "UPDATE Accounts SET DateOfBirth=? WHERE UserName=?";

    public static final String DEF_PATCH_UPDATE_USER_ABOUT_SQL = "UPDATE Accounts SET About=? WHERE UserName=?";

}
