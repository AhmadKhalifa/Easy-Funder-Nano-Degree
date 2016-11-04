package khalifa.ahmad.easyfunder.userInterface.fragments.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.userInterface.activities.general.ReportActivity;
import khalifa.ahmad.easyfunder.userInterface.activities.list.CharitiesListActivity;
import khalifa.ahmad.easyfunder.userInterface.activities.list.SpendingCategoriesListActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.charity.MiniCharityViewHolder;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory.MiniSpendingCategoryViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeDashboardFragment extends Fragment implements View.OnClickListener{

    RecyclerView[] recyclerViewsLayouts;
    LinearLayout[] headingLayouts;
    private LinearLayout notification;
    private Button notificationDetails;
    private Button notificationDismiss;
    private Button statusDetails;
    private TextView notificationText;
    private TextView statusText;

    public HomeDashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_dashboard, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        notification = (LinearLayout) view.findViewById(R.id.home_dashboard_notification);
        notificationDetails = (Button) view.findViewById(R.id.notifications_details);
        notificationText = (TextView) view.findViewById(R.id.notification_text);
        statusText = (TextView) view.findViewById(R.id.status_text);
        statusDetails = (Button) view.findViewById(R.id.status_details);
        notificationDismiss = (Button) view.findViewById(R.id.notifications_dismiss);

        notificationDetails.setOnClickListener(this);
        notificationDismiss.setOnClickListener(this);
        statusDetails.setOnClickListener(this);
        headingLayouts = new LinearLayout[]{
                (LinearLayout) view.findViewById(R.id.home_dashboard_supported_charities),
                (LinearLayout) view.findViewById(R.id.home_dashboard_spending_categories)
        };
        recyclerViewsLayouts = new RecyclerView[]{
                (RecyclerView) view.findViewById(R.id.supported_charities_recycler_view),
                (RecyclerView) view.findViewById(R.id.current_spending_categories_recycler_view)
        };
        for (int i = 0; i < 2; i++) {
            headingLayouts[i].setOnClickListener(this);
            recyclerViewsLayouts[i].setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViewsLayouts[i].setItemAnimator(new DefaultItemAnimator());
        }
        updateAdapters();
    }

    private void updateAdapters(){
        updateStatus();
        recyclerViewsLayouts[0].setAdapter(
                new RecyclerCustomAdapter<>(
                        getContext(),
                        Global.user.getSupportedCharities(),
                        R.layout.list_mini_item_charity,
                        MiniCharityViewHolder.class
                )
        );

        recyclerViewsLayouts[1].setAdapter(
                new RecyclerCustomAdapter<>(
                        getContext(),
                        Global.user.getCurrentlyUsedSpendingCategories(),
                        R.layout.list_mini_item_spending_category,
                        MiniSpendingCategoryViewHolder.class
                )
        );
    }

    private void updateStatus(){
        User user = Global.user;
        if (user.hasNotification()){
            if (user.getLastMonthTransaction().getTotalAmount() > 0.00){
                notificationText.setText(
                        String.format(
                                "Last month, you have supported charities with $%.2f",
                                user.getLastMonthTransaction().getTotalAmount()
                        )
                );
            }
        }
        statusText.setText(
                String.format(
                        "For this month, you are supporting %d charities with total amount of $%.2f",
                        user.getSupportedCharities().size(),
                        user.getCurrentMonthTransaction().getTotalAmount()
                )
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.notifications_details:
                startActivity(ReportActivity.getIntent(getContext(), Global.user.getLastMonthTransaction()));
                break;
            case R.id.status_details:
                startActivity(ReportActivity.getIntent(getContext(), Global.user.getCurrentMonthTransaction()));
                break;
            case R.id.notifications_dismiss:
                notification.setVisibility(View.GONE);
                break;
            case R.id.home_dashboard_supported_charities:
                startActivity(CharitiesListActivity.getIntent(getContext(),
                        CharitiesListActivity.SUPPORTED_CHARITIES));
                break;
            case R.id.home_dashboard_spending_categories:
                startActivity(SpendingCategoriesListActivity.getIntent(getContext()));
                break;
        }
    }

    public static HomeDashboardFragment getInstance(){
        return new HomeDashboardFragment();
    }
}