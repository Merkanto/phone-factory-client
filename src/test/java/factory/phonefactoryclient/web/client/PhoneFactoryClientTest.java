package factory.phonefactoryclient.web.client;

import factory.phonefactoryclient.web.model.PhoneDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}