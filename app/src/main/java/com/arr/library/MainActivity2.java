package com.arr.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    ListView myList;
    Button mDelete,mClear;
    ArrayList<Book> addedBooks = new ArrayList<>();
    Book selectedBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myList = findViewById(R.id.addedList);
        mDelete = findViewById(R.id.btnDeleteBook);
        mClear = findViewById(R.id.btnClearList);

        addedBooks = MainActivity3.addedBooks;

        CustomAdapter lAdapter = new CustomAdapter(getApplicationContext(),addedBooks);
        myList.setAdapter(lAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBook = addedBooks.get(i);
            }
        });

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedBook != null){
                    Log.d("tag1","in added book");
                    addedBooks.remove(selectedBook);
                    Toast.makeText(getBaseContext(),"Deletion Successful",Toast.LENGTH_LONG).show();
                    lAdapter.notifyDataSetChanged();
                }
                else{
                    Log.d("tag1","in book");
                    Toast.makeText(getBaseContext(),"Please Select Book to Delete",Toast.LENGTH_LONG).show();
                }
            }
        });

        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedBooks.clear();
                Toast.makeText(getBaseContext(),"Deletion Successful",Toast.LENGTH_LONG).show();
                lAdapter.notifyDataSetChanged();
            }
        });

    }
}