package com.example.nckh1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nckh1.R;

import java.util.List;

public class TestAdapter extends BaseAdapter {
    Context context;
    List<Test> Test;
    private LayoutInflater mInflater;

    public TestAdapter(Context context, List<Test> test) {
        this.context = context;
        this.Test = test;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return Test.size();
    }

    @Override
    public Object getItem(int position) {
        return Test.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_test, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.img_avatar);
        TextView textView = convertView.findViewById(R.id.tv_name);
        imageView.setImageResource(Test.get(position).getResourceID());
        textView.setText(Test.get(position).getName());
        return convertView;
    }
}

