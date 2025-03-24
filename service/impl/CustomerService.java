package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Customers;
import devcldkai.kaipizzas.repository.CustomerRepository;
import devcldkai.kaipizzas.repository.impl.CustomerRepositoryImpl;
import devcldkai.kaipizzas.service.ICustomerService;

import java.util.Optional;

public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public static ICustomerService getInstance(){
        return new CustomerService();
    }

    @Override
    public Optional<Customers> getById(Long id) {
        return customerRepository.selectCustomerById(id);
    }

    @Override
    public Optional<Customers> getByAccountId(String id) {
        return customerRepository.selectCustomerByAccountId(id);
    }

    @Override
    public void save(Customers customers) {
        customerRepository.save(customers);
    }

    @Override
    public Optional<Customers> getByEmailAndPhone(Customers customers) {
        return customerRepository.selectCustomerByEmailAndPhone(customers);
    }

    @Override
    public boolean isExist(Customers customers) {
        return customerRepository.existsCustomerByEmailAndPhone(customers);
    }
}
