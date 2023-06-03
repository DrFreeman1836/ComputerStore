package main.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import main.enums.FormFactor;

@Getter
@Setter
@Entity
@Table(name = "computer")
public class Computer implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne
  @MapsId
  @JoinColumn(name = "product_id")
  private Product product;

  /**
   * Форм-фактор
   */
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('DESKTOP', 'NETTOP', 'MONOBLOCK')", name = "form_factor")
  private FormFactor formFactor;

}
