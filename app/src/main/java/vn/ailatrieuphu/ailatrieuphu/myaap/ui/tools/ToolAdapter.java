package vn.ailatrieuphu.ailatrieuphu.myaap.ui.tools;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ToolAdapter extends FragmentPagerAdapter {
    public static final int NUM_PAGER = 3;

    public ToolAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return XHTuanFragment.newInstance(0, "HOME");

            case 1:
                return XHThangFragment.newInstance(1, "CONTACT");

            case 2:
                return XHTGFragment.newInstance(2, "SETTINGS");

            default:
                return XHTuanFragment.newInstance(0, "HOME");

        }
    }

    @Override
    public int getCount() {
        return NUM_PAGER;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tuần";
            case 1:
                return "Tháng";
            case 2:
                return "Thế Giới";
            default:
                return "Tuần";
        }
    }
}
