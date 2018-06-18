import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program2 {

  private static final String API_KEY = "33LVev0plRmshdP6JXmBnwnijYrup1eTX4WjsnedVjMgKg3HrB";
  private static final String API_URL = "https://restcountries-v1.p.mashape.com/alpha/";
  private static final String API_KEY_HEADER_NAME = "X-Mashape-Key";

  public static void main(String[] args) {
    List<String> countries = Arrays.asList("gb", "ru", "usa", "de", "fr", "es");
    HttpMessageConverter<?> converter = new MappingJackson2HttpMessageConverter();
    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
    converters.add(converter);
    RestTemplate restTemplate = new RestTemplate(converters);
    HttpHeaders headers = new HttpHeaders();
    headers.set(API_KEY_HEADER_NAME, API_KEY);

    long before = System.currentTimeMillis();
    for (String country : countries) {
      RequestEntity<Object> request =
          new RequestEntity<Object>(headers, HttpMethod.GET, URI.create(API_URL + country));
      ResponseEntity<CountryDto> response = restTemplate.exchange(request, CountryDto.class);
      System.out.println(Thread.currentThread() + " " + response.getBody().getTranslations().get("de"));
    }
    long after = System.currentTimeMillis();
    System.out.println((after - before) / 1000);
  }
}
