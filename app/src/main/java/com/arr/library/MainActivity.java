package com.arr.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    Button mAdd, mMyList;

    HashMap<String,Double> dataMap = new HashMap<>();
    //HashMap<String,Double> addedBooks = new HashMap<>();
    ArrayList<String> addedBooks = new ArrayList<>();

    String selectedBook = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.listView1);
        mAdd = findViewById(R.id.button1);
        mMyList = findViewById(R.id.button2);

        fillData();

        CustomAdapter listAdapter = new CustomAdapter(getApplicationContext(),dataMap);
        myListView.setAdapter(listAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBook = String.valueOf(dataMap.keySet().toArray()[i]);
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!selectedBook.isEmpty()){
                    boolean flag = true;
                    if(addedBooks.size() >= 1){
                        for(String s: addedBooks){
                            if(s.equalsIgnoreCase(selectedBook)){
                                flag = false;
                            }
                        }
                        if(flag){
                            Log.d("tag1","in added book");
                            addedBooks.add(selectedBook);
                            Toast.makeText(getBaseContext(),"Book added to List",Toast.LENGTH_LONG).show();
                        }else
                            Toast.makeText(getBaseContext(),"Book Already in List",Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(getBaseContext(),"Book added to List",Toast.LENGTH_LONG).show();
                        addedBooks.add(selectedBook);
                    }
                }
                else{
                    Log.d("tag1","in book");
                    Toast.makeText(getBaseContext(),"Please Select Book",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void fillData(){
        dataMap.put("Book1",100.0);
        dataMap.put("Book2",100.0);
        dataMap.put("Book3",99.0);
        dataMap.put("Book4",1000.0);
        dataMap.put("Book5",899.0);
        dataMap.put("Book6",233.0);
        dataMap.put("Book7",67.0);
        dataMap.put("Book8",167.0);
        dataMap.put("Book9",876.0);
        dataMap.put("Book10",1238.0);
        dataMap.put("Book11",675.0);
        dataMap.put("Book12",455.0);
        dataMap.put("Book13",87.0);
        dataMap.put("Book14",34.0);
        dataMap.put("Book15",34.0);
        dataMap.put("Book16",12.0);
        dataMap.put("Book17",65.0);
        dataMap.put("Book18",35.0);
        dataMap.put("Book19",67.0);
        dataMap.put("Book20",45.0);
    }

}