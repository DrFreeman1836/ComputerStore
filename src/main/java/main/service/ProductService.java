package main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import main.dto.RqProductDto;
import main.dto.RsProductDto;
import main.enums.FormFactor;
import main.enums.SizeLaptop;
import main.model.Computer;
import main.model.Hdd;
import main.model.Laptop;
import main.model.Monitor;
import main.model.Product;
import main.repository.ComputerRepo;
import main.repository.HddRepo;
import main.repository.LaptopRepo;
import main.repository.MonitorRepo;
import main.repository.ProductRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepo productRepo;
  private final ComputerRepo computerRepo;
  private final HddRepo hddRepo;
  private final LaptopRepo laptopRepo;
  private final MonitorRepo monitorRepo;

  private static final String HDD = "hdd";
  private static final String LAPTOP = "laptop";
  private static final String COMPUTER = "computer";
  private static final String MONITOR = "monitor";

  public Product addProduct(RqProductDto product, Integer volume, Integer diagonal, String sizeLaptop, String formFactor) throws Exception {
    Product productEntity = new Product();
    productEntity.setManufacturer(product.getManufacturer());
    productEntity.setCount(product.getCount());
    productEntity.setPrice(product.getPrice());
    productEntity.setSeries(product.getSeries());
    if (volume != null) {
      saveHdd(productEntity, volume);
    }
    if (diagonal != null) {
      saveMonitor(productEntity, diagonal);
    }
    if (sizeLaptop != null) {
      saveLaptop(productEntity, SizeLaptop.valueOf(sizeLaptop));
    }
    if (formFactor != null) {
      saveComputer(productEntity, FormFactor.valueOf(formFactor));
    }
    return productRepo.save(productEntity);
  }

  public Product updateProduct(Long id, RqProductDto product, Integer volume, Integer diagonal, String sizeLaptop, String formFactor) throws  Exception {
    Product productEntity = productRepo.findById(id).get();
    productEntity.setSeries(product.getSeries());
    productEntity.setPrice(product.getPrice());
    productEntity.setManufacturer(productEntity.getManufacturer());
    productEntity.setCount(product.getCount());
    if (volume != null) {
      updateHdd(productEntity, volume);
    }
    if (diagonal != null) {
      updateMonitor(productEntity, diagonal);
    }
    if (sizeLaptop != null) {
      updateLaptop(productEntity, SizeLaptop.valueOf(sizeLaptop));
    }
    if (formFactor != null) {
      updateComputer(productEntity, FormFactor.valueOf(formFactor));
    }
    productRepo.flush();
    return productEntity;
  }

  public List<RsProductDto> findAllByType(String type) throws Exception {
    List<RsProductDto> prList = new ArrayList<>();
    if (HDD.equals(type)) {
      prList = hddRepo.findAll().stream().map(hdd -> {
        RsProductDto productDto = new RsProductDto();
        productDto.fillFields(hdd.getProduct());
        productDto.setVolume(hdd.getVolume());
        return productDto;
      }).collect(Collectors.toList());
    } else if (LAPTOP.equals(type)) {
      prList = laptopRepo.findAll().stream().map(laptop -> {
        RsProductDto productDto = new RsProductDto();
        productDto.fillFields(laptop.getProduct());
        productDto.setSizeLaptop(laptop.getSizeLaptop());
        return productDto;
      }).collect(Collectors.toList());
    } else if (MONITOR.equals(type)) {
      prList = monitorRepo.findAll().stream().map(monitor -> {
        RsProductDto productDto = new RsProductDto();
        productDto.fillFields(monitor.getProduct());
        productDto.setDiagonal(monitor.getDiagonal());
        return productDto;
      }).collect(Collectors.toList());
    } else if (COMPUTER.equals(type)) {
      prList = computerRepo.findAll().stream().map(computer -> {
        RsProductDto productDto = new RsProductDto();
        productDto.fillFields(computer.getProduct());
        productDto.setFormFactor(computer.getFormFactor());
        return productDto;
      }).collect(Collectors.toList());
    }
    return prList;
  }

  public RsProductDto findById(Long id) {
    Product product = productRepo.findById(id).get();
    RsProductDto productDto = new RsProductDto();
    productDto.fillFields(product);
    productDto.fillFields(product.getHdd());
    productDto.fillFields(product.getComputer());
    productDto.fillFields(product.getLaptop());
    productDto.fillFields(product.getMonitor());
    return productDto;
  }

  private void saveHdd(Product product, Integer volume) {
    Hdd hdd = new Hdd();
    hdd.setProduct(product);
    hdd.setVolume(volume);
    product.setHdd(hddRepo.save(hdd));
  }

  private void saveMonitor(Product product, Integer diagonal) {
    Monitor monitor = new Monitor();
    monitor.setProduct(product);
    monitor.setDiagonal(diagonal);
    product.setMonitor(monitorRepo.save(monitor));
  }

  private void saveLaptop(Product product, SizeLaptop sizeLaptop) {
    Laptop laptop = new Laptop();
    laptop.setProduct(product);
    laptop.setSizeLaptop(sizeLaptop);
    product.setLaptop(laptopRepo.save(laptop));
  }

  private void saveComputer(Product product, FormFactor formFactor) {
    Computer computer = new Computer();
    computer.setProduct(product);
    computer.setFormFactor(formFactor);
    product.setComputer(computerRepo.save(computer));
  }

  private void updateHdd(Product product, Integer volume) {
    Hdd hdd = hddRepo.findById(product.getId()).get();
    hdd.setVolume(volume);
    hddRepo.flush();
  }

  private void updateMonitor(Product product, Integer diagonal) {
    Monitor monitor = monitorRepo.findById(product.getId()).get();
    monitor.setDiagonal(diagonal);
    monitorRepo.flush();
  }

  private void updateLaptop(Product product, SizeLaptop sizeLaptop) {
    Laptop laptop = laptopRepo.findById(product.getId()).get();
    laptop.setSizeLaptop(sizeLaptop);
    laptopRepo.flush();
  }

  private void updateComputer(Product product, FormFactor formFactor) {
    Computer computer = computerRepo.findById(product.getId()).get();
    computer.setFormFactor(formFactor);
    computerRepo.flush();
  }

}
