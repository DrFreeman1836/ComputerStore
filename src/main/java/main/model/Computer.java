package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Data;
import main.enums.FormFactor;

@Data
@Entity
@Table(name = "computer")
public class Computer extends Product {

  /**
   * Форм-фактор
   */
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('DESKTOP', 'NETTOP', 'MONOBLOCK')", name = "form_factor")
  private FormFactor formFactor;

}
