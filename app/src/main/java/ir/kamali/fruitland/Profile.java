package ir.kamali.fruitland;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class Profile extends Fragment {
    private static final int GALLERY_REQUSET_CODE=123;

    CircleImageView photo;
    LinearLayout changeinfo;
    LinearLayout changepass;
    LinearLayout moshakhasat;
    CardView changep;
    CardView changeinfor;
    CardView Exit;
    CardView taghirp;
    CardView laghvp;
    CardView taghiri;
    CardView laghvi;
    EditText Npass;
    EditText Npassre;
    EditText newlastname;
    EditText newfirstname;
    EditText newEmail;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);
        return view;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final TextView Fruits_Vegetables_firstname =view.findViewById(R.id.firstname);
        final TextView Fruits_Vegetables_lastnaem=view.findViewById(R.id.lastname);
        final TextView Fruits_Vegetables_pass =view.findViewById(R.id.password);
        final TextView Fruits_Vegetables_email=view.findViewById(R.id.email);
        Fruits_Vegetables_firstname.setText(Bottombar.firstname);
        Fruits_Vegetables_lastnaem.setText(Bottombar.lastname);
        Fruits_Vegetables_pass.setText(Bottombar.Pass);
        Fruits_Vegetables_email.setText(Bottombar.Email);
        changeinfo=view.findViewById(R.id.changeInformation);
        changepass=view.findViewById(R.id.changepass);
        moshakhasat=view.findViewById(R.id.moshakhasateprofile);
        changeinfor=view.findViewById(R.id.changeinfo);
        changep=view.findViewById(R.id.changepassword);
        Exit=view.findViewById(R.id.Exit);
        photo=view.findViewById(R.id.photo);
        taghirp=view.findViewById(R.id.emaletaghirat);
        laghvp=view.findViewById(R.id.laghve);
        taghiri=view.findViewById(R.id.emaletaghirat1);
        laghvi=view.findViewById(R.id.laghve1);
        Npass=view.findViewById(R.id.newpassword);
        Npassre=view.findViewById(R.id.newpasswordre);
        newlastname=view.findViewById(R.id.newlastname);
        newfirstname=view.findViewById(R.id.newfirstname);
        newEmail=view.findViewById(R.id.newEmail);
        taghirp.setVisibility(View.GONE);
        laghvp.setVisibility(View.GONE);
        taghiri.setVisibility(View.GONE);
        laghvi.setVisibility(View.GONE);
        changep.setVisibility(View.VISIBLE);
        Exit.setVisibility(View.VISIBLE);
        changeinfor.setVisibility(View.VISIBLE);
        moshakhasat.setVisibility(View.VISIBLE);
        changeinfo.setVisibility(View.GONE);
        changepass.setVisibility(View.GONE);

        TextView tvAdress = view.findViewById(R.id.tv_address);
        tvAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"pick an image"),GALLERY_REQUSET_CODE);
            }
        });
        changep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moshakhasat.setVisibility(View.GONE);
                changeinfo.setVisibility(View.GONE);
                changepass.setVisibility(View.VISIBLE);
                changep.setVisibility(View.GONE);
                changeinfor.setVisibility(View.GONE);
                Exit.setVisibility(View.GONE);
                taghirp.setVisibility(View.VISIBLE);
                laghvp.setVisibility(View.VISIBLE);
                taghiri.setVisibility(View.GONE);
                laghvi.setVisibility(View.GONE);
            }
        });
        changeinfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeinfo.setVisibility(View.VISIBLE);
                changepass.setVisibility(View.GONE);
                moshakhasat.setVisibility(View.GONE);
                changep.setVisibility(View.GONE);
                changeinfor.setVisibility(View.GONE);
                Exit.setVisibility(View.GONE);
                taghiri.setVisibility(View.VISIBLE);
                laghvi.setVisibility(View.VISIBLE);
                taghirp.setVisibility(View.GONE);
                laghvp.setVisibility(View.GONE);
            }
        });
        laghvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taghirp.setVisibility(View.GONE);
                laghvp.setVisibility(View.GONE);
                taghiri.setVisibility(View.GONE);
                laghvi.setVisibility(View.GONE);
                changep.setVisibility(View.VISIBLE);
                Exit.setVisibility(View.VISIBLE);
                changeinfor.setVisibility(View.VISIBLE);
                moshakhasat.setVisibility(View.VISIBLE);
                changeinfo.setVisibility(View.GONE);
                changepass.setVisibility(View.GONE);
            }
        });
        laghvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taghirp.setVisibility(View.GONE);
                laghvp.setVisibility(View.GONE);
                taghiri.setVisibility(View.GONE);
                laghvi.setVisibility(View.GONE);
                changep.setVisibility(View.VISIBLE);
                Exit.setVisibility(View.VISIBLE);
                changeinfor.setVisibility(View.VISIBLE);
                moshakhasat.setVisibility(View.VISIBLE);
                changeinfo.setVisibility(View.GONE);
                changepass.setVisibility(View.GONE);
            }
        });
        taghirp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moshakhasat.setVisibility(View.GONE);
                changeinfo.setVisibility(View.GONE);
                changepass.setVisibility(View.VISIBLE);
                changep.setVisibility(View.GONE);
                changeinfor.setVisibility(View.GONE);
                Exit.setVisibility(View.GONE);
                taghirp.setVisibility(View.VISIBLE);
                laghvp.setVisibility(View.VISIBLE);
                taghiri.setVisibility(View.GONE);
                laghvi.setVisibility(View.GONE);
                String Npassword=Npass.getText().toString();
                String Npasswordre=Npassre.getText().toString();

                if (Npassword.isEmpty()) {
                    Npass.setError("رمز مورد نظر خود را وارد کنید!");
                    Npass.requestFocus();
                    return;
                } else if (Npasswordre.isEmpty()) {
                    Npassre.setError("تکرار رمز مورد نظر خود را وارد کنید!");
                    Npassre.requestFocus();
                    return;
                }else if (!Npasswordre.contentEquals(Npassword)) {
                    Npassre.setError("تکرار رمز شما غلط می باشد!");
                    Npassre.requestFocus();
                    return;
                }else {
                    Fruits_Vegetables_pass.setText(Npassword);
                    taghirp.setVisibility(View.GONE);
                    laghvp.setVisibility(View.GONE);
                    taghiri.setVisibility(View.GONE);
                    laghvi.setVisibility(View.GONE);
                    changep.setVisibility(View.VISIBLE);
                    Exit.setVisibility(View.VISIBLE);
                    changeinfor.setVisibility(View.VISIBLE);
                    moshakhasat.setVisibility(View.VISIBLE);
                    changeinfo.setVisibility(View.GONE);
                    changepass.setVisibility(View.GONE);
                    Npass.getText().clear();
                    Npassre.getText().clear();
                }
            }
        });
        taghiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moshakhasat.setVisibility(View.GONE);
                changeinfo.setVisibility(View.VISIBLE);
                changepass.setVisibility(View.GONE);
                changep.setVisibility(View.GONE);
                changeinfor.setVisibility(View.GONE);
                Exit.setVisibility(View.GONE);
                taghirp.setVisibility(View.GONE);
                laghvp.setVisibility(View.GONE);
                taghiri.setVisibility(View.VISIBLE);
                laghvi.setVisibility(View.VISIBLE);

                String NewlastName=newlastname.getText().toString();
                String NewfirstName=newfirstname.getText().toString();
                String NewEmail=newEmail.getText().toString();

                if (NewlastName.isEmpty()) {
                    newlastname.setError("رمز مورد نظر خود را وارد کنید!");
                    newlastname.requestFocus();
                    return;
                } else if (NewfirstName.isEmpty()) {
                    newfirstname.setError("تکرار رمز مورد نظر خود را وارد کنید!");
                    newfirstname.requestFocus();
                    return;
                }else if (NewEmail.isEmpty()) {
                    newEmail.setError("تکرار رمز شما غلط می باشد!");
                    newEmail.requestFocus();
                    return;
                }else{
                    Fruits_Vegetables_firstname.setText(NewfirstName);
                    Fruits_Vegetables_lastnaem.setText(NewlastName);
                    Fruits_Vegetables_email.setText(NewEmail);
                    taghirp.setVisibility(View.GONE);
                    laghvp.setVisibility(View.GONE);
                    taghiri.setVisibility(View.GONE);
                    laghvi.setVisibility(View.GONE);
                    changep.setVisibility(View.VISIBLE);
                    Exit.setVisibility(View.VISIBLE);
                    changeinfor.setVisibility(View.VISIBLE);
                    moshakhasat.setVisibility(View.VISIBLE);
                    changeinfo.setVisibility(View.GONE);
                    changepass.setVisibility(View.GONE);
                    newfirstname.getText().clear();
                    newlastname.getText().clear();
                    newEmail.getText().clear();
                }
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==GALLERY_REQUSET_CODE && resultCode==RESULT_OK && data!=null){
            Uri imageData =data.getData();
            photo.setImageURI(imageData);
        }
    }
}