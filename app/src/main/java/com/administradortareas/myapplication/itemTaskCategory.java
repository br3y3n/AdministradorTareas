package com.administradortareas.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.administradortareas.myapplication.ui.main.ItemTaskCategoryFragment;

public class itemTaskCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_task_category);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ItemTaskCategoryFragment.newInstance())
                    .commitNow();
        }
    }
}