package com.campany.mytaskapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText itemInput;
    private Button addBtn;
    private ListView shoppingList;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemInput = findViewById(R.id.itemInput);
        addBtn = findViewById(R.id.addBtn);
        shoppingList = findViewById(R.id.shoppingList);

        items = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        shoppingList.setAdapter(adapter);

        addBtn.setOnClickListener(v -> {
            String item = itemInput.getText().toString().trim();
            if (!item.isEmpty()) {
                items.add(item);
                adapter.notifyDataSetChanged();
                itemInput.setText("");
            } else {
                Toast.makeText(this, "Введите название товара", Toast.LENGTH_SHORT).show();
            }
        });

        shoppingList.setOnItemClickListener((parent, view, position, id) -> {
            items.remove(position);
            adapter.notifyDataSetChanged();
        });
    }
}
