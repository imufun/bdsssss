package bdshop2.imran.com.bdshop3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by imran on 4/13/2017.
 */

public class RetroClient {

    private static final String BASE_URL = "http://pratikbutani.x10.mx";
    // private static final String MOVIE_URL="https://api.themoviedb.org/3/movie/550?api_key=de05a59a85ef1e7797de8d4a6d343d0e";

    private static final String MOVIE_URL = "https://api.themoviedb.org/3/";
    private static final String Store = "http://192.168.56.1:8080/APIs/public/";



    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofitInstanceMovie() {
        return new Retrofit.Builder()
                .baseUrl(MOVIE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static Retrofit getRetrofitInstanceStore() {
        return new Retrofit.Builder()
                .baseUrl(Store)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static ApiInterfaceService getContactJSON() {
        return getRetrofitInstance().create(ApiInterfaceService.class);
    }


}
