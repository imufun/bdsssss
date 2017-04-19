package bdshop2.imran.com.bdshop3.apisresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import bdshop2.imran.com.bdshop3.model.MovieTopRated;

/**
 * Created by imran on 4/19/2017.
 */

public class MovieTopRatedResponse {

    @SerializedName("page")
    private int Page;
    @SerializedName("results")
    @Expose
    private List<MovieTopRated> movieResult;

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public List<MovieTopRated> getMovieResult() {
        return movieResult;
    }

    public void setMovieResult(List<MovieTopRated> movieResult) {
        this.movieResult = movieResult;
    }
}
