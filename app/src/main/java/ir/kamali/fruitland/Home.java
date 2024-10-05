package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.agrawalsuneet.dotsloader.loaders.TashieLoader;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    private View viewPager;
    private View dot1;
    private int custom_position = -1;
    private Handler sliderHandler = new Handler();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    public List<ListItem> listItems;
    public List<ListItem> listItems1;
    ArrayList<Integer> arrayList;
    LinearLayout layout_dot;
    TextView[] dot;

    private ArrayList<String> mNames=new ArrayList<>();
    private ArrayList<String> mText_C=new ArrayList<>();
    private ArrayList<String> mText_B=new ArrayList<>();
    private ArrayList<String> mText_A=new ArrayList<>();
    private ArrayList<String> mNames1=new ArrayList<>();
    private ArrayList<String> mText_C1=new ArrayList<>();
    private ArrayList<String> mText_B1=new ArrayList<>();
    private ArrayList<String> mText_A1=new ArrayList<>();
    ViewFlipper v_flipper;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home, container, false);
        CardView mive= view.findViewById(R.id.cardView4);
        CardView tarbar= view.findViewById(R.id.cardView1);
        mive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Mive.class);
                startActivity(intent);
            }
        });
        tarbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Tarbar.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getImage(view);
        getImage1(view);
        int[] images ={ R.drawable.image1,R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
        v_flipper=view.findViewById(R.id.viewPagerImageSlider);
        for (int image:images){
            fillpperimage(image);
        }

        v_flipper.setAutoStart(true);
        TashieLoader container1=view.findViewById(R.id.container);
        TashieLoader tashie = new TashieLoader(
                getActivity(), 6,
                10, 5,
                ContextCompat.getColor(getActivity(), R.color.active_dots));

        tashie.setAnimDuration(350);
        tashie.setAnimDelay(4000);
        tashie.setInterpolator(new LinearInterpolator());
        container1.addView(tashie);
    }

    public void fillpperimage(int image){
        ImageView imageView=new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
    }
    private void getImage(View view){
        listItems = new ArrayList<>();
        listItems.add(new ListItem(R.drawable.bananas));
        mNames.add("موز");
        mText_C.add("40000");
        mText_B.add("30000");
        mText_A.add("25000");
        listItems.add(new ListItem(R.drawable.grapes));
        mNames.add("انگور ");
        mText_C.add("40000");
        mText_B.add("21000");
        mText_A.add("18000");
        listItems.add(new ListItem(R.drawable.peach));
        mNames.add("هلو");
        mText_C.add("40000");
        mText_B.add("30000");
        mText_A.add("25000");
        listItems.add(new ListItem(R.drawable.strawberry));
        mNames.add("توت فرنگی");
        mText_C.add("40000");
        mText_B.add("30000");
        mText_A.add("25000");
        initRecyclerView(view);
    }

    private void getImage1(View view){
        listItems1 = new ArrayList<>();
        listItems1.add(new ListItem(R.drawable.tomato));
        mNames1.add("گوجه فرنگی");
        mText_C1.add("40000");
        mText_B1.add("30000");
        mText_A1.add("25000");
        listItems1.add(new ListItem(R.drawable.potato));
        mNames1.add("سیب زمینی");
        mText_C1.add("40000");
        mText_B1.add("30000");
        mText_A1.add("25000");
        initRecyclerView1(view);
    }
    private void initRecyclerView(View view){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setReverseLayout(true);
        RecyclerView recyclerView = view.findViewById(R.id.list_item_pishnahadvizhe);
        recyclerView.setLayoutManager(layoutManager);
        ListAdaptorSFV adapter = new ListAdaptorSFV(getActivity(), mNames , listItems, mText_A,  mText_B , mText_C);
        recyclerView.setAdapter(adapter);

    }
    private void initRecyclerView1(View view){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setReverseLayout(true);
        RecyclerView recyclerView = view.findViewById(R.id.list_item_pishnahadvizhe1);
        recyclerView.setLayoutManager(layoutManager);
        ListAdaptorSFV adapter = new ListAdaptorSFV(getActivity(), mNames1 , listItems1 , mText_A1,  mText_B1 , mText_C1);
        recyclerView.setAdapter(adapter);
    }
}
