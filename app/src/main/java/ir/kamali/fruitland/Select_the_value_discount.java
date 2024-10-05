package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class Select_the_value_discount extends AppCompatActivity {
    private String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_the_value_discount);
        final String namemive= getIntent().getStringExtra("namemive");
        final int image= getIntent().getIntExtra("image",1);
        String motavaset= getIntent().getStringExtra("motavaset");
        String khob= getIntent().getStringExtra("khob");
        String awli= getIntent().getStringExtra("awli");
        ImageView discount =findViewById(R.id.discount);
        discount.setImageResource(R.drawable.discount_diagonal);
        ImageView Fruits_Vegetables_Image =findViewById(R.id.Fruits_Vegetables_Image);
        TextView Fruits_Vegetables_Name=findViewById(R.id.Fruits_Vegetables_Name);
        final TextView Fruits_Vegetables_Mean =findViewById(R.id.Fruits_Vegetables_Mean);
        TextView Fruits_Vegetables_Good=findViewById(R.id.Fruits_Vegetables_Good);
        TextView Fruits_Vegetables_Perfect=findViewById(R.id.Fruits_Vegetables_Perfect);
        Fruits_Vegetables_Image.setImageResource(image);
        Fruits_Vegetables_Name.setText(namemive);
        Fruits_Vegetables_Mean.setText(motavaset);
        Fruits_Vegetables_Good.setText(khob);
        Fruits_Vegetables_Perfect.setText(awli);
        final TextView textViewMean = findViewById(R.id.textview_mean);
        final TextView textViewGood = findViewById(R.id.textview_good);
        final TextView textViewPerfect = findViewById(R.id.textview_prefect);
        ImageView increasemean = findViewById(R.id.Increase_maen);
        ImageView increasegood = findViewById(R.id.Increase_good);
        ImageView increaseperfect = findViewById(R.id.Increase_prefect);
        ImageView decreasemean = findViewById(R.id.Decrease_maen);
        ImageView decreasegood = findViewById(R.id.Decrease_good);
        ImageView decreaseperfect = findViewById(R.id.Decrease_prefect);
        final TextView totalPrice  = findViewById(R.id.Totalprice);
        CardView cart=findViewById(R.id.buytobasket);
        textViewMean.setText("0");
        textViewGood.setText("0");
        textViewPerfect.setText("0");
        totalPrice.setText("0");
        final String priceMean=  Fruits_Vegetables_Mean.getText().toString();
        final String priceGood=  Fruits_Vegetables_Good.getText().toString();
        final String pricePerfect=  Fruits_Vegetables_Perfect.getText().toString();
        total =  totalPrice.getText().toString();
        increasemean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentNum = textViewMean.getText().toString();
                int intcurrent = Integer.parseInt(currentNum);
                if(intcurrent<99)
                    intcurrent++;
                else
                    return ;
                String finalNum = String.valueOf(intcurrent);
                int currentTotal = Integer.parseInt(total) + Integer.parseInt(priceMean);
                String finalTotal = String.valueOf(currentTotal);
                total=finalTotal;
                textViewMean.setText(finalNum);
                totalPrice.setText(finalTotal);

            }
        });
        increasegood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentNum = textViewGood.getText().toString();
                int intcurrent = Integer.parseInt(currentNum);
                if(intcurrent<99)
                    intcurrent++;
                else
                    return ;
                String finalNum = String.valueOf(intcurrent);
                int currentTotal = Integer.parseInt(total) + Integer.parseInt(priceGood);
                String finalTotal = String.valueOf(currentTotal);
                total=finalTotal;
                textViewGood.setText(finalNum);
                totalPrice.setText(finalTotal);
            }
        });
        increaseperfect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentNum = textViewPerfect.getText().toString();
                int intcurrent = Integer.parseInt(currentNum);
                if(intcurrent<99)
                    intcurrent++;
                else
                    return ;
                String finalNum = String.valueOf(intcurrent);
                int currentTotal = Integer.parseInt(total) + Integer.parseInt(pricePerfect);
                String finalTotal = String.valueOf(currentTotal);
                total=finalTotal;
                textViewPerfect.setText(finalNum);
                totalPrice.setText(finalTotal);
            }
        });
        decreasemean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = textViewMean.getText().toString();
                int detcurrent = Integer.parseInt(current);
                if(detcurrent>0)
                    detcurrent--;
                else
                    return ;
                String finalNum = String.valueOf(detcurrent);
                int currentTotal = Integer.parseInt(total) - Integer.parseInt(priceMean);
                String finalTotal = String.valueOf(currentTotal);
                total=finalTotal;
                textViewMean.setText(finalNum);
                totalPrice.setText(finalTotal);
            }
        });
        decreasegood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = textViewGood.getText().toString();
                int detcurrent = Integer.parseInt(current);
                if(detcurrent>0)
                    detcurrent--;
                else
                    return ;
                String finalNum = String.valueOf(detcurrent);
                int currentTotal = Integer.parseInt(total) - Integer.parseInt(priceGood);
                String finalTotal = String.valueOf(currentTotal);
                total=finalTotal;
                textViewGood.setText(finalNum);
                totalPrice.setText(finalTotal);
            }
        });
        decreaseperfect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = textViewPerfect.getText().toString();
                int detcurrent = Integer.parseInt(current);
                if(detcurrent>0)
                    detcurrent--;
                else
                    return ;
                String finalNum = String.valueOf(detcurrent);
                int currentTotal = Integer.parseInt(total) - Integer.parseInt(pricePerfect);
                String finalTotal = String.valueOf(currentTotal);
                total=finalTotal;
                textViewPerfect.setText(finalNum);
                totalPrice.setText(finalTotal);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalWeightMean =Integer.parseInt(textViewMean.getText().toString());
                int totalWeightGood =Integer.parseInt(textViewGood.getText().toString());
                int totalWeightperfect =Integer.parseInt(textViewPerfect.getText().toString());
                int totalWeight =totalWeightMean+totalWeightGood+totalWeightperfect;
                String qualities ="";
                if (totalWeightMean>0)
                    qualities+=" متوسط ";
                if (totalWeightGood>0)
                    qualities+=" خوب ";
                if (totalWeightperfect>0)
                    qualities+=" عالی ";
                if (totalWeight==0) {
                    Toast.makeText(Select_the_value_discount.this,"تعداد مورد نظر خود را انتخاب کنید.",Toast.LENGTH_LONG).show();
                    return;
                }
                Basket.Image.add(image);
                Basket.Names.add(namemive);
                Basket.T_Weight.add(String.valueOf(totalWeight)+(" کیلوگرم"));
                Basket.T_Quality.add(qualities);
                Basket.T_Price.add(totalPrice.getText().toString()+(" تومان"));

                Toast.makeText(Select_the_value_discount.this, "به سبد خرید شما اضافه شد.", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Home(View view) {
        Intent intent=new Intent(this,Bottombar.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        G.mCurrentActivity=this;
    }
}