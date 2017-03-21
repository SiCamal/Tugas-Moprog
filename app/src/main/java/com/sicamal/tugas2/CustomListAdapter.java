package com.sicamal.tugas2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SiCamal on 3/20/2017.
 */

public class CustomListAdapter extends ArrayAdapter {
    ArrayList<Model> modelList = new ArrayList<>();
    Context context;

    public CustomListAdapter(Context context, int resource, ArrayList<Model> modelList) {
        super(context, resource);
        //passing data berupa text yang akan ditampilkan di baris
        //String bisa diganti class lain, misal ArrayList<Mahasiswa>
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.layoutlistview, null, true);
        TextView name = (TextView) convertView.findViewById(R.id.tvJudul);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.cbJudul);
        name.setText(modelList.get(position).getName());
        if(modelList.get(position).getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);


        return convertView;
    }

    @Override
    public int getCount() {
        //jumlah total baris
        return modelList.size();
    }
}

