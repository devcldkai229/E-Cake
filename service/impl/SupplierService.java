package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Products;
import devcldkai.kaipizzas.domain.entities.Suppliers;
import devcldkai.kaipizzas.repository.SupplierRepository;
import devcldkai.kaipizzas.repository.impl.SupplierRepositoryImpl;
import devcldkai.kaipizzas.service.ISupplierService;

import java.util.List;
import java.util.Optional;

public class SupplierService implements ISupplierService {

    private SupplierRepository supplierRepository = new SupplierRepositoryImpl();

    public static ISupplierService getInstance(){
        return new SupplierService();
    }

    @Override
    public List<Suppliers> getAll() {
        return supplierRepository.selectALLSuppliers();
    }

    @Override
    public List<Suppliers> getByName(String name) {
        return supplierRepository.selectSuppliersByName(name);
    }

    @Override
    public Optional<Suppliers> getById(int id) {
        return supplierRepository.selectSuppliersById(id);
    }

    @Override
    public List<Products> getProductsBySupplier(int supplierId) {
        return supplierRepository.selectProductsBySupplierId(supplierId);
    }

    @Override
    public void delete(int id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public void save(Suppliers suppliers) {
        supplierRepository.save(suppliers);
    }
}
