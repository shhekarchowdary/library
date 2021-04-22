package com.arr.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    HashMap<String,Double> dataMap = new HashMap<>();
    ArrayList<String> array1 = new ArrayList<>();
    ArrayList<Double> array2 = new ArrayList<>();
    LayoutInflater mInflater;

    public CustomAdapter(Context context, HashMap<String, Double> dataMap) {
        mContext = context;
        this.dataMap = dataMap;
        for(String s:this.dataMap.keySet()){
            array1.add(s);
            array2.add(this.dataMap.get(s));
        }
        mInflater = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return dataMap.size();
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
        text1.setText(array1.get(i));
        text2.setText(Double.toString(array2.get(i)));
        return view;
    }
}
