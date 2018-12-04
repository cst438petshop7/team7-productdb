package edu.csumb.cst438.productdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.cst438.productdb.products.Product;
import edu.csumb.cst438.productdb.products.Stock;

@RestController
public class ProductController {
    @Autowired
    IProductRepository productRepository;
     
    @CrossOrigin(origins = "*") 
    @GetMapping ("/allProducts") 
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
    
    @CrossOrigin(origins = "*") 
    @GetMapping ("/id/{id}")
    public Product getProductById (@PathVariable String id) {
        Product result = productRepository.findByRepoId(id);
        return result;
    }

    @CrossOrigin(origins = "*") 
    @GetMapping ("/name/{name}")
    public Product getProductByProductName (@PathVariable String name) {
        Product result = productRepository.findByProductName(name);
        return result;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/update/{id}/{amount}")
    ResponseEntity<Product> updateProduct(@PathVariable String id, @PathVariable int amount) {
        Product productData = productRepository.findByRepoId(id);
        if (productData == null) { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
        productData.setStock(new Stock(productData.getStock().getStock() - amount));
        productRepository.save(productData);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}