package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDTO customer){

        CustomerDTO savedCustomer = customerService.saveNewCustomer(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer" + customer.getId().toString());
        return  new ResponseEntity(httpHeaders, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerDTO> listAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}",method = RequestMethod.GET)
    public CustomerDTO getCustomerById(@PathVariable("customerId") UUID id){
        return customerService.getCustomerById(id);
    }
}
