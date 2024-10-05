package ir.kamali.fruitland;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

public class Delivery extends Fragment {
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView dot1;
    ImageView line1;
    ImageView dot2;
    ImageView line2;
    ImageView dot3;
    ImageView line3;
    ImageView dot4;

    ScrollView tarikhche;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.delivery, container, false);

        image1=view.findViewById(R.id.imagesabtesefaresh);
        image2=view.findViewById(R.id.imagedarhalebaresi);
        image3=view.findViewById(R.id.darhaleamadesazi);
        image4=view.findViewById(R.id.imagearsal);

        dot1=view.findViewById(R.id.dot1);
        dot2=view.findViewById(R.id.dot2);
        dot3=view.findViewById(R.id.dot3);
        dot4=view.findViewById(R.id.dot4);

        line1=view.findViewById(R.id.line1);
        line2=view.findViewById(R.id.line2);
        line3=view.findViewById(R.id.line3);

        tarikhche=view.findViewById(R.id.Scrolltarikhche);
        tarikhche.setVisibility(View.GONE);

        return view;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot1.setBackgroundResource(R.drawable.circle_green);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                line1.setBackgroundResource(R.drawable.line_green);
                dot2.setBackgroundResource(R.drawable.circle_green);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                line2.setBackgroundResource(R.drawable.line_green);
                dot3.setBackgroundResource(R.drawable.circle_green);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                line3.setBackgroundResource(R.drawable.line_green);
                dot4.setBackgroundResource(R.drawable.circle_green);
            }
        });
    }
}