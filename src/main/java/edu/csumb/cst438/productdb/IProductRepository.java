package edu.csumb.cst438.productdb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.csumb.cst438.productdb.products.Product;

@Repository
public interface IProductRepository extends MongoRepository<Product, String> {
    @Query (value = "{'id':?0}")
    Product findByRepoId(String id);

    @Query (value = "{'name.name':?0}")
    Product findByProductName(String name);
}