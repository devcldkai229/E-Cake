package devcldkai.kaipizzas.domain.auth;

import java.time.LocalDateTime;

public class Token {

    private String token;

    private String accountId;

    private LocalDateTime createdAt;

    public Token(){
        this.createdAt = LocalDateTime.now();
    }

    public Token(String token){
        this.token = token;
        this.createdAt = LocalDateTime.now().plusMinutes(5);
    }

    public Token(String token, String accountId) {
        this.token = token;
        this.accountId = accountId;
        this.createdAt = LocalDateTime.now();
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
