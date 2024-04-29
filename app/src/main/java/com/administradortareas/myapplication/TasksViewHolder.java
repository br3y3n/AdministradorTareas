package com.administradortareas.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class TasksViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTask;
    private CheckBox cbTask;

    public TasksViewHolder(View view) {
        super(view);

        tvTask = (TextView) view.findViewById(R.id.tvTask);
        cbTask = (CheckBox) view.findViewById(R.id.cbTask);
    }

    public void render(Task task) {
        if (task.isSelected()) {
            tvTask.getPaint().setFlags(tvTask.getPaint().getFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            tvTask.getPaint().setFlags(tvTask.getPaint().getFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }

        tvTask.setText(task.getName());
        cbTask.setChecked(task.isSelected());

        int color;
        switch (task.getCategory()) {
            case Business:
                color = R.color.todo_business_category;
                break;
            case Other:
                color = R.color.todo_other_category;
                break;
            case Personal:
                color = R.color.todo_personal_category;
                break;
            default:
                color = 0; // Handle default case if needed
        }

        ColorStateList colorStateList = ColorStateList.valueOf(color);
        cbTask.setButtonTintList(colorStateList);
    }
}