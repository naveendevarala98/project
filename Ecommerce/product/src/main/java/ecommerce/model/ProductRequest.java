package ecommerce.model;



public class ProductRequest {
    String productname;

    String produtDescription;

    int status;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProdutDescription() {
        return produtDescription;
    }

    public void setProdutDescription(String produtDescription) {
        this.produtDescription = produtDescription;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
