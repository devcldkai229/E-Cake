package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.repository.queries.RoleQueries;
import devcldkai.kaipizzas.service.IRoleService;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RoleService implements IRoleService {

    public static IRoleService getInstance(){
        return new RoleService();
    }

    @Override
    public Optional<String> getRole(int id) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(RoleQueries.DEF_LOAD_ROLE_BY_ID);
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(resultSet.getString("Name"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
