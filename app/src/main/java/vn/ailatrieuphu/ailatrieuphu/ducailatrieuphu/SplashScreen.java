package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginActivity;
import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity;

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
//        if (FirebaseAuth.getInstance().getCurrentUser()!=null){
            Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
            startActivity(intent);
//        } else {
//            Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
//            startActivity(intent);
//        }
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {


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