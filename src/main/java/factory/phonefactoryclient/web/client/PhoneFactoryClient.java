package factory.phonefactoryclient.web.client;

import factory.phonefactoryclient.web.model.CustomerDto;
import factory.phonefactoryclient.web.model.PhoneDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "phone.factory", ignoreUnknownFields = false)
@Component
public class PhoneFactoryClient {

    public final String PHONE_PATH_V1 = "/api/v1/phone/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public PhoneFactoryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PhoneDto getPhoneById(UUID uuid) {
        return restTemplate.getForObject(apihost + PHONE_PATH_V1 + uuid.toString(), PhoneDto.class);
    }

    public URI saveNewPhone(PhoneDto phoneDto) {
        return restTemplate.postForLocation(apihost + PHONE_PATH_V1, phoneDto);
    }

    public void updatePhone(UUID uuid, PhoneDto phoneDto) {
        restTemplate.put(apihost + PHONE_PATH_V1 + uuid.toString(), phoneDto);
    }

    public void deletePhone(UUID uuid) {
        restTemplate.delete(apihost + PHONE_PATH_V1 + uuid);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
    }
}
