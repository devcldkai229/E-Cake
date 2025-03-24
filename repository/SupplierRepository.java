package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository {

    List<Suppliers> selectALLSuppliers();

    List<Suppliers> selectSuppliersByName(String name);

    Optional<Suppliers> selectSuppliersById(int id);

    List<Products> selectProductsBySupplierId(int id);

    void deleteById(int id);

    void save(Suppliers suppliers);
}
