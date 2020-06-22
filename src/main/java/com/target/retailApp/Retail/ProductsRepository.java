package com.target.retailApp.Retail;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductsRepository extends MongoRepository<Product, String> {
	Product findByProductId(@Param("productId") String productId);
}
