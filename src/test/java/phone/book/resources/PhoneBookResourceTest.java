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
import phone.book.URI;
import phone.book.model.PhoneNumberDetails;
import phone.book.service.PhoneBookService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
    }

    @Test
    public void test_add_phone_details() throws Exception {

        PhoneNumberDetails phoneNumberDetails1 = new PhoneNumberDetails(4, "HelloWorld");
        String request = "{\"phoneNumber\":4,\"name\":\"HelloWorld\"}";

        builder = MockMvcRequestBuilders.post(URI.ADD_PHONE_DETAILS.toString()).content(request).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        String expectedResponse = "{\"phoneNumber\":4,\"name\":\"HelloWorld\"}";
        when(phoneBookService.addPhoneNumberWithDetails(any(PhoneNumberDetails.class))).thenReturn(phoneNumberDetails1);

        mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().string(expectedResponse));
    }

    @Test
    public void test_get_phone_details_by_number() throws Exception {

        PhoneNumberDetails phoneNumberDetails1 = new PhoneNumberDetails(1, "Amit");

        builder = MockMvcRequestBuilders.get(URI.GET_PHONE_DETAILS_BY_NUMBER.toString()).accept(MediaType.APPLICATION_JSON);

        when(phoneBookService.getDetailsByPhoneNumber(anyInt())).thenReturn(phoneNumberDetails1);

        String expectedResponse = "{\"phoneNumber\":1,\"name\":\"Amit\"}";

        mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().json(expectedResponse));
    }

    @Test
    public void test_get_all_phone_numbers_with_details() throws Exception {

        PhoneNumberDetails phoneNumberDetails1 = new PhoneNumberDetails(1, "Amit");
        PhoneNumberDetails phoneNumberDetails2 = new PhoneNumberDetails(2, "Suraj");
        PhoneNumberDetails phoneNumberDetails3 = new PhoneNumberDetails(3, "Sumit");

        List<PhoneNumberDetails> phoneNumberDetails = Arrays.asList(phoneNumberDetails1, phoneNumberDetails2, phoneNumberDetails3);

        builder = MockMvcRequestBuilders.get(URI.GET_ALL_PHONE_DETAILS.toString()).accept(MediaType.APPLICATION_JSON);

        when(phoneBookService.getAllPhoneNumberWithDetails()).thenReturn(phoneNumberDetails);

        String expectedResponse = "[{\"phoneNumber\":1,\"name\":\"Amit\"},{\"phoneNumber\":2,\"name\":\"Suraj\"},{\"phoneNumber\":3,\"name\":\"Sumit\"}]";

        mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().json(expectedResponse));
    }
}

