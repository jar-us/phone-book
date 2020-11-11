package phone.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.book.model.PhoneNumberDetails;
import phone.book.repo.PhoneNumberDetailsJpaRepo;

import java.util.Optional;

@Service
public class PhoneBookService {


    @Autowired
    private PhoneNumberDetailsJpaRepo detailsJpaRepo;

    public PhoneNumberDetails getPhoneNumberDetails() {
        Optional<PhoneNumberDetails> phoneNumberDetailsById = detailsJpaRepo.findById(1);
        return phoneNumberDetailsById.orElse(new PhoneNumberDetails(123, "Suraj"));
    }

}
