package phone.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import phone.book.model.PhoneNumberDetails;


public interface PhoneNumberDetailsJpaRepo extends JpaRepository<PhoneNumberDetails, Integer> {
}
