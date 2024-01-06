package ecommerce.model;

import ecommerce.entity.Product;

import java.util.List;


public class Response {

    private List<Product> productList;

    private String message;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
