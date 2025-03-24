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
        "/adminorderlist",
        "/adminaccount",
        "/adminrewardslist",
        "/adminorder.jsp",
        "/admincategorieslist",
        "/adminsupplierlist",
        "/admincategory.jsp",
        "/createCategoryDashBoard",
        "/createProductsDashBoard",
        "/createSuppliersDashBoard",
        "/markcompleteorder",
        "/markCompletedOrderRewards",
        "/adminproductslist",
        "/adminproducts.jsp",
        "/createProductsInfo",
        "/orderReport",
        "/productcreate.jsp",
        "/removeCategoriesDashBoard",
        "/removeOrderDashBoard",
        "/removeProductsDashBoard",
        "/removeSupplierDashBoard",
        "/updateEntireProducts",
        "/updateProductDashBoard",
        "/productedition.jsp",
        "/suppliercreate.jsp"
})
public class AuthenticationRoleAdminFilter implements Filter {
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

        if(securityContext.isAuthenticated()){
            Authentication authentication = securityContext.getAuthentication();
            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
            if(authorities.contains(new SimpleGrantedAuthority("ADMIN"))) {
                filterChain.doFilter(request, response);
            } else {
                response.getWriter().write("You are not authorized to access this resource");
            }
        } else request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
