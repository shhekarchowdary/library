package com.arr.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    Spinner mSpinner;

    ArrayList<Book> mBooks = new ArrayList<>();
    ArrayList<String> mCategory = new ArrayList<>();
    ArrayList<Book> mCategoryBooks = new ArrayList<>();

    public static Book selectedBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.addedList);
        mSpinner = findViewById(R.id.spinner);

        fillData();

        for(Book book:mBooks){
            mCategory.add(book.getCategory());
        }
        mCategory = new ArrayList<>(new LinkedHashSet<>(mCategory));

        ArrayAdapter spinnerAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, mCategory);
        mSpinner.setAdapter(spinnerAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String categorySelected = mCategory.get(i);
                mCategoryBooks.clear();
                for(Book book:mBooks){
                    if(book.getCategory().equalsIgnoreCase(categorySelected)){
                        mCategoryBooks.add(book);
                    }
                }
                CustomAdapter listAdapter = new CustomAdapter(getApplicationContext(),mCategoryBooks);
                myListView.setAdapter(listAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBook = mCategoryBooks.get(i);
                Intent intent = new Intent(getBaseContext(),MainActivity3.class);
                startActivity(intent);
            }
        });

    }

    public void fillData(){
        mBooks.add(new Book("8173666024","Java","Kathy Sierra","Computer"));
        mBooks.add(new Book("9789351194095","Android Development","Pradeep Kothari","Computer"));
        mBooks.add(new Book("1789139864","Swift5","Jon Hoffman","Computer"));
        mBooks.add(new Book("B01LKBOAPS","Spoken English in Dialogues","Julia Deniskina","English"));
        mBooks.add(new Book("B01N6Z7N78","English Literature","William J. Long ","English"));
        mBooks.add(new Book("B08423R6J2","Descriptive English","SP Bakshi","English"));
        mBooks.add(new Book("085750357X","Black Holes The Reith Lectures","Stephen Hawking","Science"));
        mBooks.add(new Book("145160713X","For the Love of Physics","Walter Lewin","Science"));
        mBooks.add(new Book("8172344880","The Origin of Species","Charles Darwin","Science"));
    }

}