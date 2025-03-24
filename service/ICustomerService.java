package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.Customers;

import java.util.Optional;

public interface ICustomerService {

    Optional<Customers> getById(Long id);

    Optional<Customers> getByAccountId(String id);

    void save(Customers customers);

    Optional<Customers> getByEmailAndPhone(Customers customers);

    boolean isExist(Customers customers);
}
