package io.mostafaeldahshan.simon_and_kucher.service;

import io.mostafaeldahshan.simon_and_kucher.model.Customer;
import io.mostafaeldahshan.simon_and_kucher.model.CustomerOrder;
import io.mostafaeldahshan.simon_and_kucher.dto.CustomerDTO;
import io.mostafaeldahshan.simon_and_kucher.repos.CustomerOrderRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.CustomerRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerOrderRepository customerOrderRepository;

    public CustomerService(final CustomerRepository customerRepository,
            final CustomerOrderRepository customerOrderRepository) {
        this.customerRepository = customerRepository;
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll(Sort.by("id"))
                .stream()
                .map(customer -> mapToDTO(customer, new CustomerDTO()))
                .collect(Collectors.toList());
    }

    public CustomerDTO get(final UUID id) {
        return customerRepository.findById(id)
                .map(customer -> mapToDTO(customer, new CustomerDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(final CustomerDTO customerDTO) {
        final Customer customer = new Customer();
        mapToEntity(customerDTO, customer);
        return customerRepository.save(customer).getId();
    }

    public void update(final UUID id, final CustomerDTO customerDTO) {
        final Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(customerDTO, customer);
        customerRepository.save(customer);
    }

    public void delete(final UUID id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(final Customer customer, final CustomerDTO customerDTO) {
        customerDTO.setId(customer.getId());
        customerDTO.setCity(customer.getCity());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setFirstname(customer.getFirstname());
        customerDTO.setLastname(customer.getLastname());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setPostalCode(customer.getPostalCode());
        customerDTO.setStreet(customer.getStreet());
        customerDTO.setCustomerOrder(customer.getCustomerOrder() == null ? null : customer.getCustomerOrder().getId());
        return customerDTO;
    }

    private Customer mapToEntity(final CustomerDTO customerDTO, final Customer customer) {
        customer.setCity(customerDTO.getCity());
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstname(customerDTO.getFirstname());
        customer.setLastname(customerDTO.getLastname());
        customer.setPhone(customerDTO.getPhone());
        customer.setPostalCode(customerDTO.getPostalCode());
        customer.setStreet(customerDTO.getStreet());
        final CustomerOrder customerOrder = customerDTO.getCustomerOrder() == null ? null : customerOrderRepository.findById(customerDTO.getCustomerOrder())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "customerOrder not found"));
        customer.setCustomerOrder(customerOrder);
        return customer;
    }

    public boolean emailExists(final String email) {
        return customerRepository.existsByEmailIgnoreCase(email);
    }

}
