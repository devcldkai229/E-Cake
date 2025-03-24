package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.constant.FormAnnouncementEmailForOTPCode;
import devcldkai.kaipizzas.util.EmailUtil;
import devcldkai.kaipizzas.util.TokenUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changeEmail")
public class ChangeEmailUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("newEmail");
        String otpCode = TokenUtil.generateOTPCode();
        request.getSession().setAttribute("otpCode", otpCode);
        request.getSession().setAttribute("otpTimestamp", System.currentTimeMillis());
        EmailUtil.sendEmail(email, "OTP Code to change your email", FormAnnouncementEmailForOTPCode.getInstance().getForm(otpCode));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\": true}");
        out.flush();
        out.close();
    }


}
