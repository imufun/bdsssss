package bdshop2.imran.com.bdshop3.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.ProductDeails;
import bdshop2.imran.com.bdshop3.R;
import bdshop2.imran.com.bdshop3.model.Product;

/**
 * Created by imran on 4/19/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MovieViewHolder> {

    Product product;
    private ArrayList<Product> products;
    private int rowlayout;
    private Context context;
    //private static final String BASE_URL = "https://image.tmdb.org/t/p/w150";


    public ProductAdapter(ArrayList<Product> products, int rowlayout, Context context) {
        this.products = products;
        this.rowlayout = rowlayout;
        this.context = context;
    }

    @Override
    public ProductAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowlayout, parent, false);
        return new MovieViewHolder(view, context, products);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.MovieViewHolder holder, int position) {

        holder.Titile.setText(products.get(position).getProductName());
        holder.Rating.setText(products.get(position).getBody());
        holder.popularity.setText(products.get(position).getPrice() + "");
        Glide.with(context).load(products.get(position).getImage()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return true;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return true;
            }
        }).diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade()
                .into(holder.imagethumbnil);


    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout linearlayout;//movietoprated
        TextView Titile, Rating, popularity;
        ImageView imagethumbnil;

        ArrayList<Product> products = new ArrayList<Product>();
        Context context;

        public MovieViewHolder(View view, Context context, ArrayList<Product> products) {

            super(view);
            this.context = context;
            this.products = products;
            view.setOnClickListener(this);
            linearlayout = (LinearLayout) itemView.findViewById(R.id.movietoprated);
            Titile = (TextView) itemView.findViewById(R.id.Titile);
            Rating = (TextView) itemView.findViewById(R.id.Rating);
            popularity = (TextView) itemView.findViewById(R.id.popularity);
            imagethumbnil = (ImageView) itemView.findViewById(R.id.productimage);

        }


        @Override
        public void onClick(View v) {


            int postion = getAdapterPosition();
            product = this.products.get(postion);
            Intent intent = new Intent(this.context, ProductDeails.class);

            intent.putExtra("Title", product.getProductName());
            intent.putExtra("Rating", product.getBody());
            intent.putExtra("popularity", product.getPrice());
            intent.putExtra("image", product.getImage());

            Toast.makeText(context, postion + " products selected", Toast.LENGTH_LONG).show();

        }
    }
}

