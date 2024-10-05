package ir.kamali.fruitland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class Mive extends AppCompatActivity {

    GridView gridView;
    String[] namemive ={"توت فرنگی" ,"موز","انگور"};
    int[] image={R.drawable.strawberry,R.drawable.bananas,R.drawable.grapes};
    String[] motavaset ={"20000","30000","40000"};
    String[] khob ={"22000","32000","42000"};
    String[] awli ={"30000","40000","50000"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        setContentView(R.layout.mive);
        gridView=findViewById(R.id.mygridview);
        GridViewAdapter adaptor= new GridViewAdapter(Mive.this,namemive,image);
        gridView.setAdapter(adaptor);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(Mive.this,Select_the_value.class);
                intent.putExtra("namemive",namemive[i]);
                intent.putExtra("image",image[i]);
                intent.putExtra("motavaset",motavaset[i]);
                intent.putExtra("khob",khob[i]);
                intent.putExtra("awli",awli[i]);
                startActivity(intent);
            }
        });
    }
    public void Home(View view) {
        Intent intent=new Intent(this,Bottombar.class);
        startActivity(intent);
    }
}