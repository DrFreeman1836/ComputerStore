package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Data;
import main.enums.SizeLaptop;

@Data
@Entity
@Table(name = "laptop")
public class Laptop extends Product {

  /**
   * Размер ноутбука
   */
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('DIAGONAL_13', 'DIAGONAL_14', 'DIAGONAL_15', 'DIAGONAL_17')", name = "size_laptop")
  private SizeLaptop sizeLaptop;

}
