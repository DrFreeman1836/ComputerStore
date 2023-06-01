package main.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Product {

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

}
