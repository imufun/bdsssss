package bdshop2.imran.com.bdshop3.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import java.io.File;

/**
 * Created by imran on 4/12/2017.
 */

public class MyFonts extends TextView {
    public MyFonts(Context context) {
        super(context);
    }

    public MyFonts(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFonts(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyFonts(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    private void parseAttribute(Context context, AttributeSet attrs) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts" + File.separator + "Roboto-Bold.ttf"));
    }
}
