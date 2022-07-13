package factory.phonefactoryclient.web.client;

import factory.phonefactoryclient.web.model.PhoneDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@ConfigurationProperties(prefix = "phone.factory", ignoreUnknownFields = false)
@Component
public class PhoneFactoryClient {

    public final String PHONE_PATH_V1 = "/api/v1/phone/";
    private String apihost;

    private final RestTemplate restTemplate;

    public PhoneFactoryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PhoneDto getPhoneById(UUID uuid) {
        return restTemplate.getForObject(apihost + PHONE_PATH_V1 + uuid.toString(), PhoneDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

}
