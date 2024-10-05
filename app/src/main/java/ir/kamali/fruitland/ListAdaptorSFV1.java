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

public class ListAdaptorSFV1 extends RecyclerView.Adapter<ListAdaptorSFV1.ViewHolder>{


    private ArrayList<String> mNames1  ,mA1 , mB1 ,mC1;
    //    private ArrayList<String> mText_B=new ArrayList<>();
//    private ArrayList<String> mText_A=new ArrayList<>();
    private Context mContext;
    private List<ListItem> mProductList ;


    public ListAdaptorSFV1
            (Context context,  ArrayList<String> mNames1, List<ListItem> listItems , ArrayList<String> mA1 , ArrayList<String> mB1,ArrayList<String> mC1) {

        this.mNames1 = mNames1;
//        this.mText_B = mText_B;
//        this.mText_A = mText_A;
        this.mContext = context;
        this.mProductList = listItems;
        this.mA1 = mA1;
        this.mB1 = mB1;
        this.mC1 = mC1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pishnahadvizhe1,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListItem listItem=mProductList.get(i);
        viewHolder.image1.setImageDrawable(mContext.getResources().getDrawable(listItem.getPishimage(),null));
        viewHolder.name1.setText(mNames1.get(i));
//        viewHolder.after_p.setText(mText_A.get(i));
//        viewHolder.before_p.setText(mText_B.get(i));
        final int numI = i;
        final int intCurrentListItem = listItem.getPishimage();
        viewHolder.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Select_the_value_discount.class);
                intent.putExtra("namemive",mNames1.get(numI));
                intent.putExtra("image",intCurrentListItem);
                intent.putExtra("motavaset", mA1.get(numI));
                intent.putExtra("khob",mB1.get(numI));
                intent.putExtra("awli",mC1.get(numI));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image1;
        TextView name1;
        TextView before_p1;
        TextView after_p1;
        CardView cardView1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1=itemView.findViewById(R.id.pishneadvizhe_image1);
            name1=itemView.findViewById(R.id.pishneadvizhe_text1);
            before_p1=itemView.findViewById(R.id.pishneadvizhe_edittext11);
            after_p1=itemView.findViewById(R.id.pishneadvizhe_edittext12);
            cardView1=itemView.findViewById(R.id.pishnehadvizhe);
        }
    }
}