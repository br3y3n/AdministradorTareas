package com.administradortareas.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {

    private final List<TaskCategory> categories;
    private final CategoriesViewHolder.OnItemClickListener onItemSelectedListener;

    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    public CategoriesAdapter(List<TaskCategory> categories, OnItemSelectedListener listener) {
        this.categories = categories;
        this.onItemSelectedListener = (CategoriesViewHolder.OnItemClickListener) listener;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_category, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {
        holder.render(categories.get(position), onItemSelectedListener);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}