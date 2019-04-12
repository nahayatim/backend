package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceManager {

  private final InvoiceRepository invoiceRepository;


  public void storeInvoice(Invoice invoice) {
    invoiceRepository.save(invoice);
  }

  public List<Invoice> findAllAvailableInvoice() {
    return invoiceRepository.findAll();
  }

  public void setPaidInvoice(Long id) {
    Invoice invoice = invoiceRepository.findById(id).orElse(null);
    invoice.setPaid(true);
    invoiceRepository.save(invoice);
  }

}
