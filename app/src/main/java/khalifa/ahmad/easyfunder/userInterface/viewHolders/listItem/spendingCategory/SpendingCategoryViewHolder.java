package khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.userInterface.activities.forms.SignUpActivity;
import khalifa.ahmad.easyfunder.userInterface.activities.popup.PercentagePopupActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.RecyclerViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class SpendingCategoryViewHolder  extends RecyclerViewHolder {
    private static String ADD = "Add";
    private static String REMOVE = "Remove";
    private TextView nameAndTotalPaid;
    private TextView amountDonated;
    private TextView percentage;
    private LinearLayout details;
    private Button use;
    private Context context;
    private SpendingCategory spendingCategory;
    private RecyclerCustomAdapter adapter;

    public SpendingCategoryViewHolder(View itemView) {
        super(itemView);
        nameAndTotalPaid = (TextView) itemView.findViewById(R.id.spending_category_name);
        amountDonated = (TextView) itemView.findViewById(R.id.spending_category_amount);
        percentage = (TextView) itemView.findViewById(R.id.spending_category_percentage);
        details = (LinearLayout) itemView.findViewById(R.id.spending_category_my_details);
        use = (Button) itemView.findViewById(R.id.spending_category_use);
    }

    @Override
    public void setContent(Context context, RecyclerCustomAdapter adapter, Object object) {
        this.adapter = adapter;
        this.context = context;
        spendingCategory = (SpendingCategory)object;
        update();
    }

    public void update(){
        nameAndTotalPaid.setText(
                String.format("%s ($%s)",
                        spendingCategory.getName(),
                        spendingCategory.getTotalPaid()
                )
        );
        amountDonated.setText(
                String.format("$%.2f",
                        spendingCategory.getTotalDonated())
        );
        percentage.setText(
                String.format("%.1f%s",
                        spendingCategory.getPercentage(), "%")
        );
        amountDonated.setTextColor(
                context.getResources().getColor(
                        spendingCategory.getTotalDonated() > 0.00 ?
                                R.color.green :
                                R.color.red
                )
        );
        if (spendingCategory.isUsed()){
            details.setVisibility(View.VISIBLE);
            use.setText(REMOVE);
            use.setBackgroundColor(context.getResources().getColor(R.color.red));
        }
        else {
            details.setVisibility(View.INVISIBLE);
            use.setText(ADD);
            use.setBackgroundColor(context.getResources().getColor(R.color.green));
        }
        use.setOnClickListener(this);
    }

    public SpendingCategory getSpendingCategory(){
        return spendingCategory;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.spending_category_use:
                useOrRemove();
                break;
        }
    }

    private void useOrRemove(){
        if (spendingCategory.isUsed()){
            spendingCategory.setUsed(false);
            adapter.notifyDataSetChanged();
        }
        else {
            Global.viewHolder = this;
            Global.adapter = adapter;
            context.startActivity(PercentagePopupActivity.getIntent(context));
        }
    }
}
