package khalifa.ahmad.easyfunder.userInterface.activities.list;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory.SpendingCategoryViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class SpendingCategoriesListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerCustomAdapter<SpendingCategory> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_categories_list);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        init();
    }

    private void init(){
        recyclerView = (RecyclerView) findViewById(R.id.spending_categories_recycler_view);
        adapter = new RecyclerCustomAdapter<>(
                this,
                Global.user.getUsedSpendingCategories(),
                R.layout.list_item_spending_category,
                SpendingCategoryViewHolder.class
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public static Intent getIntent(Context context){
        return new Intent(context, SpendingCategoriesListActivity.class);
    }
}
