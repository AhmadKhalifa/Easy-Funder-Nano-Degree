package khalifa.ahmad.easyfunder.userInterface.activities.general;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.IntroSliderActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        startActivity(IntroSliderActivity.getIntent(SplashScreenActivity.this));
                        finish();
                    }
                },
                2000
        );
    }
}
