package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {

    List<Suppliers> getAll();

    List<Suppliers> getByName(String name);

    Optional<Suppliers> getById(int id);

    List<Products> getProductsBySupplier(int supplierId);

    void delete(int id);

    void save(Suppliers suppliers);
}
