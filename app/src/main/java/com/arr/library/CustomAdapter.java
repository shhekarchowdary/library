package com.arr.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Book> mBooks = new ArrayList<>();
    ArrayList<String> array1 = new ArrayList<>();
    ArrayList<String> array2 = new ArrayList<>();
    ArrayList<String> array3 = new ArrayList<>();
    LayoutInflater mInflater;

    public CustomAdapter(Context context, ArrayList<Book> mBooks) {
        mContext = context;
        this.mBooks = mBooks;
        for(Book book:this.mBooks){
            array1.add(book.getTitle());
            array2.add(book.getAuthorName());
            array3.add(book.getIsbn());
        }
        mInflater = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return mBooks.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.listview,null,true);
        TextView text1 = view.findViewById(R.id.textView);
        TextView text2 = view.findViewById(R.id.textView2);
        TextView text3 = view.findViewById(R.id.textView3);
        text1.setText(array1.get(i));
        text2.setText(array2.get(i));
        text3.setText(array3.get(i));
        return view;
    }
}
