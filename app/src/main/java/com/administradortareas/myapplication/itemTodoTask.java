package com.administradortareas.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.administradortareas.myapplication.ui.main.ItemTodoTaskFragment;

public class itemTodoTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_todo_task);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ItemTodoTaskFragment.newInstance())
                    .commitNow();
        }
    }
}