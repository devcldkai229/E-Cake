package devcldkai.kaipizzas.controller;

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

@WebServlet("/UploadFilesServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UploadFilesController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String webAppImgPath = "D:\\PRJ\\Asm\\kaipizzas_v2\\kaipizzas\\src\\main\\webapp\\img\\product";
        File uploadDirWebApp = new File(webAppImgPath);
        if (!uploadDirWebApp.exists()) {
            uploadDirWebApp.mkdirs();
        }

        String realPath = request.getServletContext().getRealPath("/img/product");
        File uploadDirTarget = new File(realPath);
        if (!uploadDirTarget.exists()) {
            uploadDirTarget.mkdirs();
        }

        PrintWriter out = response.getWriter();
        try {
            Part part = request.getPart("fileServlet");
            if (part != null && part.getSize() > 0) {
                String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
                part.write(uploadDirWebApp.getAbsolutePath()+File.separator+fileName);

                part.write(realPath+File.separator+fileName);
                out.println("Upload successfully: " + fileName);
            } else {
                out.println("Not file is chosen!");
            }
        } catch (Exception e) {
            response.getWriter().println("Upload failed: " + e.getMessage());
        }
    }
}



