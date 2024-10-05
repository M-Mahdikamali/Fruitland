package ir.kamali.fruitland;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class Nextpagebasket extends AppCompatActivity {

    public static ViewPager viewPager;
    SlideViewPagerAdapter adapter;
    public static View currentView;
    public static String total;
    public static TextView ghimatekole;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater= (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        currentView =layoutInflater.inflate(R.layout.slidescreen , null);

        setContentView(R.layout.nextpagebasket);
        ghimatekole= findViewById(R.id.ghimatekol);
        total = getIntent().getStringExtra("total");
        ghimatekole.setText(total + " تومان ");

        viewPager=findViewById(R.id.viewpager);
        adapter=new SlideViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

    }
}