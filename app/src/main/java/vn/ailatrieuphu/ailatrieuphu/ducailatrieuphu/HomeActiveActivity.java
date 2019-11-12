package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.home.HomeFragment;

public class HomeActiveActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration, m;
    ImageView imgv;
    TextView tvna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_active2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        imgv=findViewById(R.id.imageView222);
        tvna=findViewById(R.id.tvname222);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
               R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        Intent intent=getIntent();
        String nameemail=intent.getStringExtra("nameemail");
        String img=intent.getStringExtra("imgemail");

        addFragment(HomeFragment.newInstance(nameemail,img));


//        Bundle bundle = new Bundle();
//        bundle.putString("na", nameemail );
//        bundle.putString("img", img);
//        Log.e("bundlelog", bundle.toString());
//        HomeFragment fragInfo = new HomeFragment ();
//        fragInfo.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragInfo);
//        getSupportFragmentManager().beginTransaction().commit();
//         tvna.setText(nameemail.toString());
//         Picasso.with(this).load(img).into(imgv);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home_active, menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        switch (id){
//            case R.id.nav_tools:
//                Intent intent=new Intent(this,BangXepHangActivity.class);
//                startActivity(intent);
//        }
//        if (id == R.id.nav_tools) {
//            startActivity(new Intent(getApplicationContext(), BangXepHangActivity.class));
//
//        }
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addFragment(Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.add(R.id.nav_host_fragment, fragment);
        ft.addToBackStack(name);
        ft.commit();
    }
}
