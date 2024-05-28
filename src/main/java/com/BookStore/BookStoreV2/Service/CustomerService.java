package com.BookStore.BookStoreV2.Service;

import com.BookStore.BookStoreV2.DTO.AddressDTO;
import com.BookStore.BookStoreV2.DTO.CustomerDTO;
import com.BookStore.BookStoreV2.Entity.AddressEntity;
import com.BookStore.BookStoreV2.Entity.CustomerEntity;
import com.BookStore.BookStoreV2.Exceptions.RecordNotFound;
import com.BookStore.BookStoreV2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = mapToEntity(customerDTO);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        mapToDTO(savedCustomer);
    }

    public CustomerDTO loadCustomerByEmail(String email) throws RecordNotFound {
        CustomerEntity customerEntity = customerRepository.findByEmail(email);

        if (customerEntity == null) {
            throw new RecordNotFound("Customer not found");
        }
        return mapToDTO(customerEntity);
    }

    public CustomerDTO getCustomer(long id) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFound("Customer not found with ID: " + id));
        return mapToDTO(customerEntity);
    }

    public  List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private CustomerEntity mapToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerDTO.getFirstName());
        customerEntity.setLastName(customerDTO.getLastName());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setPhone(customerDTO.getPhone());

        List<AddressEntity> addressEntities = customerDTO.getAddresses().stream().map(addressDTO -> {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setStreet(addressDTO.getStreet());
            addressEntity.setCity(addressDTO.getCity());
            addressEntity.setZip(addressDTO.getZip());
            addressEntity.setCustomerEntity(customerEntity);
            return addressEntity;
        }).collect(Collectors.toList());

        customerEntity.setAddresses(addressEntities);

        return customerEntity;
    }

    private CustomerDTO mapToDTO(CustomerEntity customerEntity) {


        List<AddressDTO> addressDTOs = customerEntity.getAddresses().stream().map(addressEntity -> new AddressDTO(addressEntity.getStreet(),addressEntity.getCity(),addressEntity.getZip())).collect(Collectors.toList());

        return new CustomerDTO(customerEntity.getId(), customerEntity.getFirstName(),customerEntity.getLastName(),customerEntity.getEmail(),customerEntity.getPhone(),addressDTOs);
    }
}
