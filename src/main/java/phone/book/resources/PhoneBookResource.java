package phone.book.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phone.book.model.PhoneNumberDetails;
import phone.book.service.PhoneBookService;

import java.util.List;

@RestController
public class PhoneBookResource {

    @Autowired
    private PhoneBookService phoneBookService;

    // get all phone numbers
    @GetMapping("/get-all-phone-numbers-with-details")
    public List<PhoneNumberDetails> getAllPhoneNumber() {
        return phoneBookService.getAllPhoneNumberWithDetails();
    }

    // search by phone number
    @GetMapping("/get-details-by-phone-number/{phoneNumber}")
    public PhoneNumberDetails getDetailsByPhoneNumber(@PathVariable("phoneNumber") Integer phoneNumber) {
        return phoneBookService.getDetailsByPhoneNumber(phoneNumber);
    }


    // add user phone number with details
    @PostMapping("/add-phone-number-with-details")
    public PhoneNumberDetails addPhoneNumber(@RequestBody PhoneNumberDetails phoneNumberDetails) {
        return phoneBookService.addPhoneNumberWithDetails(phoneNumberDetails);
    }
}
