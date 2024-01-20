package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById(UUID id);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO saveNewCustomer(CustomerDTO customer);
}
