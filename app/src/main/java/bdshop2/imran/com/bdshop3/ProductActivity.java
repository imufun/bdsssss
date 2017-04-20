package bdshop2.imran.com.bdshop3;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.adapter.ProductAdapter;
import bdshop2.imran.com.bdshop3.apisresponse.ProductResponse;
import bdshop2.imran.com.bdshop3.model.Prodcut;
import bdshop2.imran.com.bdshop3.utils.InternetConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    private static final String TAG = ProductActivity.class.getName();

    // private RetroClient retroClient;
    ProgressDialog dialog;

    // ProgressBar progressBar;
    private RecyclerView recyclerView;
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
        setContentView(R.layout.activity_product);
        //retroClient = new RetroClient();

        // topRateAdapter = new MovieTopRateAdapter(movieTopRateds);
        //   progressBar = (ProgressBar) findViewById(R.id.main_progress);
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if (InternetConnection.checkConnection(getApplicationContext())) {

            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(ProductActivity.this);
            dialog.setTitle(getString(R.string.string_getting_json_title));
            dialog.setMessage(getString(R.string.string_getting_json_message));
            dialog.show();
        }
        //  https://api.themoviedb.org/3/movie/top_rated?=de05a59a85ef1e7797de8d4a6d343d0e
        ApiInterfaceService apiInterfaceService = RetroClient.getRetrofitInstanceStore().create(ApiInterfaceService.class);

        Call<ProductResponse> call = apiInterfaceService.getProductResponse();

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                dialog.dismiss();
                ArrayList<Prodcut> prodcuts = response.body().getProdcuts();
                recyclerView.setAdapter(new ProductAdapter(prodcuts, R.layout.layout_row_product, getApplicationContext()));

                Log.d(TAG, "Number of movies received: " + prodcuts.size());

            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

    }


}
