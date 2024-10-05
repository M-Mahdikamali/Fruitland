package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Basket extends Fragment {
    public static ArrayList<String> T_Quality = new ArrayList<>();
    public static ArrayList<String> T_Weight= new ArrayList<>();
    public static ArrayList<String> T_Price= new ArrayList<>();
    public static ArrayList<Integer> Image= new ArrayList<>();
    public static ArrayList<String> Names= new ArrayList<>();
    public static TextView textView;



    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.basket, container, false);
        return view;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        textView=view.findViewById(R.id.gotopardakht);
        textView.setVisibility(View.GONE);
        if(Names.size()>0){
            textView.setVisibility(View.VISIBLE);
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total  = 0 ;
                for(String i : T_Price){
                    String input = i;
                    int r = input.indexOf(' ');
                    String rest = input.substring(0 ,r);
                    total += Integer.parseInt(rest);
                }

                Intent intent=new Intent(getActivity(), Nextpagebasket.class);
                intent.putExtra( "total" , String.valueOf(total ));
                startActivity(intent);
            }
        });

        initRecyclerView(view);
    }
    private void initRecyclerView(View view){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.Listitem_basket);
        recyclerView.setLayoutManager(layoutManager);
        CartListView adapter = new CartListView(getActivity(), Names , Image, T_Weight,  T_Quality , T_Price);
        recyclerView.setAdapter(adapter);
    }
}