package phone.book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class PhoneNumberDetails {

    @Id
    private Integer phoneNumber;
    private String name;

    public PhoneNumberDetails() {
    }

    public PhoneNumberDetails(Integer phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{Phone Number Details [number:%d name:%s]}", phoneNumber, name);
    }
}
