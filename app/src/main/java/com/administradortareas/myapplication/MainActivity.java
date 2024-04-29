package com.administradortareas.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private List<TaskCategory> categories;
    private final List<Task> tasks = new ArrayList<>();


    private RecyclerView rvCategories;
    private CategoriesAdapter categoriesAdapter;

    private RecyclerView rvTasks;
    private TasksAdapter tasksAdapter;

    private FloatingActionButton fabAddTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        initUI();
        initListeners();
    }
    private void initListeners() {
        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_task);

        final Button btnAddTask = dialog.findViewById(R.id.btnAddTask);
        final EditText etTask = dialog.findViewById(R.id.etTask);
        final RadioGroup rgCategories = dialog.findViewById(R.id.rgCategories);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentTask = etTask.getText().toString().trim();
                if (!currentTask.isEmpty()) {
                    int selectedId = rgCategories.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = dialog.findViewById(selectedId);
                    TaskCategory currentCategory;
                    String selectedCategoryString = selectedRadioButton.getText().toString();
                    if (selectedCategoryString.equals(getString(R.string.todo_dialog_category_business))) {
                        currentCategory = TaskCategory.Business;
                    } else if (selectedCategoryString.equals(getString(R.string.todo_dialog_category_personal))) {
                        currentCategory = TaskCategory.Personal;
                    } else {
                        currentCategory = TaskCategory.Other;
                    }

                    tasks.add(new Task(currentTask, currentCategory));
                    updateTasks();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

    private void initComponent() {
        rvCategories = findViewById(R.id.rvCategories);
        rvTasks = findViewById(R.id.rvTasks);
        fabAddTask = findViewById(R.id.fabAddTask);
    }

    private void initUI() {
        categoriesAdapter = new CategoriesAdapter(categories, position -> updateCategories(position));
        rvCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvCategories.setAdapter(categoriesAdapter);

        tasksAdapter = new TasksAdapter(Collections.singletonList((Task) tasks),
                (TasksAdapter.OnTaskSelectedListener) position -> onItemSelected(position));
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        rvTasks.setAdapter(tasksAdapter);
    }

    private void onItemSelected(int position) {
        tasks.get(position).setSelected(!tasks.get(position).isSelected());
        updateTasks();
    }

    private void updateCategories(int position) {
        categories.get(position).setSelected(!categories.get(position).isSelected());
        categoriesAdapter.notifyItemChanged(position);
        updateTasks();
    }

    private void updateTasks() {
        List<TaskCategory> selectedCategories;
        selectedCategories = new ArrayList<>();
        for (TaskCategory category : categories) {
            if (category.isSelected()) {
                selectedCategories.add(category);
            }
        }
        List<Task> newTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (selectedCategories.contains(task.getCategory())) {
                newTasks.add(task);
            }
        }
        tasksAdapter.updateTasks(newTasks);
        tasksAdapter.notifyDataSetChanged();
    }


}