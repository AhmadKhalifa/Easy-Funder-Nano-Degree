package khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.charity;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask.APIAsyncTask;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.CharityActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.RecyclerViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;
import khalifa.ahmad.easyfunder.utlities.mystatic.Resources;

public class CharityViewHolder extends RecyclerViewHolder{
    private static String SUPPORTED = "Supported";
    private static String SUPPORT = "Support";
    private Context context;
    private Charity charity;
    private LinearLayout layout;
    private TextView name;
    private ImageView imageType;
    private TextView rate;
    private Button support;
    private RecyclerCustomAdapter adapter;

    public CharityViewHolder(View itemView) {
        super(itemView);
        layout = (LinearLayout) itemView.findViewById(R.id.charity);
        name = (TextView) itemView.findViewById(R.id.charity_name);
        imageType = (ImageView) itemView.findViewById(R.id.charity_image_type);
        rate = (TextView) itemView.findViewById(R.id.charity_rate);
        support = (Button) itemView.findViewById(R.id.charity_support);
    }

    @Override
    public void setContent(Context context, RecyclerCustomAdapter adapter, Object object) {
        this.adapter = adapter;
        this.context = context;
        charity = (Charity)object;
        name.setText(charity.getName());
        rate.setText(String.format("%.1f", charity.getRate()));
        imageType.setImageDrawable(
                context.getDrawable(Resources.categories_logos[charity.getCategory()])
        );
        support.setText(
                Global.user.isSupportingCharity(charity) ?
                        SUPPORTED :
                        SUPPORT
        );
        support.setOnClickListener(this);
        layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.charity:
                context.startActivity(CharityActivity.getIntent(context, charity));
                break;
            case R.id.charity_support:
                supportOrUnsupport();
                break;
        }

    }

    private void supportOrUnsupport(){
        if (Global.user.isSupportingCharity(charity)){
            new APIAsyncTask(context, APIAsyncTask.UNSUPPORT_CHARITY) {
                @Override
                public void onPost(Object object) {

                }
            }.execute(charity);
            support.setText(SUPPORT);
        }
        else {
            new APIAsyncTask(context, APIAsyncTask.SUPPORT_CHARITY) {
                @Override
                public void onPost(Object object) {

                }
            }.execute(charity);
            support.setText(SUPPORTED);
        }
        adapter.notifyDataSetChanged();
    }
}
