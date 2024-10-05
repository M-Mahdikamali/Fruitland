package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.goodiebag.pinview.Pinview;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class FP_VerificationActivity extends AppCompatActivity {
    Pinview pinview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fp_verificationactivity);
        pinview =(Pinview)findViewById(R.id.otp_Edit_text);

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener(){
            @Override
                    public void onDataEntered(Pinview pinview,boolean b){
            }
        });

    }
    public void ChangePassword(View view) {
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        startActivity(intent);
    }
    public void Sing_in_up(View view) {
        Intent intent = new Intent(this, ForgetPassActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}