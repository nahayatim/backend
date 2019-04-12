package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@ConfigurationProperties("dataset")
@Service
@RequiredArgsConstructor
public class Accountant {

  private final PatientManager patientManager;
  private final InvoiceCreator invoiceCreator;
  private final InvoiceManager invoiceManager;

  @Setter
  private Map<String, Double> costs;

  public void post(PatientDTO patientDTO) {
    Patient patient = patientManager.create(patientDTO);
    Invoice invoice = invoiceCreator.createInvoice(patientDTO, patient);
    Double costs = calculateCosts(invoice);
    invoice.setCost(costs);
    patientManager.save(patient);
    invoiceManager.storeInvoice(invoice);
  }

  private Double calculateCosts(Invoice invoice) {
    return costs.getOrDefault(invoice.getProvided(), null);
  }
}
