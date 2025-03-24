package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.impl.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50     // 50MB
)
@WebServlet("/updateEntireProducts")
public class UpdateProductsDashBoardEntireController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameServlet");
        int quantity = Integer.parseInt(request.getParameter("quantityServlet"));
        double price = Double.parseDouble(request.getParameter("priceServlet"));
        int categoryIdLater = Integer.parseInt(request.getParameter("categoriesSelect"));
        int supplierIdLater = Integer.parseInt(request.getParameter("suppliersSelect"));
        int categoryIdFormer = Integer.parseInt(request.getParameter("categoriesDefaultValue"));
        int supplierIdFormer = Integer.parseInt(request.getParameter("suppliersDefaultValue"));
        long productId = Long.parseLong(request.getParameter("productId"));
        String imgUrl = request.getParameter("fileName");
        String description = request.getParameter("descriptionServlet");
        Products existingProduct = ProductService.getInstance().getById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product with id "+productId+" not found")
        );

        if(!existingProduct.getName().equals(name)){
            ProductService.getInstance().updateName(name, existingProduct.getId());
        }
        if(!existingProduct.getDescription().equals(description)){
            ProductService.getInstance().updateDescription(description, existingProduct.getId());
        }
        if(categoryIdLater!=categoryIdFormer){
            ProductService.getInstance().updateCategory(categoryIdLater, existingProduct.getId());
        }
        if(supplierIdLater!=supplierIdFormer){
            ProductService.getInstance().updateSupplier(supplierIdLater, existingProduct.getId());
        }
        if(quantity!=existingProduct.getQuantity()){
            ProductService.getInstance().updateQuantity(quantity, existingProduct.getId());
        }
        if(price!=existingProduct.getPrice()){
            ProductService.getInstance().updatePrice(price, existingProduct.getId());
        }
        try {
            Part part = request.getPart("fileServlet");
                if (part != null && part.getSize() > 0) {
                    String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
                    File uploadDirWebApp = new File("E:\\PRJ\\Asm\\kaipizzas_v2\\kaipizzas\\src\\main\\webapp\\img\\product");
                    if (!uploadDirWebApp.exists()) {
                        uploadDirWebApp.mkdirs();
                    }
                    String realPath = request.getServletContext().getRealPath("/img/product");
                    File uploadDirTarget = new File(realPath);
                    if (!uploadDirTarget.exists()) {
                        uploadDirTarget.mkdirs();
                    }
                    if (!fileName.equalsIgnoreCase(imgUrl)) {
                        ProductService.getInstance().updateImage(fileName, existingProduct.getId());
                        part.write(uploadDirWebApp.getAbsolutePath() + File.separator + fileName);
                        part.write(realPath + File.separator + fileName);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/adminproductslist.jsp").forward(request, response);
    }
}
