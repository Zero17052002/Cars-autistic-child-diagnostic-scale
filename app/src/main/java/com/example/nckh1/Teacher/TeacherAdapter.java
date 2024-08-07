package com.example.nckh1.Teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nckh1.Adapter.Test;
import com.example.nckh1.R;

import java.util.List;

public class TeacherAdapter extends BaseAdapter {
    Context context;
    List<Teacher> teacherList;
    private LayoutInflater mInflater;

    public TeacherAdapter(Context context, List<Teacher> teacherList) {
        this.context = context;
        this.teacherList = teacherList;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return teacherList.size();
    }

    @Override
    public Object getItem(int position) {
        return teacherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_teacher, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.tv_nameteacher);
        textView.setText(teacherList.get(position).getName());
        return convertView;
    }
}

