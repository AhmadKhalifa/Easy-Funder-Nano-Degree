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
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.userInterface.activities.forms.SignInActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.viewpager.FixedTabbedLayoutAdapter;
import khalifa.ahmad.easyfunder.userInterface.fragments.home.HomeCharitiesFragment;
import khalifa.ahmad.easyfunder.userInterface.fragments.home.HomeDashboardFragment;
import khalifa.ahmad.easyfunder.userInterface.fragments.home.HomeProfileFragment;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;
import khalifa.ahmad.easyfunder.utlities.mystatic.Resources;

public class HomeActivity extends AppCompatActivity {
    public static String DASHBOARD = "Dashboard";
    public static String CHARITIES = "Charities";
    public static String PROFILE = "Profile";

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FixedTabbedLayoutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        viewPager = (ViewPager) findViewById(R.id.home_viewpager);
        adapter = new FixedTabbedLayoutAdapter(
                getSupportFragmentManager(),
                new String[]{
                        DASHBOARD,
                        CHARITIES,
                        PROFILE
                },
                new Fragment[] {
                        HomeDashboardFragment.getInstance(),
                        HomeCharitiesFragment.getInstance(),
                        HomeProfileFragment.getInstance()
                }
        );
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.getTabAt(0).setIcon(getResources().getDrawable(Resources.DASHBOARD));
            tabLayout.getTabAt(1).setIcon(getResources().getDrawable(Resources.CHARITIES));
            tabLayout.getTabAt(2).setIcon(getResources().getDrawable(Resources.PROFILE));
            if (Global.user.getSupportedCharities().size() == 0){
                tabLayout.getTabAt(1).select();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sign_out:
                startActivity(SignInActivity.getIntent(this));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent getIntent(Context context){
        return new Intent(context, HomeActivity.class);
    }
}
