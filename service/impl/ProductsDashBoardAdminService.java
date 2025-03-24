package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.dto.ProductsDashBoardDTO;
import devcldkai.kaipizzas.domain.entities.Categories;
import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.exception.ResourceNotFoundException;
import devcldkai.kaipizzas.service.IProductsDashBoardAdminService;

import java.util.ArrayList;
import java.util.List;

public class ProductsDashBoardAdminService implements IProductsDashBoardAdminService {

    public static IProductsDashBoardAdminService getInstance(){
        return new ProductsDashBoardAdminService();
    }

    @Override
    public List<ProductsDashBoardDTO> getAllProductsDashBoard() {
        List<ProductsDashBoardDTO> productsDashBoardDTOS = new ArrayList<ProductsDashBoardDTO>();
        List<Products> productsList = ProductService.getInstance().getAll();
        productsList.forEach(product -> {
            Suppliers accuracyProvider = SupplierService.getInstance().getById(product.getSupplierId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Supplier not found")
                    );

            Categories accuracyCategories = CategoryService.getInstance().getById(product.getCategoryId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Category not found")
                    );
            productsDashBoardDTOS.add(new ProductsDashBoardDTO(accuracyCategories.getId(), accuracyCategories.getName(),
                    product.getDescription(), product.getId(), product.getName(), product.getPrice(),
                    product.getProductImgUrl(), product.getQuantity(), accuracyProvider.getId(),
                    accuracyProvider.getCompanyName()));
        });
        return productsDashBoardDTOS;
    }
    public static void main(String[] args){
        List<ProductsDashBoardDTO> productsDashBoardDTOS = ProductsDashBoardAdminService.getInstance().getAllProductsDashBoard();
        productsDashBoardDTOS.forEach(System.out::println);

    }
}
