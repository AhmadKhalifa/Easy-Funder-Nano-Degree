package khalifa.ahmad.easyfunder.userInterface.activities.tabbed;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.userInterface.adapters.viewpager.FixedTabbedLayoutAdapter;
import khalifa.ahmad.easyfunder.userInterface.fragments.charity.CharityMetricsFragment;
import khalifa.ahmad.easyfunder.userInterface.fragments.charity.CharityOverviewFragment;
import khalifa.ahmad.easyfunder.userInterface.fragments.home.HomeCharitiesFragment;
import khalifa.ahmad.easyfunder.userInterface.fragments.home.HomeDashboardFragment;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;
import khalifa.ahmad.easyfunder.utlities.mystatic.Resources;

public class CharityActivity extends AppCompatActivity {
    public static String EXTRA_CHARITY = "charity";
    public static String BUNDLE_CHARITY = "charity";
    public static String OVERVIEW = "Overview";
    public static String METRICS = "Metrics";
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FixedTabbedLayoutAdapter adapter;
    private Charity charity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);
        init();
    }

    private void init(){
        charity = (Charity) getIntent().getExtras().getSerializable(CharityActivity.EXTRA_CHARITY);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        viewPager = (ViewPager) findViewById(R.id.charity_viewpager);
        adapter = new FixedTabbedLayoutAdapter(
                getSupportFragmentManager(),
                new String[]{
                        OVERVIEW,
                        METRICS
                },
                new Fragment[] {
                        CharityOverviewFragment.getInstance(charity),
                        CharityMetricsFragment.getInstance(charity)
                }
        );
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.getTabAt(0).setIcon(getResources().getDrawable(Resources.OVERVIEW));
            tabLayout.getTabAt(1).setIcon(getResources().getDrawable(Resources.METRICS));
        }
    }

    public static Intent getIntent(Context context, Charity charity){
        return new Intent(context, CharityActivity.class)
                .putExtra(CharityActivity.EXTRA_CHARITY, charity);
    }
}
