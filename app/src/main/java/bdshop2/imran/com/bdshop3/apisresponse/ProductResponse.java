package bdshop2.imran.com.bdshop3.apisresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.model.Prodcut;

/**
 * Created by imran on 4/13/2017.
 */

public class ProductResponse {
    @SerializedName("tbl_product")
    @Expose
    private ArrayList<Prodcut> prodcuts = new ArrayList<>();

    public ArrayList<Prodcut> getProdcuts() {
        return prodcuts;
    }

    public void setProdcuts(ArrayList<Prodcut> prodcuts) {
        this.prodcuts = prodcuts;
    }
}
