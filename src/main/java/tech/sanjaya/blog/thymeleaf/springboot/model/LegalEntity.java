package tech.sanjaya.blog.thymeleaf.springboot.model;

import jakarta.persistence.*;
import tech.sanjaya.blog.thymeleaf.springboot.model.constraints.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="legalEntity_type", discriminatorType=DiscriminatorType.STRING)
public abstract class LegalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @PhoneNumberConstraint
    private String phoneNumber;
    private String legalEntityName;
    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;    
    
    @Override
    public String toString() {
        return "LegalEntity [id=" + id + ", phoneNumber=" + phoneNumber + ", legalEntityName=" + legalEntityName + "]";
    }

}
