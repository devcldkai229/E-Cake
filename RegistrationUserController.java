package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.constant.FormAnnouncementEmailForVerifyToken;
import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.auth.Token;
import devcldkai.kaipizzas.exception.AuthenticationException;
import devcldkai.kaipizzas.exception.EmailAlreadyExistException;
import devcldkai.kaipizzas.exception.VerifyException;
import devcldkai.kaipizzas.service.impl.AccountsService;
import devcldkai.kaipizzas.service.impl.TokenVerifyService;
import devcldkai.kaipizzas.util.EmailUtil;
import devcldkai.kaipizzas.util.TokenUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegistrationUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Accounts newAccount = new Accounts(username, email, password);
        try {
            try {
                if (AccountsService.getInstance().existsByUsername(newAccount.getEmail())) {
                    throw new EmailAlreadyExistException("Email already exist");
                }
            } catch (EmailAlreadyExistException e){
                out.write("{\"success\": false, \"message\": \"Email already exist\"}");
                out.flush();
                out.close();
                return;
            }
            Token tokenUnverified = TokenUtil.generateToken(username);
            tokenUnverified.setAccountId(newAccount.getId());
            AccountsService.getInstance().saveNotFullInfo(newAccount);
            TokenVerifyService.getInstance().save(tokenUnverified);
            EmailUtil.sendEmail(newAccount.getEmail(),
                    "Verify your account",
                    FormAnnouncementEmailForVerifyToken.formVerifyAccounts(tokenUnverified.getToken(), newAccount.getUsername()));
            out.write("{\"success\": true, \"forwardUrl\": \"registerRecord.html\"}");
            out.flush();
            out.close();
        } catch (AuthenticationException | VerifyException e) {
            out.write("{\"success\": false, \"forwardUrl\": \"registerUnrecord.html\"}");
            out.flush();
            out.close();
        }
    }
}
