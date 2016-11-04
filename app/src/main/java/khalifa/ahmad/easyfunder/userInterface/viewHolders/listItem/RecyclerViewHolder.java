package khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import khalifa.ahmad.easyfunder.userInterface.adapters.recyclerView.RecyclerCustomAdapter;

public abstract class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public RecyclerViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void setContent(
            final Context context,
            final RecyclerCustomAdapter adapter,
            final Object object);
}
