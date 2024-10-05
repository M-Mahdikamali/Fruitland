package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class User_InformationActivity extends AppCompatActivity {
    EditText L_name;
    EditText F_name;
    EditText pass;
    EditText R_pass;
    EditText email;
    ImageView Green;
    ImageView Green1;
    ImageView Green2;
    ImageView Red;
    ImageView Red1;
    ImageView Red2;

    String lastname;
    String firstname;
    String Pass;
    String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_informationactivity);
        L_name =findViewById(R.id.editText6);
        F_name =findViewById(R.id.editText5);
        pass =findViewById(R.id.editText13);
        R_pass =findViewById(R.id.editText14);
        email =findViewById(R.id.user_Email);
        Green=findViewById(R.id.green);
        Green1=findViewById(R.id.green1);
        Green2=findViewById(R.id.green2);
        Red=findViewById(R.id.red);
        Red1=findViewById(R.id.red1);
        Red2=findViewById(R.id.red2);
        Green.setVisibility(View.GONE);
        Green1.setVisibility(View.GONE);
        Green2.setVisibility(View.GONE);
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Pass = pass.getText().toString().trim();
                String searchKeyword = "@";
                String searchKeyword1 = "!";
                String searchKeyword2 = "#";
                String searchKeyword3 = "$";
                if (Pass.contains(searchKeyword) || Pass.contains(searchKeyword1)|| Pass.contains(searchKeyword2)|| Pass.contains(searchKeyword3)) {
                    Green2.setVisibility(View.VISIBLE);
                    Red2.setVisibility(View.GONE);
                }else{
                    Green2.setVisibility(View.GONE);
                    Red2.setVisibility(View.VISIBLE);
                }
                Pattern pat = Pattern.compile("[A-Z][^A-Z]*$");
                Matcher match = pat.matcher(Pass);
                if(match.find()) {
                    Green1.setVisibility(View.VISIBLE);
                    Red1.setVisibility(View.GONE);
                } else {
                    Green1.setVisibility(View.GONE);
                    Red1.setVisibility(View.VISIBLE);
                }
                if(Pass.length()>8 && Pass.length()<16){
                    Green.setVisibility(View.VISIBLE);
                    Red.setVisibility(View.GONE);
                }else {
                    Green.setVisibility(View.GONE);
                    Red.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable pass) {
            }
        });
    }
    public void Sing_in(View view) {
        lastname = L_name.getText().toString().trim();
        firstname = F_name.getText().toString().trim();
        Pass = pass.getText().toString().trim();
        String R_Pass = R_pass.getText().toString().trim();
        Email = email.getText().toString().trim();
        Pattern pattern = Pattern.compile("(?=.*[A-Z])");
        Matcher matcher = pattern.matcher(Pass);
            if (lastname.isEmpty()) {
                L_name.setError("لطفا نام خانوادگی خود را وارد کنید!");
                L_name.requestFocus();
                return;
            }
            if (firstname.isEmpty()) {
                F_name.setError("لطفا نام خود را وارد کنید!");
                F_name.requestFocus();
                return;
            }
            if (Pass.isEmpty()) {
                pass.setError("لطفا رمز خود را وارد کنید!");
                pass.requestFocus();
                return;
            }
            if (R_Pass.isEmpty()) {
                    R_pass.setError("لطفا تکرار رمز خود را وارد کنید!");
                    R_pass.requestFocus();
                    return;
            } else if (!R_Pass.contentEquals(Pass)) {
                    R_pass.setError("تکرار رمز شما غلط می باشد!");
                    R_pass.requestFocus();
                    return;
            }
            if(!Email.isEmpty()) {
                String searchKeyword = "@";
                String searchKeyword1 = ".com";
                for (int i = 0; i < Email.length(); i++) {
                    if (Email.contains(searchKeyword) && Email.contains(searchKeyword1)) { } else {
                        email.setError("لطفا ایمیل خود را صحیح وارد کنید!");
                        email.requestFocus();
                        return;

                    }
                }
            }
        Intent intent = new Intent(User_InformationActivity.this, SinginActivity.class);
        intent.putExtra("lastname",lastname);
        intent.putExtra("pass",Pass);
        intent.putExtra("email",Email);
        intent.putExtra("firstname",firstname);
        startActivity(intent);
    }

    public void SU_VerificationActivity(View view){
        Intent intent = new Intent(this, SingupActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}