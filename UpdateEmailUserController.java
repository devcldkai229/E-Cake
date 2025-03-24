package devcldkai.kaipizzas.controller;

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

@WebServlet("/updateEmail")
public class UpdateEmailUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String OTPCodeInput = request.getParameter("otpCode");
        String OTPCodeDefine = String.valueOf(request.getSession().getAttribute("otpCode"));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        if(!OTPCodeDefine.equals(OTPCodeInput)){
            out.write("{\"status\": false, \"message\": \"Invalid OTP Code\"}");
            out.flush();
            out.close();
            return;
        }
        long otpTimestamp = (long) request.getSession().getAttribute("otpTimestamp");
        long currentTimestamp = System.currentTimeMillis();
        if(currentTimestamp - otpTimestamp > 5*60*1000){
            out.write("{\"status\": false, \"message\": \"OTP Expired\"}");
            out.flush();
            out.close();
            return;
        }
        AccountsService.getInstance().updateEmail(username, email);
        Accounts loadedAccount = AccountsService.getInstance().getByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Account not found")
        );
        request.getSession().setAttribute("user", loadedAccount);
        out.write("{\"status\": true}");
        out.flush();
        out.close();
    }
}
