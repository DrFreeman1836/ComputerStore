package main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product implements Serializable {

  /**
   * id товара
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  protected Long id;

  /**
   * Номер серии
   */
  @Column(name = "series")
  protected Integer series;

  /**
   * Производитель
   */
  @Column(name = "manufacturer")
  protected String manufacturer;

  /**
   * Цена
   */
  @Column(columnDefinition = "decimal(6,2)", name = "price")
  protected BigDecimal price;

  /**
   * Кол-во товара на складе
   */
  @Column(name = "count")
  protected Integer count;

  @JsonIgnore()
  @OneToOne(mappedBy = "product", fetch = FetchType.EAGER)
  private Laptop laptop;

  @JsonIgnore()
  @OneToOne(mappedBy = "product", fetch = FetchType.EAGER)
  private Hdd hdd;

  @JsonIgnore()
  @OneToOne(mappedBy = "product", fetch = FetchType.EAGER)
  private Computer computer;

  @JsonIgnore()
  @OneToOne(mappedBy = "product", fetch = FetchType.EAGER)
  private Monitor monitor;

}
