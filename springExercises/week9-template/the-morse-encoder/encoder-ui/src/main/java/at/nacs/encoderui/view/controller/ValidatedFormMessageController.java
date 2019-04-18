package at.nacs.encoderui.view.controller;

import at.nacs.encoderui.communication.EncoderClient;
import at.nacs.encoderui.view.model.ValidatedMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ValidatedFormMessageController {

  private final EncoderClient client;

  @ModelAttribute("validatedMessage")
  ValidatedMessage validatedMessage(){
    return new ValidatedMessage();
  }


  @GetMapping
  String page(){
    return "messages/validated-form-message";
  }

  @PostMapping
  String post(@Valid ValidatedMessage validatedMessage, BindingResult result, RedirectAttributesModelMap redirect){
    if (result.hasErrors()){
      return page();
    }

    redirect.addFlashAttribute("encoded",client.send(validatedMessage.getText()));
    return "redirect:/";
  }
}
