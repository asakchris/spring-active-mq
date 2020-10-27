package org.example.model;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class MessageVo implements Serializable {

  private static final long serialVersionUID = 5719920770252249741L;

  @NotBlank
  @Size(min = 3, max = 50, message = "minimum 3 characters and maximum 50 characters in length")
  private String message;
}
