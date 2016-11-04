package khalifa.ahmad.easyfunder.userInterface.activities.list;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.HomeActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.charity.CharityViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class CharitiesListActivity extends AppCompatActivity {

    public static String EXTRA_CHARITY_LIST = "Extra charity list";
    public static int SUPPORTED_CHARITIES = 7;

    private RecyclerView recyclerView;
    private RecyclerCustomAdapter<Charity> adapter;
    private int category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charities_list);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        init();
    }

    private void init(){
        category = getIntent().getExtras().getInt(EXTRA_CHARITY_LIST);
        recyclerView = (RecyclerView) findViewById(R.id.charities_recycler_view);
        adapter = new RecyclerCustomAdapter<>(
                this,
                category < 7 ?
                        Global.allCharities.get(category) :
                        Global.user.getSupportedCharities(),
                R.layout.list_item_charity,
                CharityViewHolder.class
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public static Intent getIntent(Context context, int category){
        return new Intent(context, CharitiesListActivity.class)
                .putExtra(EXTRA_CHARITY_LIST, category);
    }
}
