package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.R;
import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.activity.DepthPageTransformer;

public class ToolsFragment extends Fragment {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private AppBarConfiguration mAppBarConfiguration;
    private androidx.appcompat.widget.Toolbar toolbar;
    private TableLayout tabs;
    private ViewPager viewpager;
    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        toolsViewModel = ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
       // final TextView textView = root.findViewById(R.id.text_tools);
        mTabLayout = root.findViewById(R.id.tabs);
        mViewPager = root.findViewById(R.id.viewpager);

        setupViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        return root;

    }


    private void setupViewPager() {
        ToolAdapter adapter = new ToolAdapter(this.getFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


//    public void back_XH(View view) {
//        finish();
//    }
}