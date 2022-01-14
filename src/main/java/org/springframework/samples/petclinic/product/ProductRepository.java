package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
    
    @Query("SELECT t from ProductType t")
    List<ProductType> findAllProductTypes();
    
    @Query("SELECT p FROM ProductType p WHERE p.name = :name")
    ProductType getProductType(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> getProductsCheaperThan(@Param("price") Double price);
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
