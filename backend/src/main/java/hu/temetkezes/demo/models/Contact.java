package hu.temetkezes.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Contact extends BaseEntity {



    private String type;
    private String slug;
    private String contact;
    private String officeShortCode;

    public Contact(String type, String contact,String officeShortCode, String slug){
        setType(type);
        setContact(contact);
        setOfficeShortCode(officeShortCode);
        setSlug(slug);
    }
    public Contact(String type, String contact,String officeShortCode){
        setType(type);
        setContact(contact);
        setOfficeShortCode(officeShortCode);
    }
}
