package ir.kamali.fruitland;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SingupActivity extends AppCompatActivity
{
    EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singupactivity);
        t1   = findViewById(R.id.editText11);
        t1.setTransformationMethod(new NumericKeyBoardTransformationMethod());
    }
    private class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
    public void SU_VerificationActivity(View view) {
        String number2 = t1.getText().toString().trim();
        if (number2.isEmpty()) {
            t1.setError("لطفا شماره خود را وارد کنید!");
            t1.requestFocus();
            return;
        }
        int number3 =t1.getText().length();
        if (number3!=16) {
            t1.setError("شماره تلفن نامعتبر");
            t1.requestFocus();
            return;
        }
        else {
            Intent intent = new Intent(this, SU_VerificationActivity.class);
            intent.putExtra("number2", number2);
            startActivity(intent);
        }
    }
    public void Sing_in_up(View view) {
        Intent intent=new Intent(this, SingActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}
