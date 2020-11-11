package phone.book.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import phone.book.model.PhoneNumberDetails;
import phone.book.service.PhoneBookService;

@RestController
public class PhoneBookResource {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping("/phone-number-details")
    public PhoneNumberDetails phoneNumberDetails() {
        return phoneBookService.getPhoneNumberDetails();
    }
}
