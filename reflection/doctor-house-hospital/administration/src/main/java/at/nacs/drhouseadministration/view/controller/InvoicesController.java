package at.nacs.drhouseadministration.view.controller;


import at.nacs.drhouseadministration.communication.AccountancyClient;
import at.nacs.drhouseadministration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoicesController {


  private final AccountancyClient accountancyClient;

  @GetMapping
  String Ivoices() {
    return "invoices";
  }

  @ModelAttribute("invoices")
  Invoice[] invoices() {
    return accountancyClient.getAllInvoices();
  }

  @PostMapping("/paid")
  String invoicesThatPaid(@RequestParam String id) {
    accountancyClient.PaidBy(id);
    return "redirect:/invoices";

  }
}
