package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.Accounts;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsMappers {

    private AccountsMappers(){}

    public static Accounts mapToAccounts(ResultSet resultSet) throws SQLException {
        Accounts accounts = new Accounts();
        accounts.setId(resultSet.getString("AccountID"));
        accounts.setUsername(resultSet.getString("UserName"));
        accounts.setPassword(resultSet.getString("Password"));
        accounts.setEmail(resultSet.getString("Email"));
        accounts.setFirstName(resultSet.getString("FirstName"));
        accounts.setLastName(resultSet.getString("LastName"));
        accounts.setPointRewards(resultSet.getDouble("PointRewards"));
        accounts.setDateOfBirth(resultSet.getDate("DateOfBirth"));
        accounts.setPhone(resultSet.getString("Phone"));
        accounts.setImageUrl(resultSet.getString("imageUrl"));
        accounts.setRoleId(resultSet.getInt("RoleID"));
        accounts.setAbout(resultSet.getString("About"));
        accounts.setStatus(resultSet.getString("status"));
        return accounts;
    }
}
