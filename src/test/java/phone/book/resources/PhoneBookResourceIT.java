package phone.book.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import phone.book.URI;
import phone.book.model.PhoneNumberDetails;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhoneBookResourceIT {

    @Autowired
    private TestRestTemplate testRestTemplate;


    //TODO write IT for add phone
//    @Test
//    public void test_add_phone() throws Exception {
//        String response = this.testRestTemplate.postForObject(URI.ADD_PHONE_DETAILS.toString(),"{\"phoneNumber\":5,\"name\":\"new\"}" ,String.class);
//        System.out.println(response);
//        JSONAssert.assertEquals("{\"phoneNumber\":5,\"name\":\"new\"}", response, false);
//    }


    @Test
    public void test_get_phone_numbers_by_id() throws Exception {
        String response = this.testRestTemplate.getForObject(URI.GET_PHONE_DETAILS_BY_NUMBER.toString(), String.class);
        JSONAssert.assertEquals("{\"phoneNumber\":1,\"name\":\"Amit\"}", response, false);
    }

    @Test
    public void test_get_all_phone_numbers_with_details() throws Exception {
        List<PhoneNumberDetails> response = this.testRestTemplate.getForObject(URI.GET_ALL_PHONE_DETAILS.toString(), List.class);
        assertEquals(3, response.size());
    }
}

