package devcldkai.kaipizzas.controller.dashboard;

import devcldkai.kaipizzas.domain.entities.Products;
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
@WebServlet("/createProductsDashBoard")
public class CreateProductsDashBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameServlet");
        int quantity = Integer.parseInt(request.getParameter("quantityServlet"));
        double price = Double.parseDouble(request.getParameter("priceServlet"));
        int categoryId = Integer.parseInt(request.getParameter("categoriesSelect"));
        int supplierId = Integer.parseInt(request.getParameter("suppliersSelect"));
        String description = request.getParameter("descriptionServlet");

        try {
            Part part = request.getPart("fileServlet");
            if(part!=null && part.getSize()>0){
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

                part.write(uploadDirWebApp.getAbsolutePath() + File.separator + fileName);
                part.write(realPath + File.separator + fileName);

                Products products = new Products();
                products.setName(name);
                products.setCategoryId(categoryId);
                products.setSupplierId(supplierId);
                products.setQuantity(quantity);
                products.setPrice(price);
                products.setDescription(description);
                products.setProductImgUrl(fileName);

                ProductService.getInstance().save(products);
            }
        } catch(Exception e){
            e.printStackTrace();
        }


    }
}
