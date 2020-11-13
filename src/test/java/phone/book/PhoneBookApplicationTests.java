package phone.book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import phone.book.resources.PhoneBookResource;

@SpringBootTest
class PhoneBookApplicationTests {

	@Autowired
	private PhoneBookResource phoneBookResource;

	@Test
	void contextLoads() {
		Assert.notNull(phoneBookResource,"application is not starting properly");

	}

}
