package bdshop2.imran.com.bdshop3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by imran on 4/20/2017.
 */

public class Product {

   //String imageurl = "http://192.168.56.1:8080/Book/admin/";
    @SerializedName("productName")
    @Expose
    private String ProductName;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("image")
    @Expose
    private String image;

    public Product(String productName, String body, String price, String image) {
        ProductName = productName;
        this.body = body;
        this.price = price;
        this.image = image;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return   image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
