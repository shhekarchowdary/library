package com.arr.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ImageView mImageView1,mImageView2;
    TextView mDescription;
    Button mBorrow,mMyBorrowings,mBack;
    Book selectedBook = null;
    int res1,res2;

    public static ArrayList<Book> addedBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mImageView1 = findViewById(R.id.img1);
        mImageView2 = findViewById(R.id.img2);
        mDescription = findViewById(R.id.textView4);
        mBorrow = findViewById(R.id.btnBorrow2);
        mMyBorrowings = findViewById(R.id.btnMyBorrowings);
        mBack = findViewById(R.id.btnBack);

        selectedBook = MainActivity.selectedBook;

        String imgName1 = selectedBook.getTitle().toLowerCase().replace(" ","") + "1";
        res1 = getResources().getIdentifier(imgName1,"drawable",getPackageName());
        mImageView1.setImageResource(res1);

        String imgName2 = selectedBook.getTitle().toLowerCase().replace(" ","") + "2";
        res2 = getResources().getIdentifier(imgName2,"drawable",getPackageName());
        mImageView2.setImageResource(res2);

        mDescription.setText(new StringBuilder().append("Category: ").append(selectedBook.getCategory()).append("\nThe Book ").append(selectedBook.getTitle()).append(" was written by ").append(selectedBook.getAuthorName()).append("\nISBN:").append(selectedBook.getIsbn()).toString());

        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = res1;
                res1 = res2;
                res2 = temp;

                mImageView1.setImageResource(res1);
                mImageView2.setImageResource(res2);
            }
        });

        mBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addedBooks.size() < 5){
                    boolean flag = true;
                    if(addedBooks.size() >= 1){
                        for(Book book: addedBooks){
                            if(book.getTitle().equalsIgnoreCase(selectedBook.getTitle())){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            Log.d("tag1","in added book");
                            addedBooks.add(selectedBook);
                            Toast.makeText(getBaseContext(),"Borrow Successful",Toast.LENGTH_LONG).show();
                        }else
                            Toast.makeText(getBaseContext(),"You have already Borrowed this Book",Toast.LENGTH_LONG).show();
                    }else{
                        addedBooks.add(selectedBook);
                        Toast.makeText(getBaseContext(),"Borrow Successful",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Log.d("tag1","in book");
                    Toast.makeText(getBaseContext(),"You cant Borrow more than 5 Books",Toast.LENGTH_LONG).show();
                }
            }
        });

        mMyBorrowings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity2.class);
                startActivity(i);
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}