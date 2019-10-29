package vn.ailatrieuphu.ailatrieuphu.myaap.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.ailatrieuphu.ailatrieuphu.myaap.R;
import vn.ailatrieuphu.ailatrieuphu.myaap.activity.DepthPageTransformer;
import vn.ailatrieuphu.ailatrieuphu.myaap.activity.MyViewPagerAdapter;

public class ToolsFragment extends Fragment {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private AppBarConfiguration mAppBarConfiguration;
    private androidx.appcompat.widget.Toolbar toolbar;
    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        toolsViewModel = ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        ToolAdapter adapter = new ToolAdapter(getFragmentManager());
        mTabLayout = root.findViewById(R.id.tabs);
        mViewPager = root.findViewById(R.id.viewpager);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        setIcon();
        return root;

    }

    private void setIcon(){
        mTabLayout.getTabAt(0).setIcon(R.drawable.app__ic_week);
        mTabLayout.getTabAt(1).setIcon(R.drawable.app__ic_month);
        mTabLayout.getTabAt(2).setIcon(R.drawable.app__ic_year);
    }

}