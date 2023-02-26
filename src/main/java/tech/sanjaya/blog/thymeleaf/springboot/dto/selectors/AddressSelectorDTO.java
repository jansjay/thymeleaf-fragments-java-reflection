package tech.sanjaya.blog.thymeleaf.springboot.dto.selectors;

import tech.sanjaya.blog.thymeleaf.springboot.model.Address;

public class AddressSelectorDTO extends SelectorDTO<Integer, Address> {

    public AddressSelectorDTO(Address entityObject) {
        super(entityObject);
    }
    @Override    
    public void setParentId(){
        this.id = entityObject.getId();
    }
    @Override
    public String getDisplayText() {
        return entityObject.getStreetName()+ "," + entityObject.getCity()+ "," + entityObject.getState() + "," + entityObject.getZip();
    }

    @Override
    public Integer getId() {
        return entityObject.getId();
    }
    
    @Override
    public SelectorDTO<Integer, Address> createDTOObject(Address address){
        return new AddressSelectorDTO(address);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != Address.class)
        {
            return (obj.getClass() == this.getClass() && (((AddressSelectorDTO)obj).equals(this)));
        }
        Address other = (Address)obj;
        return this.id.equals(other.getId());
    }
}
