package tech.sanjaya.blog.thymeleaf.springboot.service;

import tech.sanjaya.blog.thymeleaf.springboot.model.LegalEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LegalEntityService {
    public LegalEntity get(Integer id);
    public List<? extends LegalEntity> findAll();
    public Page<? extends LegalEntity> getAll(String searchString, Integer page, Integer pageSize);
}
