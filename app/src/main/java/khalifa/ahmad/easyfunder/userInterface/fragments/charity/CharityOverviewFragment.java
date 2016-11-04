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
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask.APIAsyncTask;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.CharityActivity;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;
import khalifa.ahmad.easyfunder.utlities.mystatic.Resources;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharityOverviewFragment extends Fragment implements View.OnClickListener {
    private static String US = "United States";
    private static String SUPPORTED = "Supported";
    private static String SUPPORT = "Support";

    private Charity charity;
    private ImageView categoryImageView;
    private Button support;
    private TextView name;
    private TextView category;
    private TextView country;
    private TextView rate;
    private TextView mission;


    public CharityOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_charity_overview, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        charity = (Charity) getArguments().getSerializable(CharityActivity.BUNDLE_CHARITY);
        categoryImageView = (ImageView) view.findViewById(R.id.charity_details_category_image);
        support = (Button) view.findViewById(R.id.charity_details_support);
        name = (TextView) view.findViewById(R.id.charity_details_name);
        category = (TextView) view.findViewById(R.id.charity_details_category);
        country = (TextView) view.findViewById(R.id.charity_details_country);
        rate = (TextView) view.findViewById(R.id.charity_details_rate);
        mission = (TextView) view.findViewById(R.id.charity_details_mission);
        support.setOnClickListener(this);
        setUpCharity();
    }

    private void setUpCharity(){
        name.setText(charity.getName());
        category.setText(Charity.CATEGORIES[charity.getCategory()]);
        country.setText(US);
        rate.setText(String.format("%.1f", charity.getRate()));
        mission.setText(charity.getMission());
        categoryImageView.setImageDrawable(
                getContext().getDrawable(Resources.categories_logos[charity.getCategory()]));
        support.setText(Global.user.isSupportingCharity(charity) ? SUPPORTED : SUPPORT);
    }


    public static CharityOverviewFragment getInstance(Charity charity){
        Bundle bundle = new Bundle();
        bundle.putSerializable(CharityActivity.BUNDLE_CHARITY, charity);
        CharityOverviewFragment fragment = new CharityOverviewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.charity_details_support:
                supportOrUnsupport();
                break;
        }
    }

    private void supportOrUnsupport(){
        new APIAsyncTask(
                getContext(),
                Global.user.isSupportingCharity(charity) ?
                        APIAsyncTask.UNSUPPORT_CHARITY :
                        APIAsyncTask.SUPPORT_CHARITY) {
            @Override
            public void onPost(Object object) {
                support.setText(
                        Global.user.isSupportingCharity(charity) ?
                                SUPPORTED :
                                SUPPORT
                );
            }
        }.execute(charity);
    }
}
