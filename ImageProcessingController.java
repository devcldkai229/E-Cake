package devcldkai.kaipizzas.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/ImageProcessing")
public class ImageProcessingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.contains("..") || fileName.contains("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid file name");
            return;
        }
        //String realPath = "E:\\PRJ\\Asm\\kaipizzas_v2\\kaipizzas\\src\\main\\webapp\\img";
        String realPath = getServletContext().getRealPath("/img");
        if (realPath == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Image directory not found");
            return;
        }

        File imageFile = new File(realPath, fileName);
        if (!imageFile.exists() || !imageFile.isFile()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found");
            return;
        }
        String mimeType = getServletContext().getMimeType(imageFile.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) imageFile.length());
        try (FileInputStream fis = new FileInputStream(imageFile);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}