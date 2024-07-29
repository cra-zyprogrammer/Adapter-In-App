package com.crazyprogrammer.adaptorapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // 1. Adapter View
        listView = findViewById(R.id.listView);

        // 2. Data Source
        String[] Countries = {"America" , "Dubai" , "Israil" , "Canada" , "Thiland" , "Singapore" , "India" , "Germany" , "Pakistan" , "China" , "Japan" , "South Korea"};

        // 3. Adapter : it acts as a bridge between the data source and 'Adapter View'
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Countries
        );

        // 4. Link list view with the adaptor
        listView.setAdapter(adapter);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}