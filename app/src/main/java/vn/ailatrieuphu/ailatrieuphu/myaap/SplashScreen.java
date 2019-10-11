package vn.ailatrieuphu.ailatrieuphu.myaap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {

    private static int TIME_OUT = 2;
    private Handler handler = null;
    private Runnable runnable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        // không nên viết ntn, viết ntn sẽ bị bug như sau
        // nó tự động bật lên cho dù mình đã ẩn app
        // nếu khởi tạo trong onCreate thì phải hủy trong onDestroy
        // nếu khởi tạo trong onStart thì phải hủy trong onStop
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, DangNhapActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable, TIME_OUT);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
        handler = null;
        runnable = null;
    }
}