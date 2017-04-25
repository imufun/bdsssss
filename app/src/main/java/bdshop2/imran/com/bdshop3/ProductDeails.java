package bdshop2.imran.com.bdshop3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDeails extends AppCompatActivity {
    TextView Titile, ReleaseDate, Rating, popularity, vote_count, video, vote_average, overview, adult;
    ImageView imagethumbnil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_deails);


        //linearlayout = (LinearLayout) itemView.findViewById(R.id.movietoprated);

        Titile = (TextView) findViewById(R.id.Titile);
        Rating = (TextView) findViewById(R.id.Rating);
        popularity = (TextView) findViewById(R.id.popularity);
        imagethumbnil = (ImageView) findViewById(R.id.productimage);

        Titile.setText("Title :" + getIntent().getStringExtra("Title"));
        Rating.setText("Rating " + getIntent().getStringExtra("Rating"));
        popularity.setText("popularity " + getIntent().getStringExtra("popularity"));
        imagethumbnil.setImageResource(getIntent().getIntExtra("image", 00));
    }
}
