package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import com.santalu.maskedittext.MaskEditText;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class ForgetPassActivity extends AppCompatActivity
{
    EditText t1;
    RadioButton radioButton;
    RadioButton radioButton1;
    MaskEditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassactivity);
        t1= findViewById(R.id.editText11);
        t1.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        radioButton =findViewById(R.id.CH_phone);
        radioButton1 =findViewById(R.id.CH_Email);
        editText2=findViewById(R.id.Enter_fp_Email);
        t1.setVisibility(View.GONE);
        editText2.setVisibility(View.GONE);
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.CH_phone:
                if (checked)
                    t1.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.GONE);
                    break;
            case R.id.CH_Email:
                if (checked)
                    t1.setVisibility(View.GONE);
                    editText2.setVisibility(View.VISIBLE);
                    break;
        }
    }
    private static class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
    public void FP_VerificationActivity(View view) {
        if (radioButton.isChecked()) {
            String number = t1.getText().toString().trim();
            int number3 = t1.getText().length();
            if (number.isEmpty()) {
                t1.setError("لطفا شماره خود را وارد کنید!");
                t1.requestFocus();
            }
            else if (number3 != 16) {
                t1.setError("شماره تلفن نامعتبر");
                t1.requestFocus();
            }
            else {
            Intent intent = new Intent(this, FP_VerificationActivity.class);
            intent.putExtra("number", number);
            startActivity(intent);
            }
        }
        if (radioButton1.isChecked()) {
            String Email = editText2.getText().toString().trim();
            if (Email.isEmpty()) {
                editText2.setError("لطفا ایمیل خود را وارد کنید!");
                editText2.requestFocus();
                return;
            }
            else if (radioButton1.isChecked()){
                String searchKeyword = "@";
                String searchKeyword1 = ".com";
                for ( int i = 0; i < Email.length(); i++ ){
                    if (Email.contains(searchKeyword) && Email.contains(searchKeyword1)){
                        Intent intent = new Intent(this, FP_VerificationActivity.class);
                        intent.putExtra("Email", Email);
                        startActivity(intent);
                        return;
                    }
                    else
                        editText2.setError("لطفا ایمیل خود را صحیح وارد کنید!");
                        editText2.requestFocus();
                        return;
                }
            }
        }
    }
    public void Singin (View view) {
        Intent intent=new Intent(this, SinginActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}