package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.auth.Token;
import devcldkai.kaipizzas.mapper.TokenMappers;
import devcldkai.kaipizzas.service.ITokenVerifyService;
import devcldkai.kaipizzas.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TokenVerifyService implements ITokenVerifyService {

    private static final String tokenInsert =  "INSERT TokenVerify(token, AccountID, createdAt) VALUES(?,?,?)";

    private static final String tokenGetAll = "SELECT * FROM TokenVerify WHERE AccountID = ?";

    private static final String tokenDelete = "DELETE FROM TokenVerify WHERE AccountID = ?";

    private static final String tokenNewestDateTime = "SELECT * FROM TokenVerify WHERE AccountID=? AND createdAt = (SELECT MAX(createdAt) FROM TokenVerify WHERE AccountID=?)";

    private static final String tokenCreatedAt = "SELECT * FROM TokenVerify WHERE token=?";

    public static ITokenVerifyService getInstance() {
        return new TokenVerifyService();
    }

    @Override
    public void save(Token token) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(tokenInsert);
            preparedStatement.setString(1, token.getToken());
            preparedStatement.setString(2, token.getAccountId());
            preparedStatement.setObject(3, token.getCreatedAt());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(tokenDelete);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Token> getAllTokenByAccountID(String accountID) {
        List<Token> tokens = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(tokenGetAll);
            preparedStatement.setString(1, accountID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                tokens.add(TokenMappers.mapToToken(resultSet));
            }
            return tokens;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tokens;
    }

    @Override
    public Optional<Token> getTokenNewestDateTime(String accountID) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(tokenNewestDateTime);
            preparedStatement.setString(1, accountID);
            preparedStatement.setString(2, accountID);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return Optional.of(TokenMappers.mapToToken(resultSet));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public LocalDateTime getCreatedAt(String tokenID) {
        try {
            PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(tokenCreatedAt);
            preparedStatement.setString(1, tokenID);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                   Token token = TokenMappers.mapToToken(resultSet);
                   return token.getCreatedAt();
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
