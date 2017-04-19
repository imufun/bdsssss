package bdshop2.imran.com.bdshop3;

import bdshop2.imran.com.bdshop3.apisresponse.ContactResponse;
import bdshop2.imran.com.bdshop3.apisresponse.MovieTopRatedResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by imran on 4/13/2017.
 */

public interface ApiInterfaceService {


    @GET("/json_data.json")
    Call<ContactResponse> getContact();

    @GET("movie/top_rated")
    Call<MovieTopRatedResponse> getMovieTopRated(@Query("api_key") String api_key);

    @GET("movie/{id}")
    Call<MovieTopRatedResponse> getMovieTopRatedDetails(@Path("id") int id, @Query("api_key") String api_key);


}
