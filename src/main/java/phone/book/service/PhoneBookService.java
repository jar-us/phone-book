package phone.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.book.model.PhoneNumberDetails;
import phone.book.repo.PhoneNumberDetailsJpaRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookService {


    @Autowired
    private PhoneNumberDetailsJpaRepo detailsJpaRepo;

    public List<PhoneNumberDetails> getAllPhoneNumberWithDetails() {
        return detailsJpaRepo.findAll();
    }

    public PhoneNumberDetails getDetailsByPhoneNumber(Integer phoneNumber) {
        Optional<PhoneNumberDetails> byId = detailsJpaRepo.findById(phoneNumber);
        return byId.orElse(new PhoneNumberDetails(0000000000, "No found"));
    }

    public PhoneNumberDetails addPhoneNumberWithDetails(PhoneNumberDetails phoneNumberDetails) {
        return detailsJpaRepo.save(phoneNumberDetails);
    }

}
