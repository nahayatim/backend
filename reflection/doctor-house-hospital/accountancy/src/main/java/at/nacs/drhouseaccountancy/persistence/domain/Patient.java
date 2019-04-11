package at.nacs.drhouseaccountancy.persistence.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
public class Patient {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String name;
  

}
