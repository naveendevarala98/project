package ecommerce.model;

import java.util.List;

public class ProductListRequest {

    public List<ProductRequest> productRequestList;

    public List<ProductRequest> getProductRequestList() {
        return productRequestList;
    }

    public void setProductRequestList(List<ProductRequest> productRequestList) {
        this.productRequestList = productRequestList;
    }
}
