package phone.book.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import phone.book.model.PhoneNumberDetails;
import phone.book.service.PhoneBookService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PhoneBookResource.class)
public class PhoneBookResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhoneBookService phoneBookService;

    private RequestBuilder builder;

    @BeforeEach
    public void setup() {
        builder = MockMvcRequestBuilders.get("/phone-number-details").accept(MediaType.APPLICATION_JSON);
    }

    @Test
    public void phone_number_details() throws Exception {

        PhoneNumberDetails phoneNumberDetails = new PhoneNumberDetails(123, "Suraj");
        when(phoneBookService.getPhoneNumberDetails()).thenReturn(phoneNumberDetails);

        String expectedResponse = "{\"phoneNumber\": 123,\"name\":\"Suraj\"}";
        mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().json(expectedResponse));
    }
}
