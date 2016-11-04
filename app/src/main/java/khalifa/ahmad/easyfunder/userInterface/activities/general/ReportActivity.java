package khalifa.ahmad.easyfunder.userInterface.activities.general;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.models.transaction.Transaction;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.HomeActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory.SpendingCategoryViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Values;

public class ReportActivity extends AppCompatActivity {
    public static String EXTRA_TRANSACTION = "Transaction";

    private RecyclerView recyclerView;
    private RecyclerCustomAdapter<SpendingCategory> adapter;
    private Transaction transaction;
    private TextView period;
    private TextView amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        init();
    }

    private void init(){
        transaction = (Transaction) getIntent().getExtras().getSerializable(EXTRA_TRANSACTION);
        recyclerView = (RecyclerView) findViewById(R.id.report_recycler_view);
        period = (TextView) findViewById(R.id.report_total_date);
        amount = (TextView) findViewById(R.id.report_total_donations);
        setUpTransaction();
    }

    private void setUpTransaction(){
        period.setText(String.format(
                "%s, %d",
                Values.months[transaction.getDate().getMonth() - 1],
                transaction.getDate().getYear())
        );
        amount.setText(String.format("$%.2f", transaction.getTotalAmount()));
        adapter = new RecyclerCustomAdapter<>(
                this,
                transaction.getUsedSpendingCategories(),
                R.layout.list_item_spending_category,
                SpendingCategoryViewHolder.class
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public static Intent getIntent(Context context, Transaction transaction){
        return new Intent(context, ReportActivity.class)
                .putExtra(EXTRA_TRANSACTION, transaction);
    }
}
