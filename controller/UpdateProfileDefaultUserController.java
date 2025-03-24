package devcldkai.kaipizzas.controller;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;
import devcldkai.kaipizzas.service.impl.AccountsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.Date;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50     // 50MB
)
@WebServlet("/updateProfileDefault")
public class UpdateProfileDefaultUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String about = request.getParameter("about");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String phoneNumber = request.getParameter("phoneNumber");
        Accounts account = (Accounts) request.getSession().getAttribute("user");
        String username = account.getUsername();

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            AccountsService.getInstance().updateFirstName(username, firstName);
            AccountsService.getInstance().updateLastName(username, lastName);
            AccountsService.getInstance().updatePhone(username, phoneNumber);
            AccountsService.getInstance().updateAbout(about, username);
            AccountsService.getInstance().updateDateOfBirth(username, dateOfBirth);
            Part part = request.getPart("user-photo");
            if(part!=null && part.getSize()>0){
                String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
                File uploadDirWebApp = new File("E:\\PRJ\\Asm\\kaipizzas_v2\\kaipizzas\\src\\main\\webapp\\img");
                if (!uploadDirWebApp.exists()) {
                    uploadDirWebApp.mkdirs();
                }
//                String realPath = "E:\\PRJ\\Asm\\kaipizzas_v2\\kaipizzas\\target\\kaipizzas-1.0-SNAPSHOT\\img";
                String realPath = getServletContext().getRealPath("\\img");
                File uploadDirTarget = new File(realPath);
                if (!uploadDirTarget.exists()) {
                    uploadDirTarget.mkdirs();
                }

                part.write(uploadDirWebApp.getAbsolutePath() + File.separator + fileName);
                part.write(realPath + File.separator + fileName);
                AccountsService.getInstance().updateImageUrl(username, fileName);
            }
            Accounts loadedAccount = AccountsService.getInstance().getByUsername(username).
                    orElseThrow(
                            () -> new UsernameNotFoundException("Account not found")
                    );
            request.getSession().setAttribute("user", loadedAccount);
            out.write("{\"status\": true}");
            out.flush();
            out.close();
        } catch(Exception e){
            e.printStackTrace();
            out.write("{\"status\": false}");
            out.flush();
            out.close();
        }
    }
}
