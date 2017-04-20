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
import bdshop2.imran.com.bdshop3.model.MovieTopRated;

/**
 * Created by imran on 4/19/2017.
 */

public class MovieTopRateAdapter extends RecyclerView.Adapter<MovieTopRateAdapter.MovieViewHolder> {

    private ArrayList<MovieTopRated> movietoprates;
    private int rowlayout;
    private Context context;


    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private static final String BASE_URL = "https://image.tmdb.org/t/p/w150";


    private boolean isLoadingAdded = false;

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
        // Picasso.with(context).load(movietoprates.get(position).getPosterPath()).into(holder.imagethumbnil);
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
        return movietoprates == null ? 0 : movietoprates.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == movietoprates.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(MovieTopRated r) {
        movietoprates.add(r);
        notifyItemInserted(movietoprates.size() - 1);
    }

    public void addAll(ArrayList<MovieTopRated> movietoprates) {
        for (MovieTopRated result : movietoprates) {
            add(result);
        }
    }

    public void remove(MovieTopRated r) {
        int position = movietoprates.indexOf(r);
        if (position > -1) {
            movietoprates.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new MovieTopRated());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = movietoprates.size() - 1;
        MovieTopRated result = getItem(position);

        if (result != null) {
            movietoprates.remove(position);
            notifyItemRemoved(position);
        }
    }

    public MovieTopRated getItem(int position) {
        return movietoprates.get(position);
    }
    public class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearlayout;//movietoprated
        TextView Titile, ReleaseDate, Rating, popularity, vote_count, video, vote_average, overview, adult;
        ImageView imagethumbnil;
//        LinearLayout moviesLayout;
//        TextView movieTitle;
//        TextView data;
//        TextView movieDescription;
//        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
//            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
//            movieTitle = (TextView) v.findViewById(R.id.title);
//            data = (TextView) v.findViewById(R.id.subtitle);
//            movieDescription = (TextView) v.findViewById(R.id.description);
//            rating = (TextView) v.findViewById(R.id.rating);

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

    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }

    /* geter and seter*/

    public ArrayList<MovieTopRated> getMovietoprates() {
        return movietoprates;
    }

    public void setMovietoprates(ArrayList<MovieTopRated> movietoprates) {
        this.movietoprates = movietoprates;
    }

    public int getRowlayout() {
        return rowlayout;
    }

    public void setRowlayout(int rowlayout) {
        this.rowlayout = rowlayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static int getITEM() {
        return ITEM;
    }

    public static int getLOADING() {
        return LOADING;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public boolean isLoadingAdded() {
        return isLoadingAdded;
    }

    public void setLoadingAdded(boolean loadingAdded) {
        isLoadingAdded = loadingAdded;
    }

}
