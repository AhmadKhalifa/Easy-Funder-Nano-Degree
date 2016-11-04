package khalifa.ahmad.easyfunder.userInterface.activities.tabbed;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.storage.sharedPreferences.SharedPreferencesManager;
import khalifa.ahmad.easyfunder.userInterface.activities.forms.SignInActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.viewpager.ViewPagerAdapter;

public class IntroSliderActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    int[] layouts;
    private Button skipButton;
    private Button nextButton;
    private SharedPreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        preferencesManager = new SharedPreferencesManager(this);
        boolean firstTimeLaunch = preferencesManager.isFirstTimeLaunch();
        if (!firstTimeLaunch){
            goToNextActivity();
            finish();
        }

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(
                                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        skipButton = (Button) findViewById(R.id.btn_skip);
        nextButton = (Button) findViewById(R.id.btn_next);
        skipButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        layouts = new int[]{
                R.layout.slider_screen1,
                R.layout.slider_screen2,
                R.layout.slider_screen3
        };

        addBottomDots(0);

        viewPagerAdapter = new ViewPagerAdapter(IntroSliderActivity.this, layouts);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

    }

    private void goToNextActivity(){
        preferencesManager.setFirstTimeLaunch(false);
        startActivity(SignInActivity.getIntent(this));
        finish();
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        dotsLayout.removeAllViews(); //remove all items inside layout
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.green_dark));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.clouds_white));
    }

    private int getItem(int i){
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
            if (position == layouts.length - 1) {
                nextButton.setText("Get started");
                skipButton.setVisibility(View.GONE);
            } else {
                nextButton.setText(getString(R.string.next));
                skipButton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_skip:
                goToNextActivity();
                break;
            case R.id.btn_next:
                int current = getItem(+1);
                if (current < layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    goToNextActivity();
                }
                break;
        }
    }

    public static Intent getIntent(Context context){
        return new Intent(context, IntroSliderActivity.class);
    }
}
