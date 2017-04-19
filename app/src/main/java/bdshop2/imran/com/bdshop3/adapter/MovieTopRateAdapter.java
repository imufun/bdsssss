package bdshop2.imran.com.bdshop3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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


    }

    @Override
    public int getItemCount() {
        return movietoprates.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearlayout;//movietoprated
        TextView Titile, ReleaseDate, Rating, popularity, vote_count, video, vote_average, overview, adult;
        //ImageView Rating, imagethumbnil;
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
            //  adult = (TextView) itemView.findViewById(R.id.adult);
        }
    }
}
