package com.example.healthyfit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class calListAdapter extends BaseAdapter {

    private ArrayList<cal_dicListItem> arrayList = new ArrayList<>();

    public calListAdapter() {

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cal_diclist,viewGroup,false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView text1 = (TextView)view.findViewById(R.id.name);
        TextView text2 = (TextView)view.findViewById(R.id.cal);

        cal_dicListItem calListItem = arrayList.get(i);

        imageView.setImageDrawable(calListItem.getDrawable());
        text1.setText(calListItem.getText1());
        text2.setText(calListItem.getText2());

        return view;
    }
    public  void addItem(Drawable drawable, String text1, String text2){
        cal_dicListItem calListItem = new cal_dicListItem();
        calListItem.setDrawable(drawable);
        calListItem.setText1(text1);
        calListItem.setText2(text2);

        arrayList.add(calListItem);
    }
}