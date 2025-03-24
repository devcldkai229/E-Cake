package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.authentication.BcryptPasswordEncoder;
import devcldkai.kaipizzas.authentication.PasswordEncoder;
import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;
import devcldkai.kaipizzas.service.impl.AccountsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updatePassword")
public class UpdatePasswordUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        PasswordEncoder passwordEncoder = new BcryptPasswordEncoder();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Accounts loadedAccount = AccountsService.getInstance().getByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Account not exist")
        );

        if(!passwordEncoder.matches(oldPassword, loadedAccount.getPassword())) {
            out.write("{\"status\": false, \"message\": \"Old password does incorrect\"}");
            out.flush();
            out.close();
            return;
        }
        if(!newPassword.equals(confirmPassword)){
            out.write("{\"status\": false, \"message\": \"Confirm password does incorrect\"}");
            out.flush();
            out.close();
            return;
        }
        AccountsService.getInstance().updatePassword(username, newPassword);
        out.write("{\"status\": true, \"message\": \"Password updated successfully\"}");
        out.flush();
        out.close();
    }
}
