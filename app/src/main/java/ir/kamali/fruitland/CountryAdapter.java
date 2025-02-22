package ir.kamali.fruitland;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter {
    public CountryAdapter(Context context, ArrayList<CountryItem> countryList){
        super(context,0,countryList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position , View convertView , ViewGroup parent){
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.spinner_row_setting,parent,false);
        }
        TextView textView=convertView.findViewById(R.id.text_view_name);

        CountryItem currentItem = (CountryItem) getItem(position);
        if(currentItem!=null) {
            textView.setText(currentItem.getmCountryName());
        }
        return convertView;
    }
}
