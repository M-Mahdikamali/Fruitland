package ir.kamali.fruitland;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;
    private boolean checkLocation =false;
    private boolean checkTime =false;
    private boolean checkravesh =false;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    private RadioGroup firstColumnTime;
    private RadioGroup secondColumnTime;

    public void fun1() {
        firstColumnTime.setOnCheckedChangeListener(null);
        firstColumnTime.clearCheck();
        firstColumnTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fun2();
            }
        });
    }
    public void fun2() {
        secondColumnTime.setOnCheckedChangeListener(null);
        secondColumnTime.clearCheck();
        secondColumnTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fun1();
            }
        });
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slidescreen,container,false);


        CardView cardView=view.findViewById(R.id.view_cardview);
        CardView cardView1=view.findViewById(R.id.view_cardview1);
        CardView cardView2=view.findViewById(R.id.view_cardview2);
        CardView cardView3=view.findViewById(R.id.view_cardview3);

        CardView bankmellat=view.findViewById(R.id.bankmellat);
        CardView banksaman=view.findViewById(R.id.banksaman);
        CardView bankmeli=view.findViewById(R.id.bankmeli);

        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);
        ImageView ind4=view.findViewById(R.id.ind4);

        TextView title =view.findViewById(R.id.title_slide);
        final TextView textback=view.findViewById(R.id.text_back);
        TextView textnext=view.findViewById(R.id.text_next);

        ImageView next=view.findViewById(R.id.next_slide);
        ImageView back=view.findViewById(R.id.back_slide);


        RadioButton locationme=view.findViewById(R.id.locationme);
        RadioButton locationother=view.findViewById(R.id.otherlocation);
        RadioButton vizhe=view.findViewById(R.id.vizhe);
        RadioButton adi=view.findViewById(R.id.adi);

        final EditText address= view.findViewById(R.id.address);
        address.setVisibility(View.GONE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nextpagebasket.viewPager.getCurrentItem() == 0) {
                    if (checkLocation == true)
                        Nextpagebasket.viewPager.setCurrentItem(position + 1);
                    else
                        Toast.makeText(ctx, "یکی از آدرس های مورد نظر را وارد کنید!", Toast.LENGTH_SHORT).show();
                }
               else  if (Nextpagebasket.viewPager.getCurrentItem() == 1) {
                    if (checkTime == true )
                        Nextpagebasket.viewPager.setCurrentItem(position + 1);
                    else
                    Toast.makeText(ctx, "زمان ارسال را مشخص کنید!", Toast.LENGTH_SHORT).show();
                }
                else if(Nextpagebasket.viewPager.getCurrentItem() == 2 ) {
                    if (checkravesh == true)
                        Nextpagebasket.viewPager.setCurrentItem(position + 1);
                    else
                        Toast.makeText(ctx, "روش ارسال را مشخص کنید!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nextpagebasket.viewPager.setCurrentItem(position-1);
            }
        });

        textback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nextpagebasket.viewPager.setCurrentItem(position-1);
            }
        });


        textnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nextpagebasket.viewPager.getCurrentItem() == 0) {
                    if (checkLocation == true)
                        Nextpagebasket.viewPager.setCurrentItem(position + 1);
                    else
                        Toast.makeText(ctx, "یکی از آدرس های مورد نظر را وارد کنید!", Toast.LENGTH_SHORT).show();
                }
                else if (Nextpagebasket.viewPager.getCurrentItem() == 1) {
                    if (checkTime == true)
                        Nextpagebasket.viewPager.setCurrentItem(position + 1);
                    else
                        Toast.makeText(ctx, "زمان ارسال را مشخص کنید!", Toast.LENGTH_SHORT).show();
                }
                else if(Nextpagebasket.viewPager.getCurrentItem() == 2 ) {
                    if (checkravesh == true)
                        Nextpagebasket.viewPager.setCurrentItem(position + 1);
                    else
                        Toast.makeText(ctx, "روش ارسال را مشخص کنید!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        switch (position){

            case 0:
                cardView.setVisibility(View.VISIBLE);
                cardView1.setVisibility(View.GONE);
                cardView2.setVisibility(View.GONE);
                cardView3.setVisibility(View.GONE);

                ind1.setImageResource(R.drawable.active_dot);
                ind3.setImageResource(R.drawable.inactive_dot);
                ind2.setImageResource(R.drawable.inactive_dot);
                ind4.setImageResource(R.drawable.inactive_dot);

                title.setText("آدرس");

                back.setVisibility(View.GONE);
                textback.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);

                locationme.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        address.setVisibility(View.GONE);
                        checkLocation =true;
                    }
                });
                locationother.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        address.setVisibility(View.VISIBLE);
                        checkLocation =true;
                    }
                });
                break;

            case 1:
                cardView.setVisibility(View.GONE);
                cardView1.setVisibility(View.VISIBLE);
                cardView2.setVisibility(View.GONE);
                cardView3.setVisibility(View.GONE);

                ind1.setImageResource(R.drawable.inactive_dot);
                ind3.setImageResource(R.drawable.active_dot);
                ind2.setImageResource(R.drawable.inactive_dot);
                ind4.setImageResource(R.drawable.inactive_dot);

                title.setText("زمان ارسال");

                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);

                firstColumnTime = view.findViewById(R.id.radioGrpuptime);
                secondColumnTime = view.findViewById(R.id.radioGrpuptime1);
                RadioGroup columnDay = view.findViewById(R.id.radioGrpuptimeday1);

                firstColumnTime.setVisibility(View.GONE);
                secondColumnTime.setVisibility(View.GONE);
                firstColumnTime.clearCheck();
                secondColumnTime.clearCheck();

                columnDay.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        firstColumnTime.setVisibility(View.VISIBLE);
                        secondColumnTime.setVisibility(View.VISIBLE);
                    }
                });

                firstColumnTime.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId != -1) {
                            fun2();
                            checkTime =true;
                        }
                    }
                });
                secondColumnTime.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId != -1) {
                            fun1();
                            checkTime =true;
                        }
                    }
                });
                break;
            case 2:
                cardView.setVisibility(View.GONE);
                cardView1.setVisibility(View.GONE);
                cardView2.setVisibility(View.VISIBLE);
                cardView3.setVisibility(View.GONE);

                ind1.setImageResource(R.drawable.inactive_dot);
                ind3.setImageResource(R.drawable.inactive_dot);
                ind2.setImageResource(R.drawable.active_dot);
                ind4.setImageResource(R.drawable.inactive_dot);

                title.setText("روش ارسال");

                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                final String gheymateKham = Nextpagebasket.total;
                vizhe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int total = 7000;
                //        TextView textView = Nextpagebasket.currentView.findViewById(R.id.ghimate_kol);
                        String input = gheymateKham;
                        total+= Integer.parseInt(input);
                        Nextpagebasket.ghimatekole.setText(String.valueOf(total) + " تومان ");
                        checkravesh =true;
                    }
                });
                adi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Nextpagebasket.ghimatekole.setText(String.valueOf(gheymateKham) + " تومان ");
                        checkravesh =true;
                    }
                });

                break;
            case 3:
                cardView.setVisibility(View.GONE);
                cardView1.setVisibility(View.GONE);
                cardView2.setVisibility(View.GONE);
                cardView3.setVisibility(View.VISIBLE);

                ind1.setImageResource(R.drawable.inactive_dot);
                ind3.setImageResource(R.drawable.inactive_dot);
                ind2.setImageResource(R.drawable.inactive_dot);
                ind4.setImageResource(R.drawable.active_dot);

                title.setText("درگاه بانک");

                back.setVisibility(View.VISIBLE);
                textnext.setVisibility(View.GONE);
                next.setVisibility(View.GONE);

                bankmeli.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uriUrl = Uri.parse("https://bmi.ir");
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        view.getContext().startActivity(launchBrowser);
                    }
                });
                bankmellat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uriUrl = Uri.parse("https://bankmellat.ir");
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        view.getContext().startActivity(launchBrowser);
                    }
                });
                banksaman.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uriUrl = Uri.parse("https://ib.sb24.ir");
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        view.getContext().startActivity(launchBrowser);
                    }
                });

                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}