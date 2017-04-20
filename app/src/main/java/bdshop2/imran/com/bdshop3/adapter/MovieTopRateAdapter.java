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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.R;
import bdshop2.imran.com.bdshop3.model.MovieTopRated;

/**
 * Created by imran on 4/19/2017.
 */

public class MovieTopRateAdapter extends RecyclerView.Adapter<MovieTopRateAdapter.MovieViewHolder> {

    private ArrayList<MovieTopRated> movietoprates;
    private int rowlayout;
    private Context context;
    private static final String BASE_URL = "https://image.tmdb.org/t/p/w150";


    public MovieTopRateAdapter(ArrayList<MovieTopRated> movietoprates, int rowlayout, Context context) {
        this.movietoprates = movietoprates;
        this.rowlayout = rowlayout;
        this.context = context;
    }




    @Override
    public MovieTopRateAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowlayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieTopRateAdapter.MovieViewHolder holder, int position) {


//        holder.movieTitle.setText(movietoprates.get(position).getTitle());
//        holder.data.setText(movietoprates.get(position).getReleaseDate());
//        holder.movieDescription.setText(movietoprates.get(position).getOverview());
//        holder.rating.setText(movietoprates.get(position).getVoteAverage() + "");


        holder.Titile.setText(movietoprates.get(position).getTitle());
        holder.ReleaseDate.setText(movietoprates.get(position).getReleaseDate());
        holder.Rating.setText((int) movietoprates.get(position).getVoteAverage() + "");
        holder.popularity.setText((int) movietoprates.get(position).getPopularity() + "");
        holder.vote_count.setText(movietoprates.get(position).getVoreCount() + "");
        holder.overview.setText(movietoprates.get(position).getOverview());
        // holder.adult.setText(movietoprates.get(position).toString());
        //Picasso.with(context).load(item.getProfilePic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);
        Picasso.with(context).load(BASE_URL + movietoprates.get(position).getPosterPath()).into(holder.imagethumbnil);

        Glide.with(context).load(BASE_URL + movietoprates.get(position).getPosterPath()).listener(new RequestListener<String, GlideDrawable>() {
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
        return  movietoprates.size();
    }



    public class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearlayout;//movietoprated
        TextView Titile, ReleaseDate, Rating, popularity, vote_count, video, vote_average, overview, adult;
        ImageView imagethumbnil;

        public MovieViewHolder(View v) {
            super(v);
            linearlayout = (LinearLayout) itemView.findViewById(R.id.movietoprated);
            Titile = (TextView) itemView.findViewById(R.id.Titile);
            ReleaseDate = (TextView) itemView.findViewById(R.id.ReleaseDate);
            Rating = (TextView) itemView.findViewById(R.id.Rating);
            popularity = (TextView) itemView.findViewById(R.id.popularity);
            vote_count = (TextView) itemView.findViewById(R.id.vote_count);
            video = (TextView) itemView.findViewById(R.id.video);
            vote_average = (TextView) itemView.findViewById(R.id.vote_average);
            overview = (TextView) itemView.findViewById(R.id.overview);
            imagethumbnil = (ImageView) itemView.findViewById(R.id.imagethumbnil);

            //  adult = (TextView) itemView.findViewById(R.id.adult);
        }
    }


}
