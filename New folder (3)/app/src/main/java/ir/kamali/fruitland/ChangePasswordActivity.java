package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepasswordactivity);
    }
    public void Singin(View view) {
        Intent intent=new Intent(this,SinginActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}