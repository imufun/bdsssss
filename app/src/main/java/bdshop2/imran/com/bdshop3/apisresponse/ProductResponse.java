package bdshop2.imran.com.bdshop3.apisresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.model.Product;

/**
 * Created by imran on 4/13/2017.
 */

public class ProductResponse {
    @SerializedName("Products")
    @Expose
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
