package com.example.fullcountryapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private  String[] countryname;
    private  int[] flag;
    Context context;
    private LayoutInflater inflater;


    
    public CustomAdapter(Context context, String[] countryname, int[] flag) {
        this.context= context;
        this.countryname = countryname;
        this.flag= flag;
    }

    @Override
    public int getCount() {
        return  countryname.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){

           inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               convertView = inflater.inflate(R.layout.sample_layout,parent,false);

        }


        ImageView imageView = convertView.findViewById(R.id.imgFlag_id);
        TextView textView = convertView.findViewById(R.id.TextViewTitle_id);

        imageView.setImageResource(flag[position]);
        textView.setText(countryname[position]);




        return convertView;
    }
}
