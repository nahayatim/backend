package at.nacs.drhouseadministration.communication;

import at.nacs.drhouseadministration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AccountancyClient {

  private final RestTemplate restTemplate;


  @Value("${accountancy.url}")
  private String url;

  public Invoice[] getAllInvoices() {
    return restTemplate.getForObject(url, Invoice[].class);
  }

  public void PaidBy(String id) {
    String urlPaid = url + "/" + id + "/paid";
    restTemplate.put(urlPaid, void.class);
  }
}
