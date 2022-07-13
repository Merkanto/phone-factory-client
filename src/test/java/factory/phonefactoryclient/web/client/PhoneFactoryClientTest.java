package factory.phonefactoryclient.web.client;

import factory.phonefactoryclient.web.model.CustomerDto;
import factory.phonefactoryclient.web.model.PhoneDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PhoneFactoryClientTest {

    @Autowired
    PhoneFactoryClient client;

    @Test
    void getPhoneById() {
        PhoneDto dto = client.getPhoneById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewPhone() {
        PhoneDto phoneDto = PhoneDto.builder()
                .phoneName("New Phone")
                .build();

        URI uri = client.saveNewPhone(phoneDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdatePhone() {
        PhoneDto phoneDto = PhoneDto.builder()
                .phoneName("New Phone")
                .build();

        client.updatePhone(UUID.randomUUID(), phoneDto);
    }

    @Test
    void testDeletePhone() {
        client.deletePhone(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("Goshko")
                .build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("Ivan")
                .build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}