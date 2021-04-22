package com.arr.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    ListView myList;
    Button mDelete,mClear,mBorrow;
    TextView mTotal;
    HashMap<String,Double> addedBooks = new HashMap<>();
    String selectedBook = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myList = findViewById(R.id.addedList);
        mBorrow = findViewById(R.id.btnBorrow);
        mTotal = findViewById(R.id.txtTotal);

        addedBooks = MainActivity.addedBooks;

        CustomAdapter lAdapter = new CustomAdapter(getApplicationContext(),addedBooks);
        myList.setAdapter(lAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBook = String.valueOf(addedBooks.keySet().toArray()[i]);
            }
        });

        double total = 0;
        for(String s: addedBooks.keySet()){
            total += addedBooks.get(s);
        }

        mTotal.setText(Double.toString(total));

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedBooks.clear();
                lAdapter.notifyDataSetChanged();
                mTotal.setText("");
                Toast.makeText(getBaseContext(),"Borrow Successful",Toast.LENGTH_LONG).show();
            }
        });




    }
}