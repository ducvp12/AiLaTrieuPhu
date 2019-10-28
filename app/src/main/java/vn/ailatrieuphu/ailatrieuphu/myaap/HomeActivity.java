package vn.ailatrieuphu.ailatrieuphu.myaap;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    DangNhapActivity dangNhapActivity;
    private ImageView bg;
    private ImageView btnDangnhap;
    private ImageView btnDangky;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_active);
        initView();
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDialog();
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


    public void showDialog() {
        dialog = new Dialog(HomeActivity.this);
        dialog.setTitle("Đăng nhập");
        dialog.setContentView(R.layout.dialog_login);
        ImageView imglogin=dialog.findViewById(R.id.logingg);
        imglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        dialog.show();
    }
    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Đăng nhập");
        builder.setMessage("Đăng nhập bằng google");

        builder.setIcon(R.drawable.app__ic_google);
//        builder.setPositiveButton("Ứ chịu", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(HomeActivity.this, "Không thoát được", Toast.LENGTH_SHORT).show();
//            }
//        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    private void initView() {
        bg = (ImageView) findViewById(R.id.bg);
        btnDangnhap = (ImageView) findViewById(R.id.btn_choingay);
        btnDangky = (ImageView) findViewById(R.id.btn_dangky);

    }
}
