package devcldkai.kaipizzas.filters;

import devcldkai.kaipizzas.authentication.Authentication;
import devcldkai.kaipizzas.authentication.GrantedAuthority;
import devcldkai.kaipizzas.authentication.SecurityContext;
import devcldkai.kaipizzas.authentication.SimpleGrantedAuthority;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collection;

@WebFilter(urlPatterns = {
        "/logout",
        "/profiledefault.jsp",
        "/forwardcart",
        "/forwardwishlist",
        "/addtocart",
        "/shoppingcart.jsp",
        "/removeitem",
        "/updatequantity",
        "/profilehistory.jsp",
        "/historyOrdered",
        "/ordersHistoryFilter",
        "/changeEmail",
        "/cancelOrder",
        "/exchangeRewards",
        "/updateEmail",
        "/updatePassword",
        "/verify",
        "/profileaccount.jsp",
        "/profilepassword.jsp",
        "/profilerewards.jsp"
})
public class AuthenticationRoleUserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        SecurityContext securityContext = (session != null) ? (SecurityContext) session.getAttribute("SECURITY_CONTEXT") : null;

        if (securityContext == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        if(securityContext.isAuthenticated()) {
            Authentication authentication = securityContext.getAuthentication();
            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
            authorities.stream().forEach(System.out::println);
            if(authorities.contains(new SimpleGrantedAuthority("USER"))) {
                System.out.println("Successfully logged in");
                filterChain.doFilter(request, response);
            } else {
                System.out.println("User not logged in");
                response.getWriter().write("You are not authorized to access this resource");
            }
        } else request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
