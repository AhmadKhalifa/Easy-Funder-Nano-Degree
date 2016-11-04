package khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.RecyclerViewHolder;

public class MiniSpendingCategoryViewHolder  extends RecyclerViewHolder {
    private TextView nameAndPercentage;
    private TextView amountDonated;
    private RecyclerCustomAdapter adapter;

    public MiniSpendingCategoryViewHolder(View itemView) {
        super(itemView);
        nameAndPercentage =
                (TextView) itemView.findViewById(R.id.mini_spending_category_name_and_percentage);
        amountDonated = (TextView) itemView.findViewById(R.id.mini_spending_category_amount);
    }

    @Override
    public void setContent(Context context, RecyclerCustomAdapter adapter, Object object) {
        SpendingCategory spendingCategory = (SpendingCategory) object;
        nameAndPercentage.setText(
                String.format("%s (%.1f%s)",
                        spendingCategory.getName(),
                        spendingCategory.getPercentage(),
                        "%"
                )
        );
        amountDonated.setText(String.format("%.2f", spendingCategory.getTotalDonated()));
    }

    @Override
    public void onClick(View v) {

    }
}
