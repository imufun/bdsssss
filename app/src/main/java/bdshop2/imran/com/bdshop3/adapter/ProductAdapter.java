package bdshop2.imran.com.bdshop3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.R;
import bdshop2.imran.com.bdshop3.model.Prodcut;

/**
 * Created by imran on 4/19/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MovieViewHolder> {


    private ArrayList<Prodcut> prodcuts;
    private int rowlayout;
    private Context context;
    //private static final String BASE_URL = "https://image.tmdb.org/t/p/w150";


    public ProductAdapter(ArrayList<Prodcut> prodcuts, int rowlayout, Context context) {
        this.prodcuts = prodcuts;
        this.rowlayout = rowlayout;
        this.context = context;
    }

    @Override
    public ProductAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowlayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.MovieViewHolder holder, int position) {

        holder.Titile.setText(prodcuts.get(position).getProductName());
        holder.Rating.setText(prodcuts.get(position).getBody());
        holder.popularity.setText(prodcuts.get(position).getPrice() + "");
        Glide.with(context).load(prodcuts.get(position).getImage()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade()
                .into(holder.imagethumbnil);


    }

    @Override
    public int getItemCount() {
        return prodcuts.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearlayout;//movietoprated
        TextView Titile, ReleaseDate, Rating, popularity, vote_count, video, vote_average, overview, adult;
        ImageView imagethumbnil;


        public MovieViewHolder(View v) {
            super(v);
            linearlayout = (LinearLayout) itemView.findViewById(R.id.movietoprated);
            Titile = (TextView) itemView.findViewById(R.id.Titile);
            Rating = (TextView) itemView.findViewById(R.id.Rating);
            popularity = (TextView) itemView.findViewById(R.id.popularity);
            imagethumbnil = (ImageView) itemView.findViewById(R.id.imagethumbnil);

        }
    }
}

