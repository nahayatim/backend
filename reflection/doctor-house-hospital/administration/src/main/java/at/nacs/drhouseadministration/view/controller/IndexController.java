package at.nacs.drhouseadministration.view.controller;

import at.nacs.drhouseadministration.communication.AdmissionsClient;
import at.nacs.drhouseadministration.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

  private final AdmissionsClient admissionsClient;

  @ModelAttribute("patient")
  Patient patient() {
    return new Patient();
  }

  @GetMapping
  String page() {
    return "index";
  }

  @PostMapping
  String post(@Valid Patient patient, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return page();
    }
    admissionsClient.admit(patient);
    return "redirect:/";
  }

}
