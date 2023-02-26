package tech.sanjaya.blog.thymeleaf.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.sanjaya.blog.thymeleaf.springboot.model.Company;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c, LegalEntity l where c.legalEntityName = l.legalEntityName or c.phoneNumber =:searchString or c.legalEntityName = :searchString or " +
            "c.companyName = :searchString")
    Page<Company> searchCompany(String searchString, PageRequest pageRequest);
}
