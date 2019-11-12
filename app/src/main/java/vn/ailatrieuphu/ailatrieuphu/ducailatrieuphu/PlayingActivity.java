package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.makeramen.roundedimageview.RoundedImageView;

public class PlayingActivity extends AppCompatActivity {

    private LinearLayout lnPlayingactivity;
    private RoundedImageView roundedImageView;
    private TextView tvNamePlaying;
    private TextView textView4;
    private TextView textView5;
    private ImageView imageView;
    private LinearLayout linearLayout;
    private ImageView imgDungcuocchoi;
    private ImageView imgDoicauhoi;
    private ImageView img5050;
    private View view;
    private View view3;
    private TextView tvCauhoi;
    private TextView tvSocauhoi;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private TextView tvDapanA;
    private LinearLayout linearLayout2;
    private TextView tvDapanB;
    private TextView tvDapanC;
    private TextView tvDapanD;
    private ImageView imgHoiykienkhangia;
    private ImageView imgCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        initView();
        click();

    }

    public void click(){
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCall.setImageResource(R.drawable.app__ic_help_call_used);
            }
        });


        imgHoiykienkhangia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgHoiykienkhangia.setImageResource(R.drawable.app__ic_help_hoiykienkhangia_used);
            }
        });

        img5050.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img5050.setImageResource(R.drawable.app__ic_help_5050_used);
            }
        });

        imgDoicauhoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgDoicauhoi.setImageResource(R.drawable.app__ic_help_doicauhoi_used);
            }
        });
    }

    private void initView() {
        lnPlayingactivity = (LinearLayout) findViewById(R.id.ln_playingactivity);
        roundedImageView = (RoundedImageView) findViewById(R.id.roundedImageView);
        tvNamePlaying = (TextView) findViewById(R.id.tv_name_playing);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        imgHoiykienkhangia = (ImageView) findViewById(R.id.img_hoiykienkhangia);
        imgCall = (ImageView) findViewById(R.id.img_call);
        imgDungcuocchoi = (ImageView) findViewById(R.id.img_dungcuocchoi);
        imgDoicauhoi = (ImageView) findViewById(R.id.img_doicauhoi);
        img5050 = (ImageView) findViewById(R.id.img_5050);
        view = (View) findViewById(R.id.view);
        view3 = (View) findViewById(R.id.view3);
        tvCauhoi = (TextView) findViewById(R.id.tv_cauhoi);
        tvSocauhoi = (TextView) findViewById(R.id.tv_socauhoi);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        tvDapanA = (TextView) findViewById(R.id.tv_dapanA);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        tvDapanB = (TextView) findViewById(R.id.tv_dapanB);
        tvDapanC = (TextView) findViewById(R.id.tv_dapanC);
        tvDapanD = (TextView) findViewById(R.id.tv_dapanD);

    }
}
