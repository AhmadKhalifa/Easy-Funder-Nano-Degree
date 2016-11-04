package khalifa.ahmad.easyfunder.userInterface.activities.popup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.HomeActivity;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory.SpendingCategoryViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class PercentagePopupActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener, View.OnClickListener{
    private SeekBar seekBar;
    private TextView percentageTextView;
    private Button submit;
    private double percentage;
    private int seekBarProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage_popup);
        init();
    }

    private void init(){
        seekBar = (SeekBar) findViewById(R.id.dialog_seek_bar);
        percentageTextView = (TextView) findViewById(R.id.dialog_percentage);
        submit = (Button) findViewById(R.id.dialog_support);
        percentage = 0.00;
        seekBar.setOnSeekBarChangeListener(this);
        submit.setOnClickListener(this);
    }

    public static Intent getIntent(Context context){
        return new Intent(context, PercentagePopupActivity.class);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekBarProgress = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        percentage = 0.0 + (seekBarProgress / 5.0);
        percentageTextView.setText(String.format("%.1f%s", percentage, "%"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_support:
                useSpendingCategory();
                break;
        }
    }

    private void useSpendingCategory(){
        SpendingCategory spendingCategory = ((SpendingCategoryViewHolder)Global.viewHolder)
                .getSpendingCategory();
        if (percentage > 0.00){
            spendingCategory.setUsed(true);
            spendingCategory.setPercentage(percentage);
            spendingCategory.setTotalDonated(
                    (spendingCategory.getTotalPaid() * percentage) / 100.00);
            Global.adapter.notifyDataSetChanged();
        }
        else {
            spendingCategory.setUsed(false);
        }
        finish();
        Global.adapter = null;
        Global.viewHolder = null;
    }
}
