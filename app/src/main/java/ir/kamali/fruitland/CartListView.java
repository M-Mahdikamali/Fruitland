package ir.kamali.fruitland;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartListView extends RecyclerView.Adapter<CartListView.ViewHolder>{


    private ArrayList<String> mNames,mWeight,mQuality,mPrice;
    private ArrayList<Integer> mImage;
    private Context mContext;


    public CartListView
            (Context context, ArrayList<String> mNames, ArrayList<Integer> mImage , ArrayList<String> mWeight, ArrayList<String> mQuality, ArrayList<String> mPrice) {

        this.mNames = mNames;
        this.mContext = context;
        this.mImage = mImage;
        this.mWeight = mWeight;
        this.mPrice = mPrice;
        this.mQuality = mQuality;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_cart,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mNames.get(i));
        viewHolder.Price.setText(mPrice.get(i));
        viewHolder.Weight.setText(mWeight.get(i));
        viewHolder.Quality.setText(mQuality.get(i));
        final int Num=i;
        viewHolder.image.setImageDrawable(mContext.getResources().getDrawable(mImage.get(i),null));

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImage.remove(Num);
                mNames.remove(Num);
                mPrice.remove(Num);
                mQuality.remove(Num);
                mWeight.remove(Num);
                if(mNames.size()==0){

                    Basket.textView.setVisibility(View.GONE);
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView Quality;
        TextView Weight;
        TextView Price;
        Button delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.ax_mive_tarebar);
            name=itemView.findViewById(R.id.Name_mive_tarebar);
            Quality=itemView.findViewById(R.id.kifiatha);
            Weight=itemView.findViewById(R.id.vazne_kol);
            Price=itemView.findViewById(R.id.ghimateha);
            delete=itemView.findViewById(R.id.delete);

        }
    }
}