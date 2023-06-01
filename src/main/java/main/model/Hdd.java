package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hdd")
public class Hdd extends Product {

  /**
   * Объем жесткого диска
   */
  @Column(name = "volume")
  private Integer volume;

}
