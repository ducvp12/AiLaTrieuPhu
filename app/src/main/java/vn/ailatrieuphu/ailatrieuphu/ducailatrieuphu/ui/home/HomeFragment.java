package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageView bg;
    private ImageView imgLauncher;
    private Guideline guideline2;
    private ImageView imgchoidon;
    private ImageView imgthachdau;
    private ConstraintLayout constraintLayout;
    private ImageView imguser;
    private TextView tvNameUser;
    private ImageView imgtuitien;
    private TextView tvMoney;

    public static Fragment newInstance(String nameemail, String img) {
        Fragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("name",nameemail);
        args.putString("img",img);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        bg = (ImageView) root.findViewById(R.id.bg);
        imgLauncher = (ImageView) root.findViewById(R.id.img_launcher);
        guideline2 = (Guideline) root.findViewById(R.id.guideline2);
        imgchoidon = (ImageView) root.findViewById(R.id.imgchoidon);
        imgthachdau = (ImageView) root.findViewById(R.id.imgthachdau);
        constraintLayout = (ConstraintLayout) root.findViewById(R.id.constraintLayout);
        imguser = (ImageView) root.findViewById(R.id.imguser);
        tvNameUser = (TextView) root.findViewById(R.id.tvNameUser);
        imgtuitien = (ImageView) root.findViewById(R.id.imgtuitien);
        tvMoney = (TextView) root.findViewById(R.id.tvMoney);
        if (getArguments()!=null){
            String nameemail = getArguments().getString("name");
            String img=getArguments().getString("img");
            Log.e("GGG", "onCreateView: "+nameemail );
            tvNameUser.setText(nameemail);
            Picasso.with(getContext()).load(img).into(imguser);
        }



//        String name2 = this.getArguments().getString("na").toString();

//        String name=getArguments().getString("na").toString();
//
//        String img=this.getArguments().getString("img").toString();
//        tvNameUser.setText("NAME : "+name);
               // Picasso.with(getContext()).load(img).into(imguser);


//        Log.e("getAr",this.getArguments().getString("na").toString());



        return root;
    }


}