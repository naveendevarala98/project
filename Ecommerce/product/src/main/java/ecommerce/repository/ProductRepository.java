package ecommerce.repository;

import ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product,Long> {

//    @Query("update Product p from Product where p.productId = :productId")
//    public Product updateProduct()
    @Query(value="call getProductDetails(:id)",nativeQuery = true)
    public Product fetchProductBasedOnId(@Param("id") Integer id);

}
