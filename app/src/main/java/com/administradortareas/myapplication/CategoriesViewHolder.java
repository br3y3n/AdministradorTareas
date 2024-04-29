package com.administradortareas.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {

    private TextView tvCategoryName;
    private View divider;
    private CardView viewContainer;

    public CategoriesViewHolder(View view) {
        super(view);

        tvCategoryName = (TextView) view.findViewById(R.id.rvCategories);
        divider = view.findViewById(R.id.divider);
        viewContainer = (CardView) view.findViewById(R.id.viewContainer);
    }

    public void render(TaskCategory taskCategory, final OnItemClickListener listener) {

        int color = taskCategory.isSelected() ? R.color.todo_background_card : R.color.todo_background_disabled;

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.getContext(), color));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemSelected(getLayoutPosition());
            }
        });

        switch (taskCategory) {
            case Business:
                tvCategoryName.setText("Negocios");
                divider.setBackgroundColor(ContextCompat.getColor(divider.getContext(), R.color.todo_business_category));
                break;
            case Other:
                tvCategoryName.setText("Otros");
                divider.setBackgroundColor(ContextCompat.getColor(divider.getContext(), R.color.todo_other_category));
                break;
            case Personal:
                tvCategoryName.setText("Personal");
                divider.setBackgroundColor(ContextCompat.getColor(divider.getContext(), R.color.todo_personal_category));
                break;
        }
    }

    public interface OnItemClickListener {
        void onItemSelected(int position);
    }
}