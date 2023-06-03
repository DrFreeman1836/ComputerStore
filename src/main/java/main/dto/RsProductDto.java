package main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import lombok.Data;
import main.enums.FormFactor;
import main.enums.SizeLaptop;
import main.model.Computer;
import main.model.Hdd;
import main.model.Laptop;
import main.model.Monitor;
import main.model.Product;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RsProductDto {

  private Integer series;

  private String manufacturer;

  private BigDecimal price;

  private Integer count;

  private Integer volume;

  private Integer diagonal;

  private SizeLaptop sizeLaptop;

  private FormFactor formFactor;

  public void fillFields(Product product) {
    this.series = product.getSeries();
    this.manufacturer = product.getManufacturer();
    this.count = product.getCount();
    this.price = product.getPrice();
  }

  public void fillFields(Hdd hdd) {
    if (hdd != null)
      this.volume = hdd.getVolume();
  }

  public void fillFields(Monitor monitor) {
    if (monitor != null)
      this.diagonal = monitor.getDiagonal();
  }

  public void fillFields(Laptop laptop) {
    if (laptop != null)
      this.sizeLaptop = laptop.getSizeLaptop();
  }

  public void fillFields(Computer computer) {
    if (computer != null)
      this.formFactor = computer.getFormFactor();
  }

}
