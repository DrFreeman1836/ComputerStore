package main.controller;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import main.dto.RqProductDto;
import main.dto.RsProductDto;
import main.model.Product;
import main.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class StoreController {

  private final ProductService productService;

  @PostMapping("")
  public ResponseEntity<Long> addProduct(@RequestBody RqProductDto product,
      @RequestParam(name = "volume", required = false) Integer volume,
      @RequestParam(name = "diagonal", required = false) Integer diagonal,
      @RequestParam(name = "sizeLaptop", required = false) String sizeLaptop,
      @RequestParam(name = "formFactor", required = false) String formFactor) {
    try {
      Product productEntity = productService.addProduct(product, volume, diagonal, sizeLaptop, formFactor);
      return ResponseEntity.ok(productEntity.getId());
    } catch (Exception e) {
      return ResponseEntity.status(400).body(0L);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Long> updateProduct(@PathVariable Long id, @RequestBody RqProductDto product,
      @RequestParam(name = "volume", required = false) Integer volume,
      @RequestParam(name = "diagonal", required = false) Integer diagonal,
      @RequestParam(name = "sizeLaptop", required = false) String sizeLaptop,
      @RequestParam(name = "formFactor", required = false) String formFactor) {
    try {
      Product productEntity = productService.updateProduct(id, product, volume, diagonal, sizeLaptop, formFactor);
      return ResponseEntity.ok(productEntity.getId());
    } catch (Exception e) {
      return ResponseEntity.status(400).body(0L);
    }
  }

  @GetMapping("")
  public ResponseEntity<List<RsProductDto>> findAllByType(@RequestParam(name = "type") String type) {
    try {
      List<RsProductDto> prList = productService.findAllByType(type);
      return ResponseEntity.ok(prList);
    } catch (Exception e) {
      return ResponseEntity.status(400).body(Collections.emptyList());
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<RsProductDto> findProductById(@PathVariable Long id) {
    try {
      RsProductDto product = productService.findById(id);
      return ResponseEntity.ok(product);
    } catch (Exception e) {
      return ResponseEntity.status(400).body(new RsProductDto());
    }
  }

}
