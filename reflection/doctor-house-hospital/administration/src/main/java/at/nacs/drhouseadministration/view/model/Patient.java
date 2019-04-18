package at.nacs.drhouseadministration.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

  @NotEmpty
  private String name;

  @NotEmpty
  private String symptoms;
}
