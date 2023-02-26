package tech.sanjaya.blog.thymeleaf.springboot.repository;

import tech.sanjaya.blog.thymeleaf.springboot.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Page<Address> findByCityOrStateOrStreetNameOrZipContainingIgnoreCase(String city, String state, String streetName, String zip, PageRequest pageRequest);

}
