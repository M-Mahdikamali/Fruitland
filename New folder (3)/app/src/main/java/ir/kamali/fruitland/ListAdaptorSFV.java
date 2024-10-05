package ir.kamali.fruitland;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdaptorSFV extends RecyclerView.Adapter<ListAdaptorSFV.ViewHolder>{


    private ArrayList<String> mNames  ,mA , mB ,mC;
    private Context mContext;
    private List<ListItem> mProductList ;


    public ListAdaptorSFV
            (Context context,  ArrayList<String> mNames, List<ListItem> listItems , ArrayList<String> mA , ArrayList<String> mB,ArrayList<String> mC) {

        this.mNames = mNames;
        this.mContext = context;
        this.mProductList = listItems;
        this.mA = mA;
        this.mB = mB;
        this.mC = mC;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pishnahadvizhe,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListItem listItem=mProductList.get(i);
        viewHolder.image.setImageDrawable(mContext.getResources().getDrawable(listItem.getPishimage(),null));
        viewHolder.name.setText(mNames.get(i));
        final int numI = i;
        final int intCurrentListItem = listItem.getPishimage();
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Select_the_value_discount.class);
                intent.putExtra("namemive",mNames.get(numI));
                intent.putExtra("image",intCurrentListItem);
                intent.putExtra("motavaset", mA.get(numI));
                intent.putExtra("khob",mB.get(numI));
                intent.putExtra("awli",mC.get(numI));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.pishneadvizhe_image);
            name=itemView.findViewById(R.id.pishneadvizhe_text);
            cardView=itemView.findViewById(R.id.pishnehadvizhe);
        }
    }
}