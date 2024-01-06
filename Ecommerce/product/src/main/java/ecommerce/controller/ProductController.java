package ecommerce.controller;

import ecommerce.entity.Product;
import ecommerce.model.ProductListRequest;
import ecommerce.model.ProductRequest;
import ecommerce.model.Response;
import ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<List<ProductRequest>> addProducts(@RequestBody ProductListRequest product){
       List<Product> p= product.getProductRequestList().stream()
                .map(ProductController::mapperProduct)
                .collect(Collectors.toList());

        List<Product> d = productRepository.saveAll(p);
        return new ResponseEntity<>(product.getProductRequestList()
                ,HttpStatus.OK);
    }

    private static Product mapperProduct(ProductRequest productRequest){
        Product productData = new Product();
        productData.setProductName(productRequest.getProductname());
        productData.setProductDescription(productRequest.getProdutDescription());
        return productData;
    }

    @GetMapping(value={
            "/get",
            "/get/{productId}"
    })
    public Response getProductDetails(@PathVariable(value = "productId", required = false) Long productId){
        Response response = new Response();
        if(productId != null) {
            Optional<Product> product = productRepository.findById(productId);
            if(product.isPresent()){
                List<Product> productList = new ArrayList<>();
                productList.add(product.get());
                 response.setProductList(productList);
                 return response;
            }else{
                response.setMessage("No Content");
                return response;
            }
        }
        List<Product> productList = productRepository.findAll();
        response.setProductList(productList);
            return response;
    }

     
}
