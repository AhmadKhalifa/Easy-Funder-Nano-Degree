package khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.RecyclerViewHolder;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.charity.CharityViewHolder;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.charity.MiniCharityViewHolder;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.general.HistoryViewHolder;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory.MiniSpendingCategoryViewHolder;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.spendingCategory.SpendingCategoryViewHolder;

public final class RecyclerCustomAdapter <DATA_TYPE> extends RecyclerView.Adapter<RecyclerViewHolder>{
    private Context context;
    private ArrayList<DATA_TYPE> list;
    private int layoutID;
    private Class<?> cls;

    public RecyclerCustomAdapter(
            Context context,
            ArrayList<DATA_TYPE> list,
            int layoutID,
            Class<?> cls){
        this.context = context;
        this.list = list;
        this.layoutID = layoutID;
        this.cls = cls;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(layoutID, parent, false);
        if (cls == MiniCharityViewHolder.class){
            return new MiniCharityViewHolder(itemView);
        }
        else if (cls == CharityViewHolder.class){
            return new CharityViewHolder(itemView);
        }
        else if (cls == HistoryViewHolder.class){
            return new HistoryViewHolder(itemView);
        }
        else if (cls == MiniSpendingCategoryViewHolder.class){
            return new MiniSpendingCategoryViewHolder(itemView);
        }
        else {
            return new SpendingCategoryViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.setContent(context, this, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
