package com.administradortareas.myapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksViewHolder> {

    private final List<Task> tasks;
    private final OnTaskSelectedListener onTaskSelectedListener;

    public TasksAdapter(List<Task> tasks, OnTaskSelectedListener onTaskSelectedListener) {
        this.tasks = tasks;
        this.onTaskSelectedListener = onTaskSelectedListener;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo_task, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.render(tasks.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTaskSelectedListener.onTaskSelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public interface OnTaskSelectedListener {
        void onTaskSelected(int position);
    }
}