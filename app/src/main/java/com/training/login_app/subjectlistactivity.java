package com.training.login_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.login_app.adaptor.ItemAdapter;
import com.training.login_app.datamodel.Item;

import java.util.ArrayList;
import java.util.List;

public class subjectlistactivity extends AppCompatActivity {
    RecyclerView subjectlist_recycleview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subjectlistactivity);

        subjectlist_recycleview = findViewById(R.id.subjectlist_recycleview);
        subjectlist_recycleview.setLayoutManager(new LinearLayoutManager(this));
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Computer Science"));
        itemList.add(new Item("Data Science"));
        itemList.add(new Item("DSA" ));
        itemList.add(new Item("Math"));
        itemList.add(new Item("Physics"));
        itemList.add(new Item("Chemistry"));
        itemList.add(new Item("Algorithm"));
        itemList.add(new Item("Designing"));
        itemList.add(new Item("Matlab"));
        itemList.add(new Item("Spoken English"));


        ItemAdapter adapter = new ItemAdapter(itemList);
        subjectlist_recycleview.setAdapter(adapter);







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}