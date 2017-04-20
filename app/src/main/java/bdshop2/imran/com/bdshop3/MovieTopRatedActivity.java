package bdshop2.imran.com.bdshop3;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bdshop2.imran.com.bdshop3.adapter.MovieTopRateAdapter;
import bdshop2.imran.com.bdshop3.apisresponse.MovieTopRatedResponse;
import bdshop2.imran.com.bdshop3.model.MovieTopRated;
import bdshop2.imran.com.bdshop3.utils.InternetConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieTopRatedActivity extends AppCompatActivity {

    private static final String TAG = MovieTopRatedActivity.class.getName();
    private static final String api_key = "de05a59a85ef1e7797de8d4a6d343d0e";

    // private RetroClient retroClient;
    ProgressDialog dialog;

    ProgressBar progressBar;
    private RecyclerView recyclerView;
    private MovieTopRateAdapter topRateAdapter;
    LinearLayoutManager linearLayoutManager;

    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 5;
    private int currentPage = PAGE_START;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_top_rated);
        //retroClient = new RetroClient();

        // topRateAdapter = new MovieTopRateAdapter(movieTopRateds);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        if (api_key.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.api_key, Toast.LENGTH_LONG).show();
        }

        if (InternetConnection.checkConnection(getApplicationContext())) {

            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(MovieTopRatedActivity.this);
            dialog.setTitle(getString(R.string.string_getting_json_title));
            dialog.setMessage(getString(R.string.string_getting_json_message));
            dialog.show();
        }
        //  https://api.themoviedb.org/3/movie/top_rated?=de05a59a85ef1e7797de8d4a6d343d0e
        ApiInterfaceService apiInterfaceService = RetroClient.getRetrofitInstanceMovie().create(ApiInterfaceService.class);

        Call<MovieTopRatedResponse> call = apiInterfaceService.getMovieTopRated(api_key);

        call.enqueue(new Callback<MovieTopRatedResponse>() {
            @Override
            public void onResponse(Call<MovieTopRatedResponse> call, Response<MovieTopRatedResponse> response) {
                dialog.dismiss();
                List<MovieTopRated> movieTopRates = response.body().getMovieResult();
                recyclerView.setAdapter(new MovieTopRateAdapter((ArrayList<MovieTopRated>) movieTopRates, R.layout.layout_row_top_rated, getApplicationContext()));

                Log.d(TAG, "Number of movies received: " + movieTopRates.size());

            }

            @Override
            public void onFailure(Call<MovieTopRatedResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

    }


}
