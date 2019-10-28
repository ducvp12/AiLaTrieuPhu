package vn.ailatrieuphu.ailatrieuphu.myaap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageView bg;
    private ImageView btnDangnhap;
    private ImageView btnDangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_active);
        initView();
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DangNhapActivity.class);
                startActivity(intent);
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HomeActiveActivity.class);
                startActivity(intent);
            }
        });
    }



    private void initView() {
        bg = (ImageView) findViewById(R.id.bg);
        btnDangnhap = (ImageView) findViewById(R.id.btn_choingay);
        btnDangky = (ImageView) findViewById(R.id.btn_dangky);
    }
}
