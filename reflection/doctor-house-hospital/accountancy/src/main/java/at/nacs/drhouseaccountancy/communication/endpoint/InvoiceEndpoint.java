package at.nacs.drhouseaccountancy.communication.endpoint;

import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/invoices")
@RestController
@RequiredArgsConstructor
public class InvoiceEndpoint {

  private final InvoiceManager invoiceManager;

  @GetMapping
  public List<Invoice> findAll() {
    return invoiceManager.findAllAvailableInvoice();
  }

  @PutMapping("/{id}/paid")
  public void setPaidInvoice(@PathVariable Long id) {
    invoiceManager.setPaidInvoice(id);
  }


}
