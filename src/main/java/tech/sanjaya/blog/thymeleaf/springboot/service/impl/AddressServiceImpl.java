package tech.sanjaya.blog.thymeleaf.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tech.sanjaya.blog.thymeleaf.springboot.model.Address;
import tech.sanjaya.blog.thymeleaf.springboot.repository.AddressRepository;
import tech.sanjaya.blog.thymeleaf.springboot.service.AddressService;
import java.util.List;

@Service
public class AddressServiceImpl extends BaseService implements AddressService {
    
    @Autowired
    AddressRepository addressRepository;    

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address get(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public Page<Address> getAll(String searchString, Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page,pageSize);
        if(searchString == null || searchString.isBlank())
            return addressRepository.findAll(pageRequest);
        else
            return addressRepository.findByCityOrStateOrStreetNameOrZipContainingIgnoreCase(searchString, searchString, searchString, searchString, pageRequest);
    }
}
