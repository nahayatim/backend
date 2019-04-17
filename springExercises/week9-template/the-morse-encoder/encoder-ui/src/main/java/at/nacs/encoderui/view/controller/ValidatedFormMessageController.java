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

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ValidatedFormMessageController {

  private ValidatedMessage validatedMessage=new ValidatedMessage();

  private final EncoderClient client;

  @ModelAttribute("validatedMessage")
  ValidatedMessage validatedMessage(){
    return validatedMessage;
  }


  @GetMapping
  String page(){
    return "messages/validated-form-message";
  }

  @PostMapping
  String post(@Valid ValidatedMessage validatedMessage, BindingResult result){
    if (result.hasErrors()){
      return page();
    }
    this.validatedMessage=validatedMessage;
    return "redirect:/message/form/validated";
  }
}
