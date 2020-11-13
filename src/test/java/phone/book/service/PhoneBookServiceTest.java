package phone.book.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import phone.book.model.PhoneNumberDetails;
import phone.book.repo.PhoneNumberDetailsJpaRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PhoneBookServiceTest {

    @InjectMocks
    private PhoneBookService service;

    @Mock
    private PhoneNumberDetailsJpaRepo detailsJpaRepo;

    @Test
    public void test_add() {

        PhoneNumberDetails phone1 = new PhoneNumberDetails(5, "new customer");

        when(detailsJpaRepo.save(any(PhoneNumberDetails.class))).thenReturn(phone1);

        PhoneNumberDetails actualResponse = service.addPhoneNumberWithDetails(phone1);

        assertEquals(String.format("{Phone Number Details [number:%d name:%s]}", 5, "new customer"), actualResponse.toString());

    }

    @Test
    public void test_getPhoneDetailsByNumber_notFound() {

        PhoneNumberDetails phone1 = new PhoneNumberDetails(0, "Not Found");

        Optional<PhoneNumberDetails> phone11 = Optional.of(phone1);
        when(detailsJpaRepo.findById(9)).thenReturn(phone11);

        PhoneNumberDetails actualResponse = service.getDetailsByPhoneNumber(9);

        assertEquals(String.format("{Phone Number Details [number:%d name:%s]}", 0, "Not Found"), actualResponse.toString());

    }

    @Test
    public void test_getPhoneDetailsByNumber_basic() {

        PhoneNumberDetails phone1 = new PhoneNumberDetails(1, "AmiT");

        Optional<PhoneNumberDetails> phone11 = Optional.of(phone1);
        when(detailsJpaRepo.findById(1)).thenReturn(phone11);

        PhoneNumberDetails actualResponse = service.getDetailsByPhoneNumber(1);

        assertEquals(String.format("{Phone Number Details [number:%d name:%s]}", 1, "AmiT"), actualResponse.toString());

    }

    @Test
    public void test_getAllPhoneNUmberDetails() {

        PhoneNumberDetails phone1 = new PhoneNumberDetails(1, "AmiT");
        PhoneNumberDetails phone2 = new PhoneNumberDetails(2, "Suraj");
        PhoneNumberDetails phone3 = new PhoneNumberDetails(3, "Sumit");
        List<PhoneNumberDetails> phoneNumberDetails = Arrays.asList(phone1, phone2, phone3);

        when(detailsJpaRepo.findAll()).thenReturn(phoneNumberDetails);

        List<PhoneNumberDetails> actualResponse = service.getAllPhoneNumberWithDetails();

        assertEquals(phoneNumberDetails.get(0).toString(), actualResponse.get(0).toString());

    }
}
