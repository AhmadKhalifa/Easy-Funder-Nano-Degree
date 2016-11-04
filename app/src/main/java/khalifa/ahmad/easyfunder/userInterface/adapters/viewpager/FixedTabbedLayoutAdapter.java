package khalifa.ahmad.easyfunder.userInterface.adapters.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FixedTabbedLayoutAdapter extends FragmentPagerAdapter{

    private String[] tabs;
    private Fragment[] fragments;

    public FixedTabbedLayoutAdapter(
            FragmentManager supportedFragmentManager,
            String[] tabs,
            Fragment[] fragments) {
        super(supportedFragmentManager);
        this.tabs = tabs;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
