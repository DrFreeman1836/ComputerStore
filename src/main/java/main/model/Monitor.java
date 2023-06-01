package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "monitor")
public class Monitor extends Product {

  /**
   * Диагональ монитора
   */
  @Column(name = "diagonal")
  private Integer diagonal;

}
