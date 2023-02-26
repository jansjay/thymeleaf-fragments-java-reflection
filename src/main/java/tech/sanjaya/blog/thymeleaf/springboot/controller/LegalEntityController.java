package tech.sanjaya.blog.thymeleaf.springboot.controller;

import tech.sanjaya.blog.thymeleaf.springboot.model.LegalEntity;
import tech.sanjaya.blog.thymeleaf.springboot.service.LegalEntityService;
import tech.sanjaya.blog.thymeleaf.springboot.service.AddressService;
import tech.sanjaya.blog.thymeleaf.springboot.dto.selectors.AddressSelectorDTO;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LegalEntityController extends EntityController<LegalEntity> {
    
    @Autowired
    private LegalEntityService legalentityService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/legal-entities")
    public ModelAndView showCompanies(Model model,
                                      @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size,
                                      @RequestParam("search") Optional<String> search) {
        LOG.info("In legal entity view");
        int currentPage = getCurrentPage(page);
        int pageSize = getPageSize(size);
        String searchString = getSearchString(search);
        return getListEntitiesModelView(legalentityService.getAll(searchString, currentPage, pageSize));
    }

    @Override
    public Class<?> getClassType(){
        return LegalEntity.class;
    }
    @Override
    public String getEditViewPath(){
        return null;
    }
    @Override
    public String getListViewPath(){
        return "/legal_entity_list";
    }
    @Override
    public String getNewViewPath(){
        return null;
    }
    @Override
    public String getCrudPath(){
        return null;
    }
    @Override
    public String getListPath() { return "/legal-entities";}
    @Override
    public Dictionary<String, List<?>> getSelectLists(){
        Dictionary<String, List<?>> dictionary = new Hashtable<>();
        //Note used same attributeName "address"
        dictionary.put("address", addressService.findAll().stream().map(AddressSelectorDTO::new).collect(Collectors.toList()));
        return dictionary;
    }
}
