package main.dto;

import java.math.BigDecimal;
import lombok.Data;
import main.model.Product;

@Data
public class RqProductDto {

  private Integer series;

  private String manufacturer;

  private BigDecimal price;

  private Integer count;

  public void fillFields(Product product) {
    this.series = product.getSeries();
    this.manufacturer = product.getManufacturer();
    this.count = product.getCount();
    this.price = product.getPrice();
  }

}
