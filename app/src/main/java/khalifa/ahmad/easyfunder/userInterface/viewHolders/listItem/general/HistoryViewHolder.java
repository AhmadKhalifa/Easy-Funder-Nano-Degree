package khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.general;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.transaction.Transaction;
import khalifa.ahmad.easyfunder.userInterface.activities.general.ReportActivity;
import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.RecyclerViewHolder;
import khalifa.ahmad.easyfunder.utlities.mystatic.Values;

public class HistoryViewHolder  extends RecyclerViewHolder {
    private LinearLayout layout;
    private TextView month;
    private TextView amount;
    private Transaction transaction;
    private Context context;
    private RecyclerCustomAdapter adapter;

    public HistoryViewHolder(View itemView) {
        super(itemView);
        layout = (LinearLayout) itemView.findViewById(R.id.transaction_history_details);
        month = (TextView) itemView.findViewById(R.id.transaction_history_month);
        amount = (TextView) itemView.findViewById(R.id.transaction_history_amount);
    }

    @Override
    public void setContent(Context context, RecyclerCustomAdapter adapter, Object object) {
        this.context = context;
        transaction = (Transaction) object;
        Date date = transaction.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int monthNum = cal.get(Calendar.MONTH);
        month.setText(Values.months[monthNum]);
        amount.setText(
                String.format("%.2f", transaction.getTotalAmount())
        );
        amount.setTextColor(
                context.getColor(
                        transaction.getTotalAmount() == 0.00 ?
                                R.color.red :
                                R.color.green
                )
        );
        layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.transaction_history_details:
            context.startActivity(ReportActivity.getIntent(context, transaction));
            break;
        }
    }
}
