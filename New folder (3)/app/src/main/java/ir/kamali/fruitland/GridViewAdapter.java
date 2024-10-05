package ir.kamali.fruitland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter  {
    private Context context;
    private LayoutInflater inflater;
    private String[] namemive;
    private int[] image;

    public GridViewAdapter(Context c,String[] namemive,int[] image){
        this.context=c;
        this.namemive=namemive;
        this.image=image;
    }

    @Override
    public int getCount() {
        return namemive.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view==null){
            view=inflater.inflate(R.layout.grid_item,null);
        }
        ImageView imageView=view.findViewById(R.id.exmive_image);
        TextView txtTitle = view.findViewById(R.id.exmive_text);

        imageView.setImageResource(image[i]);
        txtTitle.setText(namemive[i]);
        return view;
    }
}
