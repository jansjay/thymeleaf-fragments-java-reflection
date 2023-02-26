package tech.sanjaya.blog.thymeleaf.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.sanjaya.blog.thymeleaf.springboot.model.Person;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("select p from Person p where p.firstName =:searchString or " +
            "p.lastName = :searchString or p.phoneNumber = :searchString or p.legalEntityName =:searchString")
    Page<Person> searchPerson(String searchString, PageRequest pageRequest);
}
