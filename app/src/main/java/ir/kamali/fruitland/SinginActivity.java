package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SinginActivity extends AppCompatActivity {
    EditText t1;
    EditText t2;
    private String lastname;
    private String firstname;
    private String Pass;
    private String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singinactivity);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);

        lastname=getIntent().getStringExtra("lastname");
        firstname=getIntent().getStringExtra("firstname");
        Pass=getIntent().getStringExtra("pass");
        Email=getIntent().getStringExtra("email");

        t1 = findViewById(R.id.editText11);
        t2 =findViewById(R.id.editText2);
        t1.setTransformationMethod(new NumericKeyBoardTransformationMethod());
    }
    private class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
    public void ForgetPass(View view) {
        Intent intent = new Intent(this, ForgetPassActivity.class);
        startActivity(intent);
    }

    public void Sing_in_up(View view) {
        Intent intent = new Intent(this, SingActivity.class);
        startActivity(intent);
    }
    public void Map(View view){
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
        String number4 = t2.getText().toString().trim();
        if (number4.isEmpty()) {
            t2.setError("لطفا رمز خود را وارد کنید!");
            t2.requestFocus();
            return;
        }
        else {
            Intent intent = new Intent(this, MapActivity.class);
            intent.putExtra("lastname",lastname);
            intent.putExtra("pass",Pass);
            intent.putExtra("email",Email);
            intent.putExtra("firstname",firstname);
            startActivity(intent);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}