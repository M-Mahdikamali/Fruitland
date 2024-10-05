package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.goodiebag.pinview.Pinview;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SU_VerificationActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Pinview pinview1;
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.su_verificationactivity);

        pinview1 =(Pinview)findViewById(R.id.otp_Edit_text2);

        pinview1.setPinViewEventListener(new Pinview.PinViewEventListener(){
            @Override
            public void onDataEntered(Pinview pinview,boolean b){
            }
        });

    }
    public void User_Information(View view) {
        Intent intent = new Intent(this, User_InformationActivity.class);
        startActivity(intent);
    }

    public void Sing_in_up(View view)
    {
        Intent intent=new Intent(this, SingupActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}
