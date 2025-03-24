package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.auth.Token;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ITokenVerifyService {

    void save(Token token);

    void delete(String accountId);

    List<Token> getAllTokenByAccountID(String accountID);

    Optional<Token> getTokenNewestDateTime(String accountID);

    LocalDateTime getCreatedAt(String tokenID);

}
