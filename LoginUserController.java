package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.authentication.*;
import devcldkai.kaipizzas.constant.AccountStatus;
import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.entities.Cart;
import devcldkai.kaipizzas.exception.*;
import devcldkai.kaipizzas.service.impl.AccountsService;
import devcldkai.kaipizzas.service.impl.RoleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/loginUserServlet")
public class LoginUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);
        PrintWriter out = response.getWriter();

        try {
            Accounts loadedAccount = AccountsService.getInstance().getByUsername(username).orElseThrow(
                    () -> new UsernameNotFoundException("Account not found")
            );
            if(loadedAccount.getStatus().equalsIgnoreCase(AccountStatus.UNVERIFY)) {
                    throw new UserUnVerifyException("User unverified");
            }
            String role = RoleService.getInstance().getRole(loadedAccount.getRoleId()).orElseThrow(
                    () -> new UserHasNotRoleException("Role not found")
            );
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(role));
            authorities.stream().forEach(System.out::println);
            AuthenticationManager authenticationManager = new ProviderManager();
            authenticationManager.addAuthenticationProvider(new DaoAuthenticationProvider());
            Authentication authenticated = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, authorities));
            if (authenticated != null && authenticated.isAuthenticated()) {
                HttpSession session = request.getSession(true);
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(authenticated);
                session.setAttribute("SECURITY_CONTEXT", securityContext);
                session.setAttribute("user", loadedAccount);
                session.setAttribute("cart", new Cart());


                session.setAttribute("totalQuantity", 0);

                out.write("{\"status\": true, \"message\": \"Login successfully\", \"ROLE\": \""+role+"\"}");
                out.flush();
                out.close();
            } else {
                out.write("{\"status\": false, \"message\": \"Username or Password is incorrect~\"}");
                out.flush();
                out.close();
            }
        } catch (AuthenticationException | VerifyException e){
            out.write("{\"status\": false, \"message\": \"Login failed\"}");
            out.flush();
            out.close();
        }
    }
}
