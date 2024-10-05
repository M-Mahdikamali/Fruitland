package ir.kamali.fruitland;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;


public class Bottombar extends AppCompatActivity {
    public static String lastname;
    public static String firstname;
    public static String Pass;
    public static String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        setContentView(R.layout.bottombar);

        lastname=getIntent().getStringExtra("lastname");
        firstname=getIntent().getStringExtra("firstname");
        Pass=getIntent().getStringExtra("pass");
        Email=getIntent().getStringExtra("email");

        BottomNavigationView bottomNav = findViewById(R.id.Bottombar);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.constraint,new Home()).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.profile:
                            selectedFragment = new Profile();
                            break;
                        case R.id.delivery:
                            selectedFragment = new Delivery();
                            break;
                        case R.id.basket:
                            selectedFragment = new Basket();
                            break;
                        case R.id.home:
                            selectedFragment = new Home();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.constraint, selectedFragment).commit();
                    return true;
                }
            };
}