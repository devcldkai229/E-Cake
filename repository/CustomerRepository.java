package devcldkai.kaipizzas.repository;

import devcldkai.kaipizzas.domain.entities.Customers;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customers> selectCustomerById(Long id);

    Optional<Customers> selectCustomerByAccountId(String accountId);

    void save(Customers customers);

    Optional<Customers> selectCustomerByEmailAndPhone(Customers customers);

    boolean existsCustomerByEmailAndPhone(Customers customers);
}
