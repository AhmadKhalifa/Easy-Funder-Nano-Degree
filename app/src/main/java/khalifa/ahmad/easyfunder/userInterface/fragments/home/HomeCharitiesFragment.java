package khalifa.ahmad.easyfunder.userInterface.fragments.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.userInterface.activities.list.CharitiesListActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.charity.CharityViewHolder;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.charity.MiniCharityViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeCharitiesFragment extends Fragment {

    private ArrayList<LinearLayout> headings;
    private ArrayList<RecyclerView> recyclerViews;
    private static int NUM_OF_CATEGORIES = 7;

    public HomeCharitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_charities, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        headings = new ArrayList<>(
                Arrays.asList(
                        new LinearLayout[] {
                                (LinearLayout) view.findViewById(
                                        R.id.home_charities_heading_animals),
                                (LinearLayout) view.findViewById(
                                        R.id.home_charities_heading_art),
                                (LinearLayout) view.findViewById(
                                        R.id.home_charities_heading_community),
                                (LinearLayout) view.findViewById(
                                        R.id.home_charities_heading_education),
                                (LinearLayout) view.findViewById(
                                        R.id.home_charities_heading_environment),
                                (LinearLayout) view.findViewById(
                                        R.id.home_charities_heading_health),
                                (LinearLayout) view.findViewById(
                                        R.id.home_charities_heading_research)
                        }
                )
        );
        recyclerViews = new ArrayList<>(
                Arrays.asList(
                        new RecyclerView[] {
                                (RecyclerView) view.findViewById(
                                        R.id.animals_charities_recycler_view),
                                (RecyclerView) view.findViewById(
                                        R.id.art_charities_recycler_view),
                                (RecyclerView) view.findViewById(
                                        R.id.community_charities_recycler_view),
                                (RecyclerView) view.findViewById(
                                        R.id.education_charities_recycler_view),
                                (RecyclerView) view.findViewById(
                                        R.id.environment_charities_recycler_view),
                                (RecyclerView) view.findViewById(
                                        R.id.health_charities_recycler_view),
                                (RecyclerView) view.findViewById(
                                        R.id.research_charities_recycler_view)
                        }
                )
        );
        for (int i = 0; i < NUM_OF_CATEGORIES; i++) {
            final int finalI = i;
            headings.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(CharitiesListActivity.getIntent(getContext(), finalI));
                }
            });
            recyclerViews.get(i).setItemAnimator(new DefaultItemAnimator());
            recyclerViews.get(i).setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerViews.get(i).setAdapter(
                    new RecyclerCustomAdapter<>(
                            getContext(),
                            Global.allCharities.get(i),
                            R.layout.list_mini_item_charity,
                            MiniCharityViewHolder.class
                    )
            );
        }
    }

    public static HomeCharitiesFragment getInstance(){
        return new HomeCharitiesFragment();
    }
}
