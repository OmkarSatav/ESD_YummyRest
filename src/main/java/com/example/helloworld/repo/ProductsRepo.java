//package com.example.helloworld.repo;
//
//import com.example.helloworld.entity.Products;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import java.util.List;
//
//
//public interface ProductsRepo extends JpaRepository<Products, Long> {
//    Optional<Products> findById(Long Id);
//
//    @Query("SELECT p FROM Products p WHERE p.price BETWEEN :low AND :high ORDER BY p.price ASC")
//    List<Products> findTop2ByPriceBetweenOrderByPriceAsc(@Param("low") String low, @Param("high") String high);
//}