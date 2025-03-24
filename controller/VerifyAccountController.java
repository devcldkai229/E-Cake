package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.constant.AccountStatus;
import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.auth.Token;
import devcldkai.kaipizzas.exception.TokenExpiredException;
import devcldkai.kaipizzas.exception.TokenVerifyNotFoundException;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;
import devcldkai.kaipizzas.exception.VerifyException;
import devcldkai.kaipizzas.service.impl.AccountsService;
import devcldkai.kaipizzas.service.impl.TokenVerifyService;
import devcldkai.kaipizzas.util.TokenUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/verify")
public class VerifyAccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String username = TokenUtil.retrieveUsername(token);
        Accounts accounts = AccountsService.getInstance().getByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Account not found")
        );
        String accountsID = accounts.getId();
        Token tokenNewest = TokenVerifyService.getInstance().getTokenNewestDateTime(accountsID)
                .orElseThrow(
                        () -> new TokenVerifyNotFoundException("Token not found")
                );
        try {
            if (TokenUtil.isValidToken(tokenNewest.getToken())) {
                AccountsService.getInstance().updateStatus(accountsID, AccountStatus.ACTIVE);
                TokenVerifyService.getInstance().delete(accountsID);
            } else {
                TokenVerifyService.getInstance().delete(accountsID);
                AccountsService.getInstance().delete(accounts);
                throw new TokenExpiredException("Token is expired: " + tokenNewest.getToken());
            }
        } catch (VerifyException e){
            request.getRequestDispatcher("/verifyFailed.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/verifySuccess.jsp").forward(request, response);
    }
}
