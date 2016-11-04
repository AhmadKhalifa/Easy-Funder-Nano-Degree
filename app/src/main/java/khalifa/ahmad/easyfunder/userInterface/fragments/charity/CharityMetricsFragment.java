package khalifa.ahmad.easyfunder.userInterface.fragments.charity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.CharityActivity;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;
import khalifa.ahmad.easyfunder.utlities.mystatic.Resources;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharityMetricsFragment extends Fragment {

    private Charity charity;

    private TextView totalContributions;
    private TextView totalRevenue;
    private TextView programExpenses;
    private TextView fundraisingExpenses;
    private TextView totalFunctionalExpenses;
    private TextView netAssets;

    public CharityMetricsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_charity_metrics, container, false);
        init(view);
        return view;
    }

    public static CharityMetricsFragment getInstance(Charity charity){
        Bundle bundle = new Bundle();
        bundle.putSerializable(CharityActivity.BUNDLE_CHARITY, charity);
        CharityMetricsFragment fragment = new CharityMetricsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void init(View view){
        charity = (Charity) getArguments().getSerializable(CharityActivity.BUNDLE_CHARITY);
        totalContributions = (TextView) view.findViewById(R.id.charity_details_total_contributions);
        totalRevenue = (TextView) view.findViewById(R.id.charity_details_total_revenue);
        programExpenses = (TextView) view.findViewById(R.id.charity_details_program_expenses);
        fundraisingExpenses = (TextView) view.findViewById(R.id.charity_details_fundraising_expenses);
        totalFunctionalExpenses = (TextView) view.findViewById(R.id.charity_details_total_functional_expenses);
        netAssets = (TextView) view.findViewById(R.id.charity_details_net_assets);
        setUpCharity();
    }

    private void setUpCharity(){
        totalContributions.setText("$" + charity.getMetrics().getTotalContributions());
        totalRevenue.setText("$" + charity.getMetrics().getTotalRevenue());
        programExpenses.setText("$" + charity.getMetrics().getProgramExpenses());
        fundraisingExpenses.setText("$" + charity.getMetrics().getFundraisingExpenses());
        totalFunctionalExpenses.setText("$" + charity.getMetrics().getTotalFunctionalExpenses());
        netAssets.setText("$" + charity.getMetrics().getNetAssets());
    }
}
